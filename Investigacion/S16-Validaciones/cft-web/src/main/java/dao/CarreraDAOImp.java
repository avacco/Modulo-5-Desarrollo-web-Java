package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Carrera;

public class CarreraDAOImp implements CarreraDAO{

	@Override
	public List<Carrera> getCarreras() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
				ResultSet rs = st.executeQuery("SELECT * FROM carrerasact");
				List<Carrera> carreras = new ArrayList<>();
				while(rs.next()) {
					// Recupera variables de datos de la tabla
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					// Instancia objeto Carrera
					Carrera carrera = new Carrera(id,nombre);
					// Lo añade a la lista
					carreras.add(carrera);
				}
				return carreras;
			}
	}

	@Override
	public Carrera getCarreraById(int carreraId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM carrerasact WHERE ID = ?");
			) {

				ps.setInt(1, carreraId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					return new Carrera(id,nombre);
				}else {
					return null;
				}
			} 
	}

	@Override
	public void crearCarrera(Carrera carrera) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO carrerasact(nombre) VALUES (?)");

			) {
				ps.setString(1, carrera.getNombre());
				ps.executeUpdate();			
			}
		
	}

	@Override
	public void editarCarrera(Carrera carrera) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("UPDATE carrerasact SET nombre = ? WHERE id = ?");
			) {

				ps.setString(1, carrera.getNombre());
				ps.setInt(2, carrera.getId());
				ps.executeUpdate();
			} 
		
	}

	@Override
	public void eliminarCarrera(int carreraId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("DELETE FROM carrerasact WHERE ID = ?");
			) {
				ps.setInt(1, carreraId);
				ps.executeUpdate();
			} 
		
	}

}
