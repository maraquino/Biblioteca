package ar.edu.unlam.pb2;

public class Libro {
	private Integer cod;
	private String nombre;
	private String autor;
	private Boolean disponible;
	
	public Libro(Integer cod, String nombre, String autor){
		this.nombre= nombre;
		this.autor=autor;
		this.cod=cod;
		this.disponible=true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Libro other = (Libro) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	public boolean estaDisponible() {
		return this.disponible;
	}

	public void prestar() {
		this.disponible=false;
	}
	
	public void devolver() {
		this.disponible=true;
	}	
}
