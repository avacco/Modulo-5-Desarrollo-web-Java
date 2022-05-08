package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
private ElectrodomesticosDAO electrodomesticosDAO;
	
	public OdtDAOImp(ElectrodomesticosDAO electrodomesticosDAO) {
		this.electrodomesticosDAO = electrodomesticosDAO;
	}
	
	@Override
	public List<OrdenDeTrabajo> findAllOrdenesDeTrabajo() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			
			String query = "SELECT * FROM ordendetrabajo";				
			ResultSet rs = st.executeQuery(query);
			List<OrdenDeTrabajo> ordenesDeTrabajo = new ArrayList<>();
			while(rs.next()) {
				int id 						 		 = rs.getInt("id_odt");
				String estado 				 		 = rs.getString("estado");
				LocalDate fechaSolicitud 		 	 = rs.getObject("fechasolicitud", LocalDate.class);
				LocalDate fechaActualizacionOrden 	 = rs.getObject("fechaactualizacionorden", LocalDate.class);
				int id_electrodomestico 			 = rs.getInt("id_electrodomestico");
				
				Electrodomestico electrodomestico = electrodomesticosDAO.findElectrodomesticoById(id_electrodomestico);

				OrdenDeTrabajo ordenDeTrabajo		 = new OrdenDeTrabajo(id,estado,fechaSolicitud,fechaActualizacionOrden,electrodomestico);
				ordenesDeTrabajo.add(ordenDeTrabajo);
			}
			return ordenesDeTrabajo;
		}
	}
	
	@Override
	public OrdenDeTrabajo findOrdenDeTrabajoById(int odtId) throws SQLException, NamingException {
		return null;
	}

	@Override
	public void createOrdenDeTrabajo(OrdenDeTrabajo odt) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO ordendetrabajo(estado, fechasolicitud, fechaactualizacionorden, id_electrodomestico) VALUES (?,?,?,?)");

			) {
			ps.setString(1, odt.getEstado());
			ps.setObject(2, odt.getFechaSolicitud());
			ps.setObject(3, odt.getFechaActualizacionOrden());
			ps.setInt(4, odt.getElectrodomestico_id().getId());
			ps.executeUpdate();
		}
		
	}

	@Override
	public void editOrdenDeTrabajo(OrdenDeTrabajo odt) throws SQLException, NamingException {
		
	}

	@Override
	public void deleteOrdenDeTrabajo(int odtId) throws SQLException, NamingException {
		
	}


	@Override
	public OrdenDeTrabajo findLastCreatedOrdenDeTrabajo() throws SQLException, NamingException {
		
		return null;
		
	}



}
