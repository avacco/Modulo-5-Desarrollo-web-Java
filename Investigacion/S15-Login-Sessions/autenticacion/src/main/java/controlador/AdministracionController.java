package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdministracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdministracionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// verifica que el usuario este autenticado tomando el atributo seteado durante la autenticacion
		// se guardo un boolean, pero es convertido a object al ser guardado. al recuperarlo hace falta convertirlo de nuevo a boolean
		
		//inicializa valores para evitar errores
		boolean auth = false;		
		Object objetoAuth = null;
		
		// asigna al objeto inicializado el valor guardado en autenticacion
		objetoAuth = request.getSession().getAttribute("autenticado");
		
		// el valor ya no es nulo, lo convierte a booleano
		if(objetoAuth != null) {
			auth = (Boolean) objetoAuth;
		}
		
		// una vez autentificado, toma la ruta que el usuario desea seguir, y segun esta, lo redirecciona a la que corresponda
		if(auth) {
			
			String ruta = request.getServletPath();
			String jsp = "";
			
			// cambia la ruta del jsp segun el contexto
			switch(ruta) {
				case "/administracion1":
					jsp = "/WEB-INF/admin/administracion1.jsp";
					break;
			
				case "/administracion2":
					jsp = "/WEB-INF/admin/administracion2.jsp";
					break;	
			}
			
			// redirecciona a la zona privada
			request.getRequestDispatcher(jsp).forward(request, response);
		} else {
			response.sendRedirect(getServletContext().getContextPath()+"/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
