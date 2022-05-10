package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Estudiante;

public class EstudianteDAOImp implements EstudianteDAO {

	@Override
	public List<Estudiante> findAllEstudiantes() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM estudiante");
			List<Estudiante> estudiantes = new ArrayList<>();
			while(rs.next()) {
				int id 					= rs.getInt("id_estudiante");
				String nombre1 			= rs.getString("nombre1");
				String nombre2 			= rs.getString("nombre2");
				String apellidoPaterno 	= rs.getString("apellidopaterno");
				String apellidoMaterno 	= rs.getString("apellidomaterno");
				String rut				= rs.getString("rut");
				String dv 				= rs.getString("dv");
				String genero			= rs.getString("genero");
				String fono 			= rs.getString("fono");
				String curso			= rs.getString("curso");
				
				Estudiante estudiante = new Estudiante(id,nombre1,nombre2,apellidoPaterno,apellidoMaterno,rut,dv,genero,fono,curso);
				estudiantes.add(estudiante);
			}
			return estudiantes;
		}
	}

	@Override
	public Estudiante findEstudianteById(int estudianteId) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEstudiante(Estudiante estudiante) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO estudiante(rut, dv, nombre1, nombre2, apellidomaterno, apellidopaterno, genero, fono, curso) VALUES (?,?,?,?,?,?,?,?,?)");

			) {
			// esto esta dando mas problemas de lo que pensaba, debi dejarlo como string y ya
			
			ps.setString(1, estudiante.getRut());
			ps.setString(2, estudiante.getDv());
			ps.setString(3, estudiante.getNombre1());
			ps.setString(4, estudiante.getNombre2());
			ps.setString(5, estudiante.getApellidoMaterno());
			ps.setString(6, estudiante.getApellidoPaterno());
			ps.setString(7, estudiante.getGenero());
			ps.setString(8, estudiante.getFono());
			ps.setString(9, estudiante.getCurso());
			ps.executeUpdate();
		}

	}

	@Override
	public void editEstudiante(Estudiante estudiante) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEstudiante(int estudianteId) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Estudiante findLastCreatedEstudiante() throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
