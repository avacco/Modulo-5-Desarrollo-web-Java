package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Cliente;
import modelo.Electrodomestico;

public class ElectrodomesticosDAOImp implements ElectrodomesticosDAO {

	private ClientesDAO clientesDAO;
	
	public ElectrodomesticosDAOImp(ClientesDAO clientesDAO) {
		this.clientesDAO = clientesDAO;
	}
	
	
	@Override
	public List<Electrodomestico> findAllElectrodomesticos() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM electrodomestico");
			List<Electrodomestico> electrodomesticos = new ArrayList<>();
			while(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int idCliente 		= rs.getInt("id_cliente");
				Cliente cliente 	= clientesDAO.findClienteById(idCliente);
				
				Electrodomestico electrodomestico= new Electrodomestico(id,nombre,falla,cliente);
				electrodomesticos.add(electrodomestico);
			}
			return electrodomesticos;
		}
	}

	@Override
	public Electrodomestico findElectrodomesticoById(int electrodomesticoId) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM Electrodomestico WHERE id_electrodomestico = ?");
			) {
			ps.setInt(1, electrodomesticoId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int idCliente 		= rs.getInt("id_cliente");
				Cliente cliente 	= clientesDAO.findClienteById(idCliente);
				
				return new Electrodomestico(id,nombre,falla,cliente);
			}
			
		}
		return null;
	}

	@Override
	public void createElectrodomestico(Electrodomestico electrodomestico) throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO electrodomestico(nombre, falla, id_cliente) VALUES (?,?,?)");

			) {
			ps.setString(1, electrodomestico.getNombre());
			ps.setString(2, electrodomestico.getFalla());
			ps.setInt(3, electrodomestico.getCliente_id().getId());
			ps.executeUpdate();
			
		}
		
	}

	@Override
	public void editElectrodomestico(Electrodomestico electrodomestico) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteElectrodomestico(int electrodomesticoId) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Electrodomestico findLastCreatedElectrodomestico() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM electrodomestico ORDER BY id_electrodomestico DESC LIMIT 1");
			if(rs.next()) {
				int id 				= rs.getInt("id_electrodomestico");
				String nombre 		= rs.getString("Nombre");
				String falla 		= rs.getString("Falla");
				int idCliente 		= rs.getInt("id_cliente");
				Cliente cliente 	= clientesDAO.findClienteById(idCliente);
				return new Electrodomestico(id,nombre,falla,cliente);
			}
			
		}
		return null;
	}
	


}
