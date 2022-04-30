package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;

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

public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlumnoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Guarda el parametro pasado a traves despues del xxxx?xxxx en el formulario, en este caso xxxx?accion=xx
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
					e.printStackTrace();
					response.sendError(500);
				}
				break;
			case "eliminar":
				int alumnoId = Integer.parseInt(request.getParameter("id"));
				try {
					eliminarAlumno(alumnoId);
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
					Alumno alumno = getAlumnoById(alumnoId);
					vistaJSP = "/WEB-INF/jsp/vista/alumno/alumno-form.jsp";	
					request.setAttribute("alumno", alumno);
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
		String carrera 				= request.getParameter("carrera");
		
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
				crearAlumno(alumnoNuevo);
				response.sendRedirect("/cft-web/AlumnoController?accion=listar");
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
				response.sendError(500);
			}			
		} else {
			//editar
			Alumno alumnoAEditar = new Alumno(id,nombre,carrera,fechaNacimiento);
			try {
				editarAlumno(alumnoAEditar);
				response.sendRedirect("/cft-web/AlumnoController?accion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		}
	}

	public void eliminarAlumno(int alumnoId) throws SQLException, NamingException {
		try(
			Connection conn = getConexion();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM alumnosact WHERE ID = ?");
		) {
			ps.setInt(1, alumnoId);
			ps.executeUpdate();
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
				LocalDate fechaNacimiento 	= rs.getObject("fecha_nacimiento", LocalDate.class);
				// Instancia objeto Alumno
				Alumno alumno = new Alumno(id,nombre,carrera,fechaNacimiento);
				// Lo añade a la lista
				alumnos.add(alumno);
			}
			return alumnos;
		}
		
	}
	
	public Alumno getAlumnoById(int alumnoId) throws SQLException, NamingException {
		try(
				Connection conn = getConexion();
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM alumnosact WHERE ID = ?");
			) {

				ps.setInt(1, alumnoId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String carrera = rs.getString("carrera");
					LocalDate fechaNacimiento 	= rs.getObject("fecha_nacimiento", LocalDate.class);
					return new Alumno(id,nombre,carrera,fechaNacimiento);
				}else {
					return null;
				}
			} 
	}
	
	public void editarAlumno(Alumno alumno) throws SQLException, NamingException {
		try(
				Connection conn = getConexion();
				PreparedStatement ps = conn.prepareStatement("UPDATE alumnosact SET nombre = ?, carrera = ?, fecha_nacimiento = ? WHERE id = ?");
			) {

				ps.setString(1, alumno.getNombre());
				ps.setString(2, alumno.getCarrera());
				ps.setObject(3, alumno.getFechaNacimiento());
				ps.setInt(4, alumno.getId());
				ps.executeUpdate();
			} 
	}
	

	public void crearAlumno(Alumno alumno) throws NamingException, SQLException {
		try(
			Connection conn = getConexion();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO alumnosact(nombre,carrera,fecha_nacimiento) VALUES (?,?,?)");

		) {
			ps.setString(1, alumno.getNombre());
			ps.setString(2, alumno.getCarrera());
			ps.setObject(3, alumno.getFechaNacimiento());
			ps.executeUpdate();			
		}
	}

}
