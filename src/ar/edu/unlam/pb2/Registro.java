package ar.edu.unlam.pb2;

import java.util.List;

public class Registro {
	
	private Integer ID;
	private Estudiante estudiante;
	private List<Libro> libros;
	
	private static Integer Id=0;
	
	public Registro(Estudiante estudiante, Libro libro) {
		this.ID=Id;
		this.estudiante=estudiante;
		incrementarID();
	}
	private static void incrementarID(){
		Id++;
	}
	
	
}