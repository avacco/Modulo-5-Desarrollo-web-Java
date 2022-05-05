package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.ClientesDAO;
import dao.ClientesDAOImp;
import dao.ElectrodomesticosDAO;
import dao.ElectrodomesticosDAOImp;
import dao.OdtDAO;
import dao.OdtDAOImp;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ClientesDAO clientesDAO;
	private ElectrodomesticosDAO electrodomesticosDAO;
	private OdtDAO odtDAO;
	
	@Override
	public void init() throws ServletException{
		super.init();
		this.clientesDAO = new ClientesDAOImp();
		this.electrodomesticosDAO = new ElectrodomesticosDAOImp(this.clientesDAO);
		this.odtDAO = new OdtDAOImp(this.electrodomesticosDAO);
	}
	
    public Controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		
		switch(accion) {
		case "listar":	
			List<Cliente> 			clientes			= null;
			List<Electrodomestico>  electrodomesticos 	= null;
			List<OrdenDeTrabajo> 	odt 				= null;
			try {
				clientes 			= clientesDAO.findAllClientes();
				electrodomesticos 	= electrodomesticosDAO.findAllElectrodomesticos();
				odt 				= odtDAO.findAllOrdenesDeTrabajo();
			} catch ( Exception e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
				
				request.setAttribute("clientes", clientes);
				request.setAttribute("electrodomesticos", electrodomesticos);				
				request.setAttribute("odt", odt);				
				request.getRequestDispatcher("/WEB-INF/jsp/vista/listado.jsp").forward(request, response);

			
			break;
		
		case "formulario":
			request.getRequestDispatcher("/WEB-INF/jsp/vista/formulario-paso1.jsp").forward(request, response);
			break;		
		default:
			response.sendError(500);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch(accion) {
		case "addCliente":
			// toma los datos para la creacion del cliente
			String nombre 		= request.getParameter("nombre");
			String telefono 	= request.getParameter("telefono");
			String direccion	= request.getParameter("direccion");
			
			//crea el objeto
			Cliente nuevoCliente = new Cliente(nombre,telefono,direccion);
			
			try {
				// añade el cliente a la base de datos
				clientesDAO.createCliente(nuevoCliente);
				
				// una vez añadido a la base de datos, y ya con su id asignado por la misma, lo devuelve para su uso en el siguiente paso
				Cliente cliente = clientesDAO.findLastCreatedCliente();
				
				// pasa al siguiente paso
				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/formulario-paso2.jsp").forward(request, response);				
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			break;
		
		case "addElectrodomestico":
			// trae el id del cliente guardado para crear el objeto cliente, utilizando el metodo buscar
			int idCliente = Integer.parseInt(request.getParameter("id"));
			
			// busca el cliente registrado
			Cliente cliente = null;
			try {
				cliente = clientesDAO.findClienteById(idCliente);
			} catch (SQLException | NamingException e1) {
				e1.printStackTrace();
				response.sendError(500);
			}
			
			// trae los datos del producto
			String nombreProducto 	= request.getParameter("nombreProducto");
			String fallaProducto 	= request.getParameter("fallaProducto");

			// crea el producto
			Electrodomestico electrodomestico = new Electrodomestico(nombreProducto,fallaProducto,cliente);

			
			try {
				// añade el producto a la base de datos
				electrodomesticosDAO.createElectrodomestico(electrodomestico);
				
				// simula un "refresh" de la pagina utilizando los mismos datos que se recogieron antes
				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/formulario-paso2.jsp").forward(request, response);		
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			break;
			
		case "finalizar":
			request.getRequestDispatcher("index.jsp").forward(request, response);				
			break;
			
		default:
			response.sendError(500);
		}
		
		
	}


	
}
