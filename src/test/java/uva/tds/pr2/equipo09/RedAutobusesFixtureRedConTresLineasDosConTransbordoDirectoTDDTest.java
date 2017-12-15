package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobusesFixtureRedConTresLineasDosConTransbordoDirectoTDDTest {

	
	private RedAutobuses red;
	private static double ERROR_ADMISIBLE = 0.0001;

	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1 = { new Coordenada(12, 12), new Coordenada(12.002, 12.002), new Coordenada(12.01, 12.01), new Coordenada(12.005, 12.005), new Coordenada(12.0005, 12.0005) };
		Coordenada[] cords2 = { new Coordenada(12.05, 12.05), new Coordenada(12.01, 12.01), new Coordenada(12.0506, 12.0506) };
		Coordenada[] cords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2), new Linea(3, cords3) };
		red = new RedAutobuses(lineas);
	}
	
	@Test
	public void testTDDhayTransbordoDirecto() {
		assertTrue(red.hayTransbordoDirecto(1, 2));
	}
	
	@Test
	public void testTDDhayTransbordoDirectoFalse() {
		assertFalse(red.hayTransbordoDirecto(1, 3));
		fail("Obligado a fallar");
		//TODO repasar una vez implementado RedAutobuses.hayTransbordoDirecto()
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDhayTransbordoDirectoLaRedNoTieneLaLineaA() {
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(4, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDhayTransbordoDirectoLaRedNoTieneLaLineaB() {
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(1, 4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDhayTransbordoDirectoLaRedNoTieneLaLineaANiB() {
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(4, 5);
	}

	@Test
	public void testTDDgetParadasConTransbordoDirecto() {
		Coordenada[] paradasEsperadas = { new Coordenada(12.01, 12.01) };
		assertArrayEquals(paradasEsperadas, red.getParadasConTransbordo(1, 2));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetParadasConTransbordoDirectoLaRedNoTieneLaLineaA() {
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(4, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetParadasConTransbordoDirectoLaRedNoTieneLaLineaB() {
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(1, 4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetParadasConTransbordoDirectoNoHayParadasConTransbordoDirecto() {
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(1, 3);
	}

	@Test
	public void testTDDgetDistanciaParadas() {
		assertEquals(red.getDistanciaParadas(1, 3, 2, 3), 6320, ERROR_ADMISIBLE);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetDistanciaParadasLaRedNoContieneAlgunaDeLasLineas() {
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(4, 1, 1, 2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetDistanciaParadasPosicionParadaAInvalida() {
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, 6, 2, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetDistanciaParadasPosicionParadaBInvalida() {
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, 1, 2, 4);
	}
}
