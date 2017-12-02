package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobusesFixtureTDDTest {
	
	private RedAutobuses red;
	private Coordenada[] cords1;
	private Coordenada[] cords2;
	
	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1aux = { new Coordenada(12.25580, 12.25580), new Coordenada(12.25570, 12.25570), new Coordenada(12.25639, 12.25639) };
		Coordenada[] cords2aux = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		cords1 = cords1aux;
		cords2 = cords2aux;
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2) };
		red = new RedAutobuses(lineas);
	}
	
	@Test
	public void testTDDgetLinea() {
		Linea l1 = red.getLinea(1);
		assertEquals(new Linea(1, cords1), l1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDgetLineaConIdNoExistenteEnLaRed() {
		@SuppressWarnings("unused")
		Linea l1 = red.getLinea(3);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testTDDgetLineaConIdNoValido() {
		@SuppressWarnings("unused")
		Linea l1 = red.getLinea(0);
	}
	
	@Test
	public void testTDDaddLinea() {
		Coordenada[] cords3 = { new Coordenada(10.2, 10.2), new Coordenada(10.21, 10.21), new Coordenada(10.2004, 10.2004) };
		Linea nl = new Linea(3, cords3);
		red.addLinea(nl);
		Linea[] lineasEsperadas = { new Linea(1, cords1), new Linea(2, cords2), new Linea(3, cords3) };
		assertArrayEquals(lineasEsperadas, red.lineas);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDaddLineaArgumentoNulo() {
		red.addLinea(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDaddLineaConIdentificadorDeNuevaYaExistenteEnLaRed() {
		Coordenada[] cords3 = { new Coordenada(10.2, 10.2), new Coordenada(10.21, 10.21), new Coordenada(10.2004, 10.2004) };
		Linea nl = new Linea(2, cords3);
		red.addLinea(nl);
	}

	@Test
	public void testTDDhayLinea() {
		assertTrue(red.hayLinea(2));
	}

	@Test
	public void testTDDhayLineaFalse() {
		assertFalse(red.hayLinea(3));
		fail("Obligado a fallar");
		//TODO repasar una vez implementado
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testTDDhayLineaConParametroInvalido() {
		@SuppressWarnings("unused")
		boolean res = red.hayLinea(0);
	}

	@Test
	public void testTDDeliminarLinea() {
		Coordenada[] cords3 = { new Coordenada(10.2, 10.2), new Coordenada(10.21, 10.21), new Coordenada(10.2004, 10.2004) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2), new Linea(3, cords3) };
		red = new RedAutobuses(lineas);
		red.eliminarLinea(3);
		Linea[] lineasEsperadas = { new Linea(1, cords1), new Linea(2, cords2) };
		assertArrayEquals(lineasEsperadas, red.lineas);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDeliminarLineaNoExistenteEnLaRed() {
		Coordenada[] cords3 = { new Coordenada(10.2, 10.2), new Coordenada(10.21, 10.21), new Coordenada(10.2004, 10.2004) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2), new Linea(3, cords3) };
		red = new RedAutobuses(lineas);
		red.eliminarLinea(4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testTDDeliminarLineaHabiendoSoloDosLineasEnLaRed() {
		red.eliminarLinea(2);
	}
	
	@Test
	public void testTDDgetLineas() {
		Linea[] lineasEsperadas = { new Linea(1, cords1), new Linea(2, cords2) };
		assertArrayEquals(lineasEsperadas, red.getLineas());
	}
	
}
