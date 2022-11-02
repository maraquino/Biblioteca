package ar.edu.unlam.pb2;

public class LibroHistoria extends Libro implements IFotocopiable {

	public LibroHistoria(Integer cod, String nombre, String autor) {
		super(cod, nombre, autor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String fotocopiar() {
		return this.toString();
	}


}