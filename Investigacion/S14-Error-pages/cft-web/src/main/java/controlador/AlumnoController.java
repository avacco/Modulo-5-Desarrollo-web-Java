package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Carrera;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.AlumnoDAO;
import dao.AlumnoDAOImp;
import dao.CarreraDAO;
import dao.CarreraDAOImp;

public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CarreraDAO carreraDAO;
    private AlumnoDAO alumnoDAO;
	
    @Override
	public void init() throws ServletException {
		super.init();
		this.carreraDAO = new CarreraDAOImp();
		this.alumnoDAO = new AlumnoDAOImp(this.carreraDAO);
	}


	public AlumnoController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Guarda el parametro pasado a traves despues del xxxx.jsp?xxxx en el formulario, en este caso xxxx?accion=xx
		String accion = request.getParameter("accion");
		
		
		switch(accion) {
			case "form":
				List<Carrera> carreras = null;
				try {
					carreras = carreraDAO.getCarreras();
				} catch (Exception e) {
					e.printStackTrace();
					response.sendError(500);
					return;
				}
				request.setAttribute("carreras", carreras);
				String vistaJSP = "/WEB-INF/jsp/vista/alumno/alumno-form.jsp";
				request.getRequestDispatcher(vistaJSP).forward(request, response);
				break;
				
			case "listar":
				try {
					List<Alumno> alumnos = alumnoDAO.getAlumnos();
					request.setAttribute("alumnos", alumnos);
					vistaJSP = "/WEB-INF/jsp/vista/alumno/alumno-listado.jsp";
					request.getRequestDispatcher(vistaJSP).forward(request, response);
				} catch (SQLException | NamingException e) {
					e.printStackTrace();
					response.sendError(500);
				}
				break;
				
			case "eliminar":
				int alumnoId = Integer.parseInt(request.getParameter("id"));
				try {
					alumnoDAO.eliminarAlumno(alumnoId);
				} catch (SQLException | NamingException e) {
					e.printStackTrace();
					response.sendError(500);
				}
					// redirecciona con la accion listar
					response.sendRedirect("/cft-web/AlumnoController?accion=listar");
				break;
				
			case "editar":
				try {
					alumnoId = Integer.parseInt(request.getParameter("id"));
					Alumno alumno = alumnoDAO.getAlumnoById(alumnoId);
					carreras = null;
					carreras = carreraDAO.getCarreras();
					vistaJSP = "/WEB-INF/jsp/vista/alumno/alumno-form.jsp";	
					request.setAttribute("alumno", alumno);
					request.setAttribute("carreras", carreras);
					request.getRequestDispatcher(vistaJSP).forward(request, response);
				} catch (SQLException | NamingException e) {
					e.printStackTrace();
					response.sendError(500);
				}				
				
				break;
			default:
				response.sendError(404);
		}
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Inicializa variables a utilizar
		int id 						= 0;
		String nombre 				= request.getParameter("nombre");
		int carreraId 				= Integer.parseInt( request.getParameter("carrera_id"));
		Carrera carrera 			= null;
		
		try {
			carrera 			= carreraDAO.getCarreraById(carreraId);
		} catch (SQLException | NamingException e1) {
			response.sendError(500);
			e1.printStackTrace();
			return;
		}
		
		
		// Convierte el string recibido de HTML5 input date a LocalDate de java
		// El string se envia en el formato YYYY-MM-DD
		LocalDate fechaNacimiento 	= LocalDate.parse(request.getParameter("nacimiento"));
		
		// Reemplaza variable id por parametros enviados desde formulario. Lo convierte a Integer si es valido, de lo contrario, echa un error.
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			System.err.println("id se setea a 0 de manera automatica");
		}

		// Crea el alumno si la id es 0
		if (id == 0) {
			Alumno alumnoNuevo = new Alumno(nombre,carrera,fechaNacimiento);
			try {
				alumnoDAO.crearAlumno(alumnoNuevo);
				response.sendRedirect("/cft-web/AlumnoController?accion=listar");
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
				response.sendError(500);
			}			
		} else {
			//editar
			Alumno alumnoAEditar = new Alumno(id,nombre,carrera,fechaNacimiento);
			try {
				alumnoDAO.editarAlumno(alumnoAEditar);
				response.sendRedirect("/cft-web/AlumnoController?accion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
	}

	

}
