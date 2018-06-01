package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
	

import modelo.Reserva;
import modelo.ReservaModelo;

/**
 * Servlet implementation class CrearReserva
 */
@WebServlet("/GuardarReservaEnCarrito")
public class GuardarReservaEnCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GuardarReservaEnCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservaModelo reservaModelo = new ReservaModelo();
		
		String fechaString = "24-12-2018";
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date fecha = sdf.parse(fechaString);
			
			System.out.println(fecha);
			System.out.println(sdf.format(fecha));
			
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("formato de fecha mal");
		}

		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		int numPersonas = Integer.parseInt(request.getParameter("numero_personas"));
		
		
		String fechaInicio = request.getParameter("fecha_inicio");
			SimpleDateFormat inicio = new SimpleDateFormat("dd-mm-yyyy");
			Date inicioFecha = inicio.parse(fechaInicio);
		String fechaFin = request.getParameter("fecha_fin");
			SimpleDateFormat fin = new SimpleDateFormat("dd-mm-yyyy");
			Date finFecha = fin.parse(fechaFin);
		

		Reserva reserva = new Reserva();
		reserva.setNombre_usuario(nombre);
		reserva.setApellido_usuario(apellido);
		reserva.setDni_usuario(dni);
		reserva.setNumero_usuarios(numPersonas);
		reserva.setInicio_reserva(inicioFecha);
		reserva.setFin_reserva(finFecha);
		
		HttpSession session = request.getSession();
		session.setAttribute("reserva", reserva);
		
		


		RequestDispatcher rd = request.getRequestDispatcher("infoReserva.jsp");
		rd.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
