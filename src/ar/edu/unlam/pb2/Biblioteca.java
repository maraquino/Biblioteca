package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {

	private String nombre;
	private Set<Libro> libros;
	private List<Registro> registros;

	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.libros = new HashSet<Libro>();
		this.registros = new ArrayList<Registro>();
	}

	public void agregarLibro(Libro libroNuevo) {
		this.libros.add(libroNuevo);
	}

	public Set<Libro> getLibros() {
		return this.libros;
	}

	public void prestarLibro(Libro libro, Estudiante estudiante) throws EstudianteNoHabilitado, LibroNoDisponible {
		if (estudiante.estaHabilitado() && libro.estaDisponible()) {
			estudiante.agregarLibro(libro);
			libro.prestar();
			Registro registroNuevo = new Registro(estudiante, libro);
			registros.add(registroNuevo);
		} else {
			if (!estudiante.estaHabilitado()) {
				throw new EstudianteNoHabilitado();
			}
			if (!libro.estaDisponible()) {
				throw new LibroNoDisponible();
			}
		}
	}

	public String fotocopiarLibro(Libro libro) throws ElLibroNoSePuedeFotocopiar {
		if(libro instanceof IFotocopiable){
			return ((IFotocopiable) libro).fotocopiar();
		} else throw new ElLibroNoSePuedeFotocopiar();
	}


	public void devolverLibro(Libro libro, Estudiante estudiante) {
		libro.devolver();
		estudiante.devolverLibro(libro);
	}
}
