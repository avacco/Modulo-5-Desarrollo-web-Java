package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Electrodomestico;
import modelo.OrdenDeTrabajo;

public class OdtDAOImp implements OdtDAO {

	ElectrodomesticosDAO electrodomesticosDAO;
	
	public OdtDAOImp(ElectrodomesticosDAO electrodomesticosDAO) {
		this.electrodomesticosDAO = electrodomesticosDAO;
	}
	
	
	@Override
	public List<OrdenDeTrabajo> findAllOrdenesDeTrabajo() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM ordendetrabajo");
			List<OrdenDeTrabajo> ordenesDeTrabajo = new ArrayList<>();
			while(rs.next()) {
				int id 						 		 = rs.getInt("id_odt");
				String estado 				 		 = rs.getString("estado");
				LocalDate fechaSolicitud 		 	 = rs.getObject("fechasolicitud", LocalDate.class);
				LocalDate fechaActualizacionOrden 	 = rs.getObject("fechaactualizacionorden", LocalDate.class);
				int id_electrodomestico 			 = rs.getInt("id_electrodomestico");
				Electrodomestico electrodomestico	 = electrodomesticosDAO.findElectrodomesticoById(id_electrodomestico);
				
				
				OrdenDeTrabajo ordenDeTrabajo = new OrdenDeTrabajo(id,estado,fechaSolicitud,fechaActualizacionOrden,electrodomestico);
				ordenesDeTrabajo.add(ordenDeTrabajo);
			}
			return ordenesDeTrabajo;
		}
	}

	@Override
	public OrdenDeTrabajo findOrdenDeTrabajoById(int odtId) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrdenDeTrabajo(OrdenDeTrabajo odt) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editOrdenDeTrabajo(OrdenDeTrabajo odt) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrdenDeTrabajo(int odtId) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}



}
