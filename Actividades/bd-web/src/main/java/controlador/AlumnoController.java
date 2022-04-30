package controlador;

import jakarta.servlet.ServletException;
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

public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlumnoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupera datos enviados desde el formulario
		String nombre = request.getParameter("nombre");
		String carrera = request.getParameter("carrera");
		
		// Recupera conexion desde piscina de conexiones de Tomcat
		try {
			InitialContext initialContext = new InitialContext();
			Context contexto = (Context) initialContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) contexto.lookup("jdbc/postgres");
			
		// Prepara statement 
			try(
				Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO alumnos(nombre,carrera) VALUES(?,?)");
			){
		// Reemplaza los "?"
				ps.setString(1, nombre);
				ps.setString(2, carrera);
				
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
