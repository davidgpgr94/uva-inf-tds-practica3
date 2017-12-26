package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author ginquin
 * @author davidgo
 *
 */
@Category({TDD.class, Unit.class})
public class CoordenadaTDDTest {

	public static final double ERROR_ADMISIBLE = 0.001;
	
	@Test
	public void testTDDConstructorCoordenada() {
		Coordenada coord = new Coordenada(12.234, -24.356);
		assertEquals(coord.getLatitud(), 12.234, ERROR_ADMISIBLE);
		assertEquals(coord.getLongitud(), -24.356, ERROR_ADMISIBLE);
	}
	
	@Test
	public void testTDDCoordenadaEqualsThis() {
		Coordenada c;
		c = new Coordenada(12.3, 23.4);
		assertEquals(c, c);
		assertTrue(c.hashCode()==c.hashCode());
	}
	
	@Test
	public void testTDDCoordenadaEqualsCoordenada() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.3, 23.4);
		assertEquals(c1, c2);
		assertTrue(c1.hashCode()==c2.hashCode());
	}
	
	@Test
	public void testTDDCoordenadaEqualsOtraLatitud() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.4, 23.4);
		assertNotEquals(c1, c2);
		assertFalse(c1.hashCode()==c2.hashCode());
	}
	
	@Test
	public void testTDDCoordenadaEqualsOtraLongitud() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.3, 23.4);
		c2 = new Coordenada(12.3, 23.3);
		assertNotEquals(c1, c2);
		assertFalse(c1.hashCode()==c2.hashCode());
	}
	
	@Test
	public void testCoordenadaEqualsMismaCoordeenada() {
		Coordenada c = new Coordenada(12.3, 15.2);
		assertEquals(c, c);
	}
	
	@Test
	public void testCoordenadaEqualsNotCoordenada() {
		Coordenada c = new Coordenada(12.3, 15.2);
		String s = "";
		assertNotEquals(c, s);
	}
	
	 @Test
	 public void testCoordenadaHashCodeCoinciden() {
		 Coordenada c1 = new Coordenada(12.3, 15.2);
		 Coordenada c2 = new Coordenada(12.3, 15.2);
		 assertEquals(c1.hashCode(), c2.hashCode());
	 }
	 
	 @Test
	 public void testCoordenadaHashCodeNoCoinciden() {
		 Coordenada c1 = new Coordenada(12.3, 15.2);
		 Coordenada c2 = new Coordenada(12.3, 15.3);
		 assertNotEquals(c1.hashCode(), c2.hashCode());
	 }
	
	@Test
	public void testTDDdistanciaA() {
		Coordenada c1, c2;
		c1 = new Coordenada(12.25580, 12.25580);
		c2 = new Coordenada(12.25639, 12.25639);
		
		double distancia = c1.distanciaA(c2);
		assertEquals(0.091,distancia,ERROR_ADMISIBLE);
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
