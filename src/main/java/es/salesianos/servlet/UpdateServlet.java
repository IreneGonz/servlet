package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Equipo;
import es.salesianos.model.Jugador;
import es.salesianos.servicio.EquipoService;
import es.salesianos.servicio.JugadorService;

public class UpdateServlet extends HttpServlet {

	JugadorService service = new JugadorService();
	EquipoService serviceEq = new EquipoService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("id"); //id de Jugador
		String paramEqui = req.getParameter("idEquipo"); //id de Equipo
		
		//Si parameter != null es porque quiero hacer update a un jugador
		if(parameter != null) {
			Integer idJugador = Integer.parseInt(parameter);
			Jugador jugador = service.listById(idJugador);
			req.setAttribute("jugador", jugador);
		}
		else { //Si es null es que quiero hacer update a un equipo
			Integer idEquipo = Integer.parseInt(paramEqui);
			Equipo equipo = serviceEq.listById(idEquipo);
		}
		redirect(req, resp, "Update.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String nombre = req.getParameter("name");
		String apellido = req.getParameter("surname");
		int codEquipo = Integer.parseInt(req.getParameter("idEquipo"));
		String nomEquipo = req.getParameter("nomEquipo");
		Jugador jugador = new Jugador();
		Equipo equipo = new Equipo();
		
		if(id != null) { //Si estoy actualizando un jugador
			jugador.setId(Integer.parseInt(id));
			jugador.setNombre(nombre);
			jugador.setApellido(apellido);
			jugador.setCodEquipo(codEquipo);
			service.update(jugador);
		}else { //Si estoy actualizando un equipo
			equipo.setId(codEquipo);
			equipo.setNombre(nomEquipo);
			serviceEq.update(equipo);
		}
		
		
		redirect(req, resp, "Listado.jsp");

	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String page)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + page);
		dispatcher.forward(req, resp);
	}

}
