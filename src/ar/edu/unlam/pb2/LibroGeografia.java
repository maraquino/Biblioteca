package ar.edu.unlam.pb2;

public class LibroGeografia extends Libro implements IFotocopiable {

	public LibroGeografia(Integer cod, String nombre, String autor) {
		super(cod, nombre, autor);
	}

	@Override
	public String fotocopiar() {
		return null;
	}

	
	
}
