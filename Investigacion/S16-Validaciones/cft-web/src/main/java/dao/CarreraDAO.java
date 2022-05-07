package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Carrera;

public interface CarreraDAO {

	public List<Carrera> getCarreras() throws SQLException, NamingException;
	public Carrera getCarreraById(int carreraId) throws SQLException, NamingException;
	public void crearCarrera(Carrera carrera) throws SQLException, NamingException;
	public void editarCarrera(Carrera carrera) throws SQLException, NamingException;
	public void eliminarCarrera(int carreraId) throws SQLException, NamingException;
}
