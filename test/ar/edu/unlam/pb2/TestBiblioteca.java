package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBiblioteca {

	@Test
	public void queSePuedaCrearBiblioteca() {
		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");
		assertNotNull(bibliotecaNacional);
	}

	@Test
	public void queSeAgreguenLosLibrosALaBiblioteca() {
		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");
		Libro libro1 = new LibroGeografia(1, "nombre1", "alguien1");
		Libro libro2 = new LibroHistoria(2, "nombre2", "alguien2");
		Libro libro3 = new LibroMatematicas(3, "nombre3", "alguien3");

		bibliotecaNacional.agregarLibro(libro1);
		bibliotecaNacional.agregarLibro(libro2);
		bibliotecaNacional.agregarLibro(libro3);

		Integer ValorEsperado = 3;
		Integer ValorObtenido = bibliotecaNacional.getLibros().size();

		assertEquals(ValorEsperado, ValorObtenido);
	}

	@Test
	public void queUnEstudiantePuedaSolicitarUnLibro() {
		Estudiante estudiante1 = new Estudiante(1, "pepito", "argento");

		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");

		Libro libro1 = new LibroGeografia(1, "nombre1", "alguien1");
		Libro libro2 = new LibroHistoria(2, "nombre2", "alguien2");
		Libro libro3 = new LibroMatematicas(3, "nombre3", "alguien3");

		bibliotecaNacional.agregarLibro(libro1);
		bibliotecaNacional.agregarLibro(libro2);
		bibliotecaNacional.agregarLibro(libro3);

		try {
			bibliotecaNacional.prestarLibro(libro1, estudiante1);
		} catch (EstudianteNoHabilitado e) {
			e.printStackTrace();
		} catch (LibroNoDisponible e) {
			e.printStackTrace();
		}

		assertFalse(libro1.estaDisponible());

		Integer valorEsperado = 1;

		assertEquals(valorEsperado, estudiante1.getCantidadDeLibros());

	}

	@Test(expected = EstudianteNoHabilitado.class)
	public void queElEstudianteNoPuedaSolicitarMasDeDosLibro() throws EstudianteNoHabilitado, LibroNoDisponible {
		Estudiante estudiante1 = new Estudiante(1, "pepito", "argento");

		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");

		Libro libro1 = new LibroGeografia(1, "nombre1", "alguien1");
		Libro libro2 = new LibroHistoria(2, "nombre2", "alguien2");
		Libro libro3 = new LibroMatematicas(3, "nombre3", "alguien3");

		bibliotecaNacional.agregarLibro(libro1);
		bibliotecaNacional.agregarLibro(libro2);
		bibliotecaNacional.agregarLibro(libro3);

		bibliotecaNacional.prestarLibro(libro1, estudiante1);
		bibliotecaNacional.prestarLibro(libro2, estudiante1);
		bibliotecaNacional.prestarLibro(libro3, estudiante1);

	}

	@Test
	public void queSePuedaFotocopiarEllibroDeHistoria() throws ElLibroNoSePuedeFotocopiar {
		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");
		Libro libro2 = new LibroHistoria(2, "nombre2", "alguien2");

		String valorObtenido=bibliotecaNacional.fotocopiarLibro(libro2);
		
		String valorEsperado = libro2.toString();
		
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test (expected=ElLibroNoSePuedeFotocopiar.class)
	public void queNoSePuedaFotocopiarUnLibroDeMatematicas() throws ElLibroNoSePuedeFotocopiar {
		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");
		Libro libro3 = new LibroMatematicas(3, "nombre3", "alguien3");

		bibliotecaNacional.fotocopiarLibro(libro3);
		
	}

	@Test (expected=LibroNoDisponible.class)
	public void queNoSePuedaprestarUnLibroQueNoHayaSidoDevuelto() throws EstudianteNoHabilitado, LibroNoDisponible {
		Estudiante estudiante1 = new Estudiante(1, "pepito", "argento");
		Estudiante estudiante2 = new Estudiante(1, "pepito", "argento");

		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");

		Libro libro1 = new LibroGeografia(1, "nombre1", "alguien1");

		bibliotecaNacional.agregarLibro(libro1);

		bibliotecaNacional.prestarLibro(libro1, estudiante1);
		bibliotecaNacional.prestarLibro(libro1, estudiante2);
	}

	@Test
	public void queUnEstudiantePuedaDevolverUnLibro() {
		Estudiante estudiante1 = new Estudiante(1, "pepito", "argento");

		Biblioteca bibliotecaNacional = new Biblioteca("Biblioteca Nacional");

		Libro libro1 = new LibroGeografia(1, "nombre1", "alguien1");

		bibliotecaNacional.agregarLibro(libro1);

		try {
			bibliotecaNacional.prestarLibro(libro1, estudiante1);
		} catch (EstudianteNoHabilitado e) {
			e.printStackTrace();
		} catch (LibroNoDisponible e) {
			e.printStackTrace();
		}

		bibliotecaNacional.devolverLibro(libro1, estudiante1);

		assertTrue(libro1.estaDisponible());

	}

}
