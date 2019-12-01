package es.salesianos.servicio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.assembler.JugadorAssembler;
import es.salesianos.model.Jugador;
import es.salesianos.repository.Repository;

public class JugadorService implements Service {

	private JugadorAssembler assembler = new JugadorAssembler();

	public JugadorService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Autowired
	private Repository<Jugador> repository;

	public Jugador crearNuevoJugador(HttpServletRequest req) {
		Jugador jugador = assembler.crearJugador(req);
		return jugador;
	}

	public void insertarJugador(Jugador jugador) {
		repository.insert(jugador);
	}

	@Override
	public List<Jugador> listarDatos() {
		return repository.listAll();
	}

	public Jugador listById(Integer idJugador) {
		return repository.findBy(idJugador);
	}

	public void update(Jugador jugador) {
		repository.update(jugador);
	}

}
