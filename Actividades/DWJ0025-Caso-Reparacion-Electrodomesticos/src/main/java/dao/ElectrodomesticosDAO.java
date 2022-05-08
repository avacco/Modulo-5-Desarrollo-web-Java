package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Cliente;
import modelo.Electrodomestico;

public interface ElectrodomesticosDAO {

	public List<Electrodomestico> findAllElectrodomesticos() 							throws SQLException, NamingException;
	public Electrodomestico findElectrodomesticoById(int electrodomesticoId)  			throws SQLException, NamingException;
	public Electrodomestico findElectrodomesticoByClienteId(int clienteId)			  	throws SQLException, NamingException;
	public void createElectrodomestico(Electrodomestico electrodomestico)				throws SQLException, NamingException;
	public void editElectrodomestico(Electrodomestico electrodomestico)					throws SQLException, NamingException;
	public void deleteElectrodomestico(int electrodomesticoId)							throws SQLException, NamingException;
	public Electrodomestico findLastCreatedElectrodomestico()							throws SQLException, NamingException;
}
