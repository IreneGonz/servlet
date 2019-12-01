package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.model.Equipo;
import es.salesianos.model.Jugador;
import es.salesianos.servicio.EquipoService;
import es.salesianos.servicio.JugadorService;
import es.salesianos.servicio.Service;

public class WelcomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Service service = new JugadorService();
	private EquipoService serviceEquipo = new EquipoService();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if(req.getParameter("jug") != null) {//Estoy añadiendo un jugador
			Jugador jugador = service.crearNuevoJugador(req);
			service.insertarJugador(jugador);			
		}
		if(req.getParameter("eq") != null) { //Estoy añadiendo un equipo
			Equipo equipo = serviceEquipo.crearNuevoEquipo(req);
			serviceEquipo.insertarEquipo(equipo);
		}
		
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
		dispatcher.forward(req, resp);
	}
}