package es.salesianos.servicio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Jugador;

public interface Service {

	// createNewUserFromRequest
	public Jugador crearNuevoJugador(HttpServletRequest req);

	// insertUser
	public void insertarJugador(Jugador jugador);

	// listAll
	public List<Jugador> listarDatos();

}
