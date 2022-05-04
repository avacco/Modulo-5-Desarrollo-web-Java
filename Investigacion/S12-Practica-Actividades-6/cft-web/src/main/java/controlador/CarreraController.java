package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Carrera;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.naming.NamingException;


import dao.CarreraDAO;
import dao.CarreraDAOImp;


public class CarreraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CarreraController() {
        super();
    }

    private CarreraDAO carreraDAO;
	
    @Override
	public void init() throws ServletException {
		super.init();
		this.carreraDAO = new CarreraDAOImp();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Guarda el parametro pasado a traves despues del xxxx.jsp?xxxx en el formulario, en este caso xxxx?accion=xx
				String accion = request.getParameter("accion");
				
				
				switch(accion) {
					case "form":
						String vistaJSP = "/WEB-INF/jsp/vista/carrera/carrera-form.jsp";
						request.getRequestDispatcher(vistaJSP).forward(request, response);
						break;
					case "listar":
						try {
							List<Carrera> carreras = carreraDAO.getCarreras();
							request.setAttribute("carreras", carreras);
							vistaJSP = "/WEB-INF/jsp/vista/carrera/carrera-listado.jsp";
							request.getRequestDispatcher(vistaJSP).forward(request, response);
						} catch (SQLException | NamingException e) {
							e.printStackTrace();
							response.sendError(500);
						}
						break;
					case "eliminar":
						int carreraId = Integer.parseInt(request.getParameter("id"));
						try {
							carreraDAO.eliminarCarrera(carreraId);
						} catch (SQLException | NamingException e) {
							e.printStackTrace();
							response.sendError(500);
						}
							// redirecciona con la accion listar
							response.sendRedirect("/cft-web/CarreraController?accion=listar");
						break;
					case "editar":
						try {
							carreraId = Integer.parseInt(request.getParameter("id"));
							Carrera carrera = carreraDAO.getCarreraById(carreraId);
							vistaJSP = "/WEB-INF/jsp/vista/carrera/carrera-form.jsp";	
							request.setAttribute("carrera", carrera);
							request.getRequestDispatcher(vistaJSP).forward(request, response);
						} catch (SQLException | NamingException e) {
							e.printStackTrace();
							response.sendError(500);
						}				
						
						break;
					default:
						response.sendError(404);
				}	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// Inicializa variables a utilizar
				int id 						= 0;
				String nombre 				= request.getParameter("nombre");
				
				
				// Reemplaza variable id por parametros enviados desde formulario. Lo convierte a Integer si es valido, de lo contrario, echa un error.
				try {
					id = Integer.parseInt(request.getParameter("id"));
				} catch (NumberFormatException e) {
					System.err.println("id se setea a 0 de manera automatica");
				}

				if (id == 0) {
					Carrera carreraNueva = new Carrera(nombre);
					try {
						carreraDAO.crearCarrera(carreraNueva);
						response.sendRedirect("/cft-web/CarreraController?accion=listar");
					} catch (NamingException | SQLException e) {
						e.printStackTrace();
						response.sendError(500);
					}			
				} else {
					//editar
					Carrera CarreraAEditar = new Carrera(id,nombre);
					try {
						carreraDAO.editarCarrera(CarreraAEditar);
						response.sendRedirect("/cft-web/CarreraController?accion=listar");
					} catch (SQLException | NamingException e) {
						e.printStackTrace();
						response.sendError(500);
					}
				}	}

}
