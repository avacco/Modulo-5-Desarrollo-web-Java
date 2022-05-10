package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Asignatura;
import modelo.Calificacion;
import modelo.Estudiante;
import modelo.Promedio;

public class CalificacionDAOImp implements CalificacionDAO {
	
	private EstudianteDAO estudianteDAO;
	private AsignaturaDAO asignaturaDAO;
	
	
	public CalificacionDAOImp(EstudianteDAO estudianteDAO, AsignaturaDAO asignaturaDAO) {
		this.estudianteDAO = estudianteDAO;
		this.asignaturaDAO = asignaturaDAO;
	}

	@Override
	public List<Calificacion> findAllCalificacionesById(int estudianteId)  throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM calificacion WHERE id_estudiante = ?");
			) {
			ps.setInt(1, estudianteId);
			ResultSet rs = ps.executeQuery();
			List<Calificacion> calificaciones = new ArrayList<>();
			while(rs.next()) {
				int id					= rs.getInt("id_calificacion");
				int numeroEvaluacion 	= rs.getInt("numeroEvaluacion");
				float nota 				= rs.getFloat("nota");
				int id_estudiante	 	= rs.getInt("id_estudiante");
				int id_asignatura 		= rs.getInt("id_asignatura");
				
				Estudiante estudiante = estudianteDAO.findEstudianteById(id_estudiante);
				Asignatura asignatura = asignaturaDAO.findAsignaturaById(id_asignatura);
				
				Calificacion calificacion = new Calificacion(id,numeroEvaluacion,nota,estudiante,asignatura);
				calificaciones.add(calificacion);
			}
			return calificaciones;
		}
	}

	@Override
	public Calificacion findCalificacionByForeignIds(int asignaturaId,int estudianteId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM calificacion WHERE id_asignatura = ? AND id_estudiante = ? ORDER BY numeroevaluacion DESC LIMIT 1");
			) {
			ps.setInt(1, asignaturaId);
			ps.setInt(2, estudianteId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int numeroEvaluacion 	= rs.getInt("numeroevaluacion");
				float nota 				= rs.getFloat("nota");
				int idEstudiante 		= rs.getInt("id_estudiante");
				int idAsignatura 		= rs.getInt("id_asignatura");
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
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("UPDATE calificacion SET nota = ? WHERE id_calificacion = ?");
			) {
			ps.setFloat(1, calificacion.getNota());
			ps.setInt(2, calificacion.getId_calificacion());
			ps.executeUpdate();
		}

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

	@Override
	public Calificacion findCalificacionById(int calificacionId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM calificacion WHERE id_calificacion = ?");
			) {
			ps.setInt(1, calificacionId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id					= rs.getInt("id_calificacion");
				int numeroEvaluacion 	= rs.getInt("numeroEvaluacion");
				float nota 				= rs.getFloat("nota");
				int id_estudiante	 	= rs.getInt("id_estudiante");
				int id_asignatura 		= rs.getInt("id_asignatura");
				
				Estudiante estudiante = estudianteDAO.findEstudianteById(id_estudiante);
				Asignatura asignatura = asignaturaDAO.findAsignaturaById(id_asignatura);
				
				return new Calificacion(id,numeroEvaluacion,nota,estudiante,asignatura);
				
				
				
			}			
		}
		return null;
	}

	@Override
	public List<Promedio> findAverageCalificacionById(int estudianteId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT id_asignatura, id_estudiante, AVG(nota) FROM calificacion WHERE id_estudiante = ? GROUP BY id_asignatura, id_estudiante");
			) {
			ps.setInt(1, estudianteId);
			ResultSet rs = ps.executeQuery();
			List<Promedio> promedios = new ArrayList<>(); 
			while(rs.next()) {
				float average 					= rs.getFloat("avg");
				int id_asignatura 				= rs.getInt("id_asignatura");
				int id_estudiante 				= rs.getInt("id_estudiante");
				
				Estudiante estudiante = estudianteDAO.findEstudianteById(id_estudiante);
				Asignatura asignatura = asignaturaDAO.findAsignaturaById(id_asignatura);
				
				Promedio promedio = new Promedio(average,asignatura,estudiante);
				
				promedios.add(promedio); 
				
			}	
			return promedios;
		}
	}

}
