package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		
		switch(accion) {
		case "listar":
			try {
				List<Cliente> clientes = getClientes();
				List<Electrodomestico> electrodomesticos = getElectrodomesticos();
				List<OrdenDeTrabajo> odt = getODT();
				request.setAttribute("clientes", clientes);
				request.setAttribute("electrodomesticos", electrodomesticos);				
				request.setAttribute("odt", odt);				
				request.getRequestDispatcher("/WEB-INF/jsp/vista/listado.jsp").forward(request, response);

			} catch (SQLException | NamingException e) {
				response.sendError(500);
				e.printStackTrace();
			}
			break;
		default:
			response.sendError(500);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public Connection getConexion() throws NamingException, SQLException {
		InitialContext initialContext = new InitialContext();
		DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/postgres");
		return dataSource.getConnection();
	}
	
	private List<Cliente> getClientes() throws SQLException, NamingException {
		try(
				Connection conn = getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM cliente");
			List<Cliente> clientes = new ArrayList<Cliente>();
			while(rs.next()) {
				int id = rs.getInt("id_cliente");
				String nombre = rs.getString("Nombre");
				String telefono = rs.getString("Telefono");
				String direccion = rs.getString("Direccion");
				Cliente cliente = new Cliente(id,nombre,telefono,direccion);
				clientes.add(cliente);
			}
			return clientes;
		}
	}
	
	private List<Electrodomestico> getElectrodomesticos() throws SQLException, NamingException {
		try(
				Connection conn = getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT electrodomestico.id_electrodomestico, electrodomestico.nombre, electrodomestico.falla, cliente.nombre AS asignado FROM electrodomestico, cliente WHERE electrodomestico.id_cliente = cliente.id_cliente");
			List<Electrodomestico> electrodomesticos = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id_electrodomestico");
				String nombre = rs.getString("Nombre");
				String falla = rs.getString("Falla");
				String cliente = rs.getString("asignado");
				Electrodomestico electrodomestico= new Electrodomestico(id,nombre,falla,cliente);
				electrodomesticos.add(electrodomestico);
			}
			return electrodomesticos;
		}
	}
	
	private List<OrdenDeTrabajo> getODT() throws SQLException, NamingException {
		try(
				Connection conn = getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT ordendetrabajo.id_odt, ordendetrabajo.estado, ordendetrabajo.fechasolicitud, ordendetrabajo.fechaactualizacionorden, electrodomestico.nombre AS objeto, cliente.nombre AS asignado FROM ordendetrabajo, electrodomestico, cliente WHERE ordendetrabajo.id_electrodomestico = electrodomestico.id_electrodomestico AND electrodomestico.id_cliente = cliente.id_cliente");
			List<OrdenDeTrabajo> ordenesDeTrabajo = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id_odt");
				String objeto = rs.getString("objeto");
				String estado = rs.getString("estado");
				String cliente = rs.getString("asignado");
				String fechaSolicitud = rs.getString("fechasolicitud");
				String fechaActualizacionOrden = rs.getString("fechaactualizacionorden");
				OrdenDeTrabajo ordenDeTrabajo= new OrdenDeTrabajo(id,objeto,estado,cliente,fechaSolicitud,fechaActualizacionOrden);
				ordenesDeTrabajo.add(ordenDeTrabajo);
			}
			return ordenesDeTrabajo;
		}
	}
	
}
