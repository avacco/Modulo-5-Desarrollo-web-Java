package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Calificacion;

public class CalificacionDAOImp implements CalificacionDAO {

	@Override
	public List<Calificacion> findAllCalificaciones() throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calificacion findCalificacionById(int asignaturaId,int estudianteId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM calificacion WHERE id_asignatura = ? AND id_estudiante = ? ORDER BY numeroevaluacion DESC LIMIT 1");
			) {
			ps.setInt(1, asignaturaId);
			ps.setInt(2, estudianteId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int numeroEvaluacion = rs.getInt("numeroevaluacion");
				float nota = rs.getFloat("nota");
				int idEstudiante = rs.getInt("id_estudiante");
				int idAsignatura = rs.getInt("id_asignatura");
				return new Calificacion(numeroEvaluacion,nota,idEstudiante,idAsignatura);
			}			
		}
		return null;
	}

	@Override
	public void createCalificacion(Calificacion calificacion) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO calificacion(numeroevaluacion, nota, id_estudiante, id_asignatura) VALUES (?,?,?,?)");

			) {
			ps.setInt(1, calificacion.getNumeroEvaluacion());
			ps.setFloat(2, calificacion.getNota());
			ps.setInt(3, calificacion.getId_estudiante());
			ps.setInt(4, calificacion.getId_asignatura());
			ps.executeUpdate();
		}

	}

	@Override
	public void editCalificacion(Calificacion calificacion) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCalificacion(int calificacionId) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Calificacion findLastCreatedCalificacion() throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
