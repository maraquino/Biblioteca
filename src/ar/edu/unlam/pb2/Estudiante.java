package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

	private String nombre;
	private String apellido;
	private Integer dni;
	private Boolean estaHabilitado;
	private List<Libro> librosRetirados;	
	
	public Estudiante(Integer dni, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.estaHabilitado=true;
		this.librosRetirados=new ArrayList <>();
	}


	public boolean estaHabilitado() {
		return estaHabilitado;
	}


	public void agregarLibro(Libro libro) {
		librosRetirados.add(libro);
		if(librosRetirados.size()>=2){
			this.estaHabilitado=false;
		}
	}

	public void devolverLibro(Libro libro) {
		librosRetirados.remove(libro);
	}


	public Object getCantidadDeLibros() {
		return librosRetirados.size();
	}
	
	
	
}
