package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Estudiante;

public interface EstudianteDAO {

	public List<Estudiante> findAllEstudiantes() 				throws SQLException, NamingException;
	public Estudiante findEstudianteById(int estudianteId)  	throws SQLException, NamingException;
	public void createEstudiante(Estudiante estudiante)			throws SQLException, NamingException;
	public void editEstudiante(Estudiante estudiante)			throws SQLException, NamingException;
	public void deleteEstudiante(int estudianteId)				throws SQLException, NamingException;
	public Estudiante findLastCreatedEstudiante()				throws SQLException, NamingException;
}
