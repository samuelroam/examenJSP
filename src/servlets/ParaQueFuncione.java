package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParaQueFuncione")
public class ParaQueFuncione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ParaQueFuncione() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("soy servlet listar usuarios");
		
		//si tiene que enviar datos
		RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
		rd.forward(request, response);
		//si solo tiene que redirigir
		response.sendRedirect("fallo.html");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
