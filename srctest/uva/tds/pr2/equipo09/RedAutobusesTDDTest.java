package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

public class RedAutobusesTDDTest {

	@Test
	public void testTDDConstructorRedAutobuses() {
		Coordenada[] cords1 = { new Coordenada(12.25580, 12.25580), new Coordenada(12.25570, 12.25570), new Coordenada(12.25639, 12.25639) };
		Coordenada[] cords2 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2) };
		RedAutobuses red = new RedAutobuses(lineas);
		assertArrayEquals(red.lineas, lineas);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConstructorRedAutobusesSoloUnaLinea() {
		Coordenada[] cords1 = { new Coordenada(12.25580, 12.25580), new Coordenada(12.25570, 12.25570), new Coordenada(12.25639, 12.25639) };
		Linea[] lineas = { new Linea(1, cords1) };
		RedAutobuses red = new RedAutobuses(lineas);
	}

	@Test
	public void testTDDgetLineaId() {
		Coordenada[] cords1 = { new Coordenada(12.25580, 12.25580), new Coordenada(12.25570, 12.25570), new Coordenada(12.25639, 12.25639) };
		Coordenada[] cords2 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2) };
		RedAutobuses red = new RedAutobuses(lineas);
		Linea l1 = red.getLinea(1);
		
		assertEquals(new Linea(1, cords1), l1);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testTDDgetLineaIdConIdNoValido() {
		Coordenada[] cords1 = { new Coordenada(12.25580, 12.25580), new Coordenada(12.25570, 12.25570), new Coordenada(12.25639, 12.25639) };
		Coordenada[] cords2 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		Linea[] lineas = { new Linea(1, cords1), new Linea(2, cords2) };
		RedAutobuses red = new RedAutobuses(lineas);
		Linea l1 = red.getLinea(0);
	}
}
