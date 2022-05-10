package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Asignatura;

public class AsignaturaDAOImp implements AsignaturaDAO {

	@Override
	public List<Asignatura> findAllAsignaturas() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM asignatura");
			List<Asignatura> asignaturas = new ArrayList<>();
			while(rs.next()) {
				int id			= rs.getInt("id_asignatura");
				String nombre 	= rs.getString("nombre");
				
				Asignatura asignatura = new Asignatura(id,nombre);
				asignaturas.add(asignatura);
				
			}
			return asignaturas;
		}
	}

	@Override
	public Asignatura findAsignaturaById(int asignaturaId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM asignatura WHERE id_asignatura = ?");
			) {
			ps.setInt(1, asignaturaId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id			= rs.getInt("id_asignatura");
				String nombre 	= rs.getString("nombre");
				
				return new Asignatura(id,nombre);
			}
			
		}
		return null;
	}

	@Override
	public void createAsignatura(Asignatura asignatura) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void editAsignatura(Asignatura asignatura) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAsignatura(int asignaturaId) throws SQLException, NamingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Asignatura findLastCreatedAsignatura() throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
