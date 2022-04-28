package modelo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

import controlador.Alumno;

public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlumnoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		switch(accion) {
			case "form":
				String vistaJSP = "/WEB-INF/jsp/vista/alumno/alumno-form.jsp";
				request.getRequestDispatcher(vistaJSP).forward(request, response);
				break;
			case "listar":
				try {
					List<Alumno> alumnos = getAlumnos();
					request.setAttribute("alumnos", alumnos);
					vistaJSP = "/WEB-INF/jsp/vista/alumno/alumno-listado.jsp";
					request.getRequestDispatcher(vistaJSP).forward(request, response);
				} catch (SQLException | NamingException e) {
					response.sendError(500);
				}
				break;
			default:
				response.sendError(404);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Inicializa variables a utilizar
		int id 			= 0;
		String nombre 	= request.getParameter("nombre");
		String carrera 	= request.getParameter("carrera");
		
		// Reemplaza variable id por parametros enviados desde formulario. Lo convierte a Integer si es valido, de lo contrario, echa un error.
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			System.err.println("id se setea a 0 de manera automatica");
		}

		// Crea el alumno si la id es valida
		if (id == 0) {
			Alumno alumnoNuevo = new Alumno(nombre,carrera);
			try {
				crearAlumno(alumnoNuevo);
			} catch (NamingException e) {
				e.printStackTrace();
			}
			response.sendRedirect("/cft-web/AlumnoController?accion=listar");
		} else {
			
		}
	}
	
	public Connection getConexion() throws NamingException, SQLException {
		InitialContext initialContext = new InitialContext();
		DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/postgres");
		return dataSource.getConnection();
	}
	
	public List<Alumno> getAlumnos() throws SQLException, NamingException{
		try(
			Connection conn = getConexion();
			Statement st = conn.createStatement();
		) {
			ResultSet rs = st.executeQuery("SELECT * FROM alumnosact");
			List<Alumno> alumnos = new ArrayList<>();
			while(rs.next()) {
				// Recupera variables de datos de la tabla
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String carrera = rs.getString("carrera");
				// Instancia objeto Alumno
				Alumno alumno = new Alumno(id,nombre,carrera);
				// Lo añade a la lista
				alumnos.add(alumno);
			}
			return alumnos;
		}
		
	}
	

	private void crearAlumno(Alumno alumno) throws NamingException {
		try(
			Connection conn = getConexion();
		) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO alumnosact(nombre,carrera) VALUES (?,?)");
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getCarrera());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			
		}
		
	}

}
