package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet implementation class AlumnosController
 */
public class AlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlumnosController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Crea instancias
		List<Alumno> alumnos = Arrays.asList(
				new Alumno(1,"Pedro Pascal", "11223344-K", "Los Alerces 321", "Recoleta"),
				new Alumno(2,"Juan Garnizo", "12345678-9", "Miraflores 123", "Cerrillos"),
				new Alumno(3,"Diego Portales", "21345214-K", "Costanera del estrecho 1321 ", "Vitacura"),
				new Alumno(4,"Nicolas Cuyul", "12345123-K", "Manuel Bulnes 3379", "Santiago"),
				new Alumno(5,"Fernando Perez", "9231251-K", "Perez de Arce 8721", "Puente Alto")
				);
		//Define el atributo a enviar al JSP
		request.setAttribute("alumnos", alumnos);
		//Despacha al JSP
		request.getRequestDispatcher("/WEB-INF/jsp/vista/alumnos.jsp").forward(request, response);
		
	}

	

}
