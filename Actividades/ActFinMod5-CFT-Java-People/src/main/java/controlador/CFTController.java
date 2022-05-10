package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Estudiante;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.AsignaturaDAO;
import dao.AsignaturaDAOImp;
import dao.EstudianteDAO;
import dao.EstudianteDAOImp;

public class CFTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EstudianteDAO estudianteDAO;
	private AsignaturaDAO asignaturaDAO;
	
	@Override
	public void init() throws ServletException{
		super.init();
		this.estudianteDAO = new EstudianteDAOImp();
		this.asignaturaDAO = new AsignaturaDAOImp();
		
	}
	
    public CFTController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch(accion) {
		case "listar":
			List<Estudiante> estudiantes = null;
			try {
				estudiantes = estudianteDAO.findAllEstudiantes();
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			request.setAttribute("estudiantes", estudiantes);
			request.getRequestDispatcher("/WEB-INF/jsp/vista/lista-alumnos.jsp").forward(request, response);
			break;
			
		case "formulario":
			/* ESTO NO VA AQUI
			List<Asignatura> asignaturas = null;
			try {
				asignaturas = asignaturaDAO.findAllAsignaturas();
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			request.setAttribute("asignaturas", asignaturas);
			*/
			request.getRequestDispatcher("/WEB-INF/jsp/vista/form-estudiantes.jsp").forward(request, response);
			break;
			
		default:
			response.sendError(500);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch(accion) {
		case "addEstudiante":
				String nombre1			= request.getParameter("nombre1");
				String nombre2 			= request.getParameter("nombre2");
				String apellidoPaterno 	= request.getParameter("apellidoPaterno");
				String apellidoMaterno 	= request.getParameter("apellidoMaterno");
				String rut 				= request.getParameter("rut");
				String dv 				= request.getParameter("dv");
				String genero 			= request.getParameter("genero");
				String fono 			= request.getParameter("fono");
				String curso 			= request.getParameter("curso");
				
				// si el usuario no cambio las opciones por default, redirecciona de vuelta y muestra el mensaje de error correspondiente
				if(genero.equals("none")) {
					request.setAttribute("codigo", 0);
					request.getRequestDispatcher("/WEB-INF/jsp/vista/form-estudiantes.jsp").forward(request, response);
					break;
				}
				
				if(curso.equals("none")) {
					request.setAttribute("codigo", 1);
					request.getRequestDispatcher("/WEB-INF/jsp/vista/form-estudiantes.jsp").forward(request, response);
					break;
				}
				
				// si todo esta en orden, pasa a la creacion del estudiante
				Estudiante estudiante = new Estudiante(nombre1,nombre2,apellidoPaterno,apellidoMaterno,rut,dv,genero,fono,curso);
				try {
					estudianteDAO.createEstudiante(estudiante);
					request.setAttribute("codigo", 1);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				} catch (SQLException | NamingException e) {
					// ante un error, redirecciona al indice y muestra una alerta
					request.setAttribute("codigo", 0);
					request.getRequestDispatcher("index.jsp").forward(request, response);
					e.printStackTrace();
				}
				
				
				break;
			
		default:
			response.sendError(500);
			break;
		}
	}
}
