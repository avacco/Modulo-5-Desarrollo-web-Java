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

import modelo.OrdenDeTrabajo;

public class OdtDAOImp implements OdtDAO {	
	
	@Override
	public List<OrdenDeTrabajo> findAllOrdenesDeTrabajo() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			
			// pedazo de query, ojala temporal, hasta que descubra como evitar que el servidor explote con varias queries anidadas.
			String query = "SELECT DISTINCT cliente.nombre AS cliente, electrodomestico.nombre as producto, ordendetrabajo.id_odt, ordendetrabajo.estado, ordendetrabajo.fechasolicitud, ordendetrabajo.fechaactualizacionorden, ordendetrabajo.id_electrodomestico\r\n"
				 		 + "FROM cliente, electrodomestico, ordendetrabajo\r\n"
						 + "WHERE cliente.id_cliente = electrodomestico.id_cliente \r\n"
						 + "AND ordendetrabajo.id_electrodomestico = electrodomestico.id_electrodomestico;\r\n"
						 + ";";
				
			ResultSet rs = st.executeQuery(query);
			List<OrdenDeTrabajo> ordenesDeTrabajo = new ArrayList<>();
			while(rs.next()) {
				int id 						 		 = rs.getInt("id_odt");
				String estado 				 		 = rs.getString("estado");
				LocalDate fechaSolicitud 		 	 = rs.getObject("fechasolicitud", LocalDate.class);
				LocalDate fechaActualizacionOrden 	 = rs.getObject("fechaactualizacionorden", LocalDate.class);
				int id_electrodomestico 			 = rs.getInt("id_electrodomestico");
				String producto						 = rs.getString("producto");
				String cliente						 = rs.getString("cliente");
				
				OrdenDeTrabajo ordenDeTrabajo		 = new OrdenDeTrabajo(id,estado,fechaSolicitud,fechaActualizacionOrden,id_electrodomestico,producto,cliente);
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
			ps.setInt(4, odt.getElectrodomestico_id());
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
