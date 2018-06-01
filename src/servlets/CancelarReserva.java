package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Reserva;



@WebServlet("/CancelarReserva")
public class CancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    public CancelarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reserva reserva = new Reserva();
		reserva.setNombre_usuario(null);
		reserva.setApellido_usuario(null);
		reserva.setDni_usuario(null);
		reserva.setNumero_usuarios(0);
		reserva.setInicio_reserva(null);
		reserva.setFin_reserva(null);
		
		HttpSession session = request.getSession();
		session.setAttribute("reserva", reserva);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
