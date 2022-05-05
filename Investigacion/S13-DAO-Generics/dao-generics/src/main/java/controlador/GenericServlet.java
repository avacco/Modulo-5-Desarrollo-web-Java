package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import dao.AlumnoDAO;
import dao.AlumnoDAOImp;

public class GenericServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenericServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlumnoDAO alumnoDAO = new AlumnoDAOImp();
		List<Alumno> alumnos = new ArrayList<>();
		try {
			alumnos = alumnoDAO.findAll();
		} catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		response.getWriter().append("Alumno #1 "+alumnos.get(0).getNombre());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
