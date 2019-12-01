package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Equipo;

public class EquipoAssembler {
	public Equipo crearEquipo(HttpServletRequest request) {
		Equipo equipo = new Equipo();
		equipo.setNombre(request.getParameter("nomEquipo"));
		//equipo.setId(20);

		return equipo;

	}
}
