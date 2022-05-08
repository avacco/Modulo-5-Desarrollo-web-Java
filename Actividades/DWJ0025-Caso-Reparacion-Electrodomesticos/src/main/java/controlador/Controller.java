package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.naming.NamingException;

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
		case "listarcli":	
			List<Cliente> clientes	= null;
			try {
				clientes 			= clientesDAO.findAllClientes();
			} catch ( Exception e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			request.setAttribute("clientes", clientes);			
			request.getRequestDispatcher("/WEB-INF/jsp/vista/listadocli.jsp").forward(request, response);
			break;
		
		case "listarpro":
			List<Electrodomestico>  electrodomesticos 	= null;
			try {
				electrodomesticos 	= electrodomesticosDAO.findAllElectrodomesticos();
			} catch(Exception e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			request.setAttribute("electrodomesticos", electrodomesticos);
			request.getRequestDispatcher("/WEB-INF/jsp/vista/listadopro.jsp").forward(request, response);
			break;
			
		case "listarodt":
			List<OrdenDeTrabajo> odt = null;
			try {
				odt = odtDAO.findAllOrdenesDeTrabajo();				
			} catch (Exception e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			request.setAttribute("odt", odt);	
			request.getRequestDispatcher("/WEB-INF/jsp/vista/listadoodt.jsp").forward(request, response);
			break;
		
		case "formulario":
			request.getRequestDispatcher("/WEB-INF/jsp/vista/formulario-paso1.jsp").forward(request, response);
			break;
			
		case "editar":
			// toma el id de la odt a editar
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				// la identifica a traves de un query y la asigna a un objeto odt
				OrdenDeTrabajo odtEdit = odtDAO.findOrdenDeTrabajoById(id);
				
				// envia el objeto odt a la pagina de editar orden, luego redirecciona hacia la misma
				request.setAttribute("odt", odtEdit);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/formulario-editar-orden.jsp").forward(request, response);
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			break;
			
		case "verODT":
			// toma el id de la odt a editar
			id = Integer.parseInt(request.getParameter("id"));
			try {
				// la identifica a traves de un query y la asigna a un objeto odt
				OrdenDeTrabajo odtEdit = odtDAO.findOrdenDeTrabajoById(id);
				
				// envia el objeto odt a la pagina de editar orden, luego redirecciona hacia la misma
				request.setAttribute("odt", odtEdit);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/odt-solo-lectura.jsp").forward(request, response);
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
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
				nuevoCliente = clientesDAO.findLastCreatedCliente();
				
				// pasa al siguiente paso
				request.setAttribute("cliente", nuevoCliente);
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
				
				// inmediatamente despues trae el ultimo electrodomestico añadido a la base de datos, reemplaza la variable del objeto antes creado y lo utiliza para crear una odt mas adelante
				electrodomestico = electrodomesticosDAO.findLastCreatedElectrodomestico();
				
				// toma valores de fecha para orden de trabajo
				LocalDate fecha = LocalDate.now();
				
				// crea una orden de trabajo con el electrodomestico en cuestion, estado fijo y la fecha de creacion
				String estado = "Pendiente";
				OrdenDeTrabajo odt = new OrdenDeTrabajo(estado,fecha,fecha,electrodomestico);
				odtDAO.createOrdenDeTrabajo(odt);
				
				
				
				// simula un "refresh" de la pagina utilizando los mismos datos que se recogieron antes
				request.setAttribute("cliente", cliente);
				request.getRequestDispatcher("/WEB-INF/jsp/vista/formulario-paso2.jsp").forward(request, response);		
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
			break;
			
		case "finalizar":
			idCliente = Integer.parseInt(request.getParameter("id"));
			
			try {
				Electrodomestico elec = electrodomesticosDAO.findElectrodomesticoByClienteId(idCliente);
				if(elec == null) {
					//elimina el ultimo cliente creado si no hay electrodomesticos asociados
					Cliente clienteAEliminar = clientesDAO.findLastCreatedCliente();
					clientesDAO.deleteCliente(clienteAEliminar.getId());
					
					// redirecciona junto a una alerta de que se ha cancelado la orden
					request.setAttribute("success", 0);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}

			} catch (SQLException | NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// redirecciona junto a una alerta de que se ha creado la orden de trabajo
			request.setAttribute("success", 1);
			request.getRequestDispatcher("index.jsp").forward(request, response);				
			break;
			
		case "finalizarEdit":
			// toma los id de los objetos asociados a la orden de trabajo
			int idOdt 				= Integer.parseInt(request.getParameter("idOdt"));
			idCliente 				= Integer.parseInt(request.getParameter("idCliente"));
			int idProducto 			= Integer.parseInt(request.getParameter("idElectrodomestico"));
			
			// toma el estado de la orden
			String estadoOrden 		= request.getParameter("estadoOrden");
			
			// toma los datos de los objetos asociados
				// electrodomestico

			nombreProducto 			= request.getParameter("nombreProducto");
			fallaProducto 			= request.getParameter("fallaProducto");
			
				// cliente
			String nombreCliente 	= request.getParameter("nombreCliente");
			String telefonoCliente 	= request.getParameter("telefonoCliente");
			String direccionCliente = request.getParameter("direccionCliente");
			
			// con todos los datos recabados, intenta editar el registro correspondiente de cada tabla
			try {
				electrodomestico 		= electrodomesticosDAO.findElectrodomesticoById(idProducto);
				cliente = electrodomestico.getCliente_id();
				
				// setea los nuevos datos en el objeto traido
				electrodomestico.setNombre(nombreProducto);
				electrodomestico.setFalla(fallaProducto);
				
				cliente.setNombre(nombreCliente);
				cliente.setTelefono(telefonoCliente);
				cliente.setDireccion(direccionCliente);
				
				// envia a editar los objetos ahora con los datos actualizados
				electrodomesticosDAO.editElectrodomestico(electrodomestico);
				clientesDAO.editCliente(cliente);
				
				// envia el objeto odt con los unicos datos relevantes, pues la fecha de actualizacion se hara en el mismo metodo de editar, y lo demas no se deberia cambiar en ningun caso.
				odtDAO.editOrdenDeTrabajo(new OrdenDeTrabajo(idOdt,estadoOrden));
				request.setAttribute("success", 2);
				request.getRequestDispatcher("index.jsp").forward(request, response);	
				
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
			}
			
			
		default:
			response.sendError(500);
		}
		
		
	}


	
}
