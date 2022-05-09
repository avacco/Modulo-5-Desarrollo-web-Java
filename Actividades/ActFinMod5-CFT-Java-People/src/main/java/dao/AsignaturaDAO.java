package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Asignatura;

public interface AsignaturaDAO {

	public List<Asignatura> findAllAsignaturas() 				throws SQLException, NamingException;
	public Asignatura findAsignaturaById(int asignaturaId)  	throws SQLException, NamingException;
	public void createAsignatura(Asignatura asignatura)			throws SQLException, NamingException;
	public void editAsignatura(Asignatura asignatura)			throws SQLException, NamingException;
	public void deleteAsignatura(int asignaturaId)				throws SQLException, NamingException;
	public Asignatura findLastCreatedAsignatura()				throws SQLException, NamingException;
}
