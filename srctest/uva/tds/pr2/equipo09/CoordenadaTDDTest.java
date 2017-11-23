package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordenadaTDDTest {

	public static final double ERROR_ADMISIBLE = 0.0001;
	
	@Test
	public void testTDDConstructorCoordenada() {
		Coordenada coord = new Coordenada(12.234, -24.356);
		assertEquals(coord.getLatitud(), 12.234, ERROR_ADMISIBLE);
		assertEquals(coord.getLongitud(), -24.356, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testTDDCoordenadaEqualsCoordenada() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.3, 23.4);
		assertTrue(c1.equals(c2));
	}
	
	@Test
	public void testTDDCoordenadaEqualsOtraLatitud() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.4, 23.4);
		assertFalse(c1.equals(c2));
	}
	
	@Test
	public void testTDDCoordenadaEqualsOtraLongitud() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.3, 23.3);
		assertFalse(c1.equals(c2));
	}

}
