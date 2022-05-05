package dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.OrdenDeTrabajo;

public interface OdtDAO {
	
	public List<OrdenDeTrabajo> findAllOrdenesDeTrabajo() 	throws SQLException, NamingException;
	public OrdenDeTrabajo findOrdenDeTrabajoById(int odtId) throws SQLException, NamingException;
	public void createOrdenDeTrabajo(OrdenDeTrabajo odt)	throws SQLException, NamingException;
	public void editOrdenDeTrabajo(OrdenDeTrabajo odt)		throws SQLException, NamingException;
	public void deleteOrdenDeTrabajo(int odtId)				throws SQLException, NamingException;

}
