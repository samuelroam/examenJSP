package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import modelo.Parcela;
import modelo.ParcelaModelo;


@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inicio() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// conseguir parcelas
			ParcelaModelo parcelaModelo = new ParcelaModelo();
			ArrayList<Parcela> parcelas = parcelaModelo.selectAll();

			Iterator<Parcela> i = parcelas.iterator();
			Parcela parcela;
			ParcelaModelo modeloParcela = new ParcelaModelo();

			while (i.hasNext()) {
				parcela = i.next();
			}

			// enviar datos
			request.setAttribute("parcelas", parcelas);

			// meterlos en el request
			RequestDispatcher rd = request.getRequestDispatcher("inicio.jsp");
			rd.forward(request, response);
		

		// abrir vista listaParcelas
		response.getWriter().println("soy servlet listar parcelas");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
