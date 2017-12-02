package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobusesFixtureRedConTresLineasDosConCorrespondenciaTDDTest {
	
	private RedAutobuses red;

	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1 = { new Coordenada(12, 12), new Coordenada(12.002, 12.002), new Coordenada(12.01, 12.01), new Coordenada(12.005, 12.005), new Coordenada(12.0005, 12.0005) };
		Coordenada[] cords2 = { new Coordenada(12.01, 12.0082), new Coordenada(12.02, 12.0082), new Coordenada(12.0109, 12.0082) };
		Coordenada[] cords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2), new Linea(3, cords3) };
		red = new RedAutobuses(lineas);
	}

	@Test
	public void testTDDhayLineasEnRadio() {
		assertTrue(red.hayLineasEnRadio(new Coordenada(24.30031, 24.30031), 50));
	}
	
	@Test
	public void testTDDhayLineasEnRadioFalse() {
		assertFalse(red.hayLineasEnRadio(new Coordenada(50, 50), 100));
		fail("Obligado a fallar");
		//TODO repasar una vez implementado RedAutobuses.hayLineasEnRadio()
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDhayLineasEnRadioCoordenadaNula() {
		@SuppressWarnings("unused")
		boolean respuesta = red.hayLineasEnRadio(null, 10);
	}

	@Test
	public void testTDDgetLineasEnRadio() {
		Coordenada[] auxCords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		Linea[] lineasEsperadas = { new Linea(3, auxCords3) };
		assertArrayEquals(lineasEsperadas, red.getLineasEnRadio(new Coordenada(24.30031, 24.30031), 50));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testTDDgetLineasEnRadioCoordenadaNula() {
		@SuppressWarnings("unused")
		Linea[] lineas = red.getLineasEnRadio(null, 10);
	}

	@Test(expected = IllegalStateException.class)
	public void testTDDgetLineasEnRadioSinLineasEnElRadio() {
		@SuppressWarnings("unused")
		Linea[] lineas = red.getLineasEnRadio(new Coordenada(50, 50), 100);
	}

	@Test
	public void testTDDtieneAlgunaCorrespondenciaTrue() {
		assertTrue(red.tieneAlgunaCorrespondencia(1));
	}
	
	@Test
	public void testTDDtieneAlgunaCorrespondenciaFalse() {
		assertFalse(red.tieneAlgunaCorrespondencia(3));
		fail("Obligado a fallar");
		//TODO repasar una vez implementado RedAutobuses.tieneAlgunaCorrespondencia()
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDtieneAlgunaCorrespondenciaLaRedNoTieneLaLineaConsultada() {
		@SuppressWarnings("unused")
		boolean respuesta = red.tieneAlgunaCorrespondencia(4);
	}

	@Test
	public void testTDDgetCorrespondencias() {
		Coordenada[] auxCords2 = { new Coordenada(12.01, 12.0082), new Coordenada(12.02, 12.0082), new Coordenada(12.0109, 12.0082) };
		Linea[] lineasEsperadas = { new Linea(2, auxCords2) };
		assertArrayEquals(lineasEsperadas, red.getCorrespondencias(1));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetCorrespondenciasLaRedNoTieneLaLineaConsultada() {
		@SuppressWarnings("unused")
		Linea[] respuesta = red.getCorrespondencias(4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetCorrespondenciaLaLineaNoTieneCorrespondencias() {
		@SuppressWarnings("unused")
		Linea[] respuesta = red.getCorrespondencias(3);
	}
	

}
