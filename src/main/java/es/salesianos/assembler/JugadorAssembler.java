package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Jugador;

public class JugadorAssembler {

	// Aqui es donde creamos y cargamos los datos del jugador llamando al metodo set
	// del jugador recogiendo a traves del servlet el parametro que hayamos metido
	// en el campo que le pongamos entre "", por ej
	// jugador.setNombre(request.getParameter("nombre"));
	// Aqui cargamos el campo nombre del jugador con lo que hayamos metido en el
	// campo de "nombre"

	public Jugador crearJugador(HttpServletRequest request) {
		Jugador jugador = new Jugador();
		jugador.setNombre(request.getParameter("nombre"));
		jugador.setApellido(request.getParameter("apellido"));
		// En este caso quiero recibir un int pero el getParameter devuelve un string,
		// asi que tengo que parsearlo
		jugador.setCodEquipo(Integer.parseInt(request.getParameter("codEquipo")));

		return jugador;

	}
}
