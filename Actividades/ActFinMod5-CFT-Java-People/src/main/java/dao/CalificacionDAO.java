package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Calificacion;
import modelo.Promedio;

public interface CalificacionDAO {

	public List<Calificacion> findAllCalificacionesById(int estudianteId) 					throws SQLException, NamingException;
	public Calificacion findCalificacionByForeignIds(int asignaturaId, int estudianteId)  	throws SQLException, NamingException;
	public Calificacion findCalificacionById(int calificacionId)  							throws SQLException, NamingException;
	public void createCalificacion(Calificacion calificacion)								throws SQLException, NamingException;
	public void editCalificacion(Calificacion calificacion)									throws SQLException, NamingException;
	public void deleteCalificacion(int calificacionId)										throws SQLException, NamingException;
	public Calificacion findLastCreatedCalificacion()										throws SQLException, NamingException;
	public List<Promedio> findAverageCalificacionById(int estudianteId)						throws SQLException, NamingException;
	
}
