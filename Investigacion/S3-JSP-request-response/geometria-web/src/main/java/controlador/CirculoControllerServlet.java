package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Circulo;
import modelo.Rectangulo;

import java.io.IOException;

/**
 * Servlet implementation class RectanguloControllerServlet
 */
public class CirculoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CirculoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupera valores enviados por el formulario
		String diametro = request.getParameter("diametro");
		
		// Convierte los datos recuperados
		double doubleDiametro = Double.parseDouble(diametro);
		
		// Procesa los datos a traves de los metodos en modelos
		Circulo circulo = new Circulo(doubleDiametro);
		double area = circulo.calcularArea();
		
		// Envia los datos procesados a una vista JSP para mostrarlos
		String rutaJSP = "/WEB-INF/jsp/vista/area.jsp";
		request.setAttribute("area", area);
		request.getRequestDispatcher(rutaJSP).forward(request, response);

	}


}
