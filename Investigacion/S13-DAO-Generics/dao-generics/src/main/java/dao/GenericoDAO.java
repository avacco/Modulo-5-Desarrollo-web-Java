package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

public abstract class GenericoDAO<E, K> implements BaseDAO<E, K>{

	private String tabla;
	
	public GenericoDAO(String tabla) {
		this.tabla = tabla;
	}

	public abstract E makeObjectEntity(ResultSet rs) throws SQLException;
	
	@Override
	public List<E> findAll() throws SQLException, NamingException {
		String sql = String.format("SELECT * FROM %s", tabla);
		try (
			Connection conn = DBUtils.getConexion();
			Statement st = conn.createStatement();
		){
			ResultSet rs = st.executeQuery(sql);
			List<E> listado = new ArrayList<>();
			while(rs.next()) {
				E entidad = makeObjectEntity(rs);
				listado.add(entidad);
			}
			return listado;
		}
	}

	@Override
	public E findById(K id) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(E entidad) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(E entidad) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(K id) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}
	
	
}
