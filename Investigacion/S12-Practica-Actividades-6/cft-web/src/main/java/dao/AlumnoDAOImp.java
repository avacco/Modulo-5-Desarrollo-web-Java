package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Alumno;
import modelo.Carrera;

public class AlumnoDAOImp implements AlumnoDAO{

	private CarreraDAO carreraDAO;
	
	public AlumnoDAOImp(CarreraDAO carreraDAO) {
		this.carreraDAO = carreraDAO;
	}
	
	
	@Override
	public List<Alumno> getAlumnos() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
				ResultSet rs = st.executeQuery("SELECT * FROM alumnosact");
				List<Alumno> alumnos = new ArrayList<>();
				while(rs.next()) {
					// Recupera variables de datos de la tabla
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					int carreraId = Integer.parseInt(rs.getString("carrera_id"));
					Carrera carrera = carreraDAO.getCarreraById(carreraId);
					LocalDate fechaNacimiento 	= rs.getObject("fecha_nacimiento", LocalDate.class);
					// Instancia objeto Alumno
					Alumno alumno = new Alumno(id,nombre,carrera,fechaNacimiento);
					// Lo añade a la lista
					alumnos.add(alumno);
				}
				return alumnos;
			}
	}

	@Override
	public Alumno getAlumnoById(int alumnoId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM alumnosact WHERE ID = ?");
			) {

				ps.setInt(1, alumnoId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					int carreraId = Integer.parseInt(rs.getString("carrera_id"));
					Carrera carrera = carreraDAO.getCarreraById(carreraId);
					LocalDate fechaNacimiento 	= rs.getObject("fecha_nacimiento", LocalDate.class);
					return new Alumno(id,nombre,carrera,fechaNacimiento);
				}else {
					return null;
				}
			} 
	}

	@Override
	public void crearAlumno(Alumno alumno) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO alumnosact(nombre,carrera_id,fecha_nacimiento) VALUES (?,?,?)");

			) {
				ps.setString(1, alumno.getNombre());
				ps.setInt(2, alumno.getCarrera().getId());
				ps.setObject(3, alumno.getFechaNacimiento());
				ps.executeUpdate();			
			}
		
	}

	@Override
	public void editarAlumno(Alumno alumno) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("UPDATE alumnosact SET nombre = ?, carrera_id = ?, fecha_nacimiento = ? WHERE id = ?");
			) {

				ps.setString(1, alumno.getNombre());
				ps.setInt(2, alumno.getCarrera().getId());
				ps.setObject(3, alumno.getFechaNacimiento());
				ps.setInt(4, alumno.getId());
				ps.executeUpdate();
			} 
		
	}

	@Override
	public void eliminarAlumno(int alumnoId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM alumnosact WHERE ID = ?");
			) {
				ps.setInt(1, alumnoId);
				ps.executeUpdate();
			} 
		
	}

	
}
