package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AutenticacionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cerrar sesion borrando los datos de la sesion
		request.getSession().invalidate();
		
		// redirecciona de vuelta al index
		response.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// toma los datos de usuario y contraseña de los campos correspondientes
		String usuario 	= request.getParameter("usuario");
		String pass		= request.getParameter("pass");
		
		if("admin".equals(usuario) && "1234".equals(pass)) {
			// si los datos son correctos, guarda un indicador en la sesion
			request.getSession().setAttribute("autenticado", true);
			
			// redirecciona a la pagina primaria de la zona privada
			response.sendRedirect(getServletContext().getContextPath()+"/administracion1");
			
		} else {
			//si no son correctos envia un error y redirecciona a login otra vez
			request.setAttribute("errorSesion", "Usuario y/o contraseña incorrectos");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
