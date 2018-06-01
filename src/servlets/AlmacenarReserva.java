package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Reserva;
import modelo.ReservaModelo;



@WebServlet("/AlmacenarReserva")
public class AlmacenarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AlmacenarReserva() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Reserva reserva = (Reserva)request.getAttribute("reserva");
		
		ReservaModelo reservaModelo=new ReservaModelo();
		reservaModelo.guardarReserva(reserva);
		
		response.sendRedirect("confirmacion.jsp");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
