package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Alumno;

public interface AlumnoDAO {

	public List<Alumno> getAlumnos() throws SQLException, NamingException;
	public Alumno getAlumnoById(int alumnoId) throws SQLException, NamingException;
	public void crearAlumno(Alumno alumno) throws SQLException, NamingException;
	public void editarAlumno(Alumno alumno) throws SQLException, NamingException;
	public void eliminarAlumno(int alumnoId) throws SQLException, NamingException;
	
}
