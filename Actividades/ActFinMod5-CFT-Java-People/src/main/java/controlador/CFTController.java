package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Asignatura;
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
			List<Asignatura> asignaturas = null;
			try {
				asignaturas = asignaturaDAO.findAllAsignaturas();
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
				return;
			}
			request.setAttribute("asignaturas", asignaturas);
			request.getRequestDispatcher("/WEB-INF/jsp/vista/form-estudiantes.jsp").forward(request, response);
			break;
			
		default:
			response.sendError(500);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
