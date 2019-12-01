package es.salesianos.model;

import es.salesianos.repository.EquipoRepositorio;

public class Jugador {

	// Defino sus valores, aka id, nombre, apellido y codEquipo y creo sus get set
	// para poder usarlas desde JugadorAssembler, que es donde verdaderamente se
	// "crea" al jugador

	private Integer id;
	String nombre;
	String apellido;
	int codEquipo;
	//Prueba que no va a ir
	String nomEquipo;

	//Prueba que no va a ir
	public String getNomEquipo() {
		EquipoRepositorio er = new EquipoRepositorio();
		nomEquipo = er.findNombreById(this.getCodEquipo());
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

}
