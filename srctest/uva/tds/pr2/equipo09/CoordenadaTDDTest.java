package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author ginquin
 * @author davidgo
 *
 */
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
		assertEquals(c1, c2);
	}
	
	@Test
	public void testTDDCoordenadaEqualsOtraLatitud() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.4, 23.4);
		assertNotEquals(c1, c2);
		//TODO cambiar al implementar el equals
		fail("Obligado a fallar");
	}
	
	@Test
	public void testTDDCoordenadaEqualsOtraLongitud() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.3, 23.3);
		assertNotEquals(c1, c2);
		//TODO cambiar al implementar el equals
		fail("Obligado a fallar");
	}
	
	@Test
	public void testTDDdistanciaA() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.2, -24.3);
		c2 = new Coordenada(24.4, 15.2);
		
		double distancia = c1.distanciaA(c2);
		assertEquals(distancia, 2, ERROR_ADMISIBLE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDdistanciaAconNull() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.2, -24.3);
		c2 = null;
		@SuppressWarnings("unused")
		double distancia = c1.distanciaA(c2);
	}

}
