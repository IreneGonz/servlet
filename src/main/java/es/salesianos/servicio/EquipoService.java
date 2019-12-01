package es.salesianos.servicio;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import es.salesianos.assembler.EquipoAssembler;
import es.salesianos.assembler.JugadorAssembler;
import es.salesianos.model.Equipo;
import es.salesianos.repository.Repository;

public class EquipoService {

	private EquipoAssembler assembler = new EquipoAssembler();

	public EquipoService() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Autowired
	private Repository<Equipo> repository;

	public Equipo crearNuevoEquipo(HttpServletRequest req) {
		Equipo equipo = assembler.crearEquipo(req);
		return equipo;
	}

	public void insertarEquipo(Equipo equipo) {
		repository.insert(equipo);
	}

	public List<Equipo> listarDatos() {
		return repository.listAll();
	}

	public Equipo listById(Integer idEquipo) {
		return repository.findBy(idEquipo);
	}

	public void update(Equipo equipo) {
		repository.update(equipo);
	}
	
}
