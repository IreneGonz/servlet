package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Equipo;
import es.salesianos.model.Jugador;
import es.salesianos.servicio.EquipoService;
import es.salesianos.servicio.JugadorService;
import es.salesianos.servicio.Service;

public class ListadoServlet extends HttpServlet {

	Service service = new JugadorService();
	EquipoService serviceEq = new EquipoService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Jugador> jugadores = service.listarDatos();
		req.setAttribute("listOfJugadores", jugadores);
		List<Equipo> equipos = serviceEq.listarDatos();
		req.setAttribute("listOfEquipos", equipos);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Listado.jsp");
		dispatcher.forward(req, resp);
	}

}
