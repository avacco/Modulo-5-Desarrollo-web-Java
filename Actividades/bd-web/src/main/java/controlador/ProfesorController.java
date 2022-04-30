package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Servlet implementation class ProfesorController
 */
public class ProfesorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupera datos enviados desde el formulario
		String nombreProf = request.getParameter("nombreprof");
		String rut = request.getParameter("rut");
		
		// Recupera conexion desde piscina de conexiones de Tomcat
		try {
			InitialContext initialContext = new InitialContext();
			Context contexto = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) contexto.lookup("jdbc/postgres");
			
		// Prepara statement 
			try(
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO profesores(nombre,rut) VALUES(?,?)");
			){
		// Reemplaza los "?"
				ps.setString(1, nombreProf);
				ps.setString(2, rut);
				
		// Ejecuta statement en la base de datos
				int filasInsertadas = ps.executeUpdate();				
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		// Redirecciona
		response.sendRedirect("/bd-web");
	}
	

}
