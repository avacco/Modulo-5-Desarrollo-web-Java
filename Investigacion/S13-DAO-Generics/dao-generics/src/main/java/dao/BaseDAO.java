package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

public interface BaseDAO<E, K> {
	
	//donde E es Entidad y K es Key
	
	
	public List<E> findAll() 		throws SQLException, NamingException;
	public E findById(K id) 		throws SQLException, NamingException;
	public void create(E entidad) 	throws SQLException, NamingException;
	public void edit(E entidad) 	throws SQLException, NamingException;
	public void remove(K id) 		throws SQLException, NamingException;
}
