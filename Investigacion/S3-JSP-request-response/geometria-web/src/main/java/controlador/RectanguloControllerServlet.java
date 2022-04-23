package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Rectangulo;

import java.io.IOException;

/**
 * Servlet implementation class RectanguloControllerServlet
 */
public class RectanguloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RectanguloControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupera valores enviados por el formulario
		String base = request.getParameter("base");
		String altura = request.getParameter("altura");
		
		// Convierte los datos recuperados
		double doubleBase = Double.parseDouble(base);
		double doubleAltura = Double.parseDouble(altura);
		
		// Procesa los datos a traves de los metodos en modelos
		Rectangulo rectangulo = new Rectangulo(doubleBase,doubleAltura);
		double area = rectangulo.calcularArea();
		
		// Envia los datos procesados a una vista JSP para mostrarlos
		String rutaJSP = "/WEB-INF/jsp/vista/area.jsp";
		request.setAttribute("area", area);
		request.getRequestDispatcher(rutaJSP).forward(request, response);

	}


}
