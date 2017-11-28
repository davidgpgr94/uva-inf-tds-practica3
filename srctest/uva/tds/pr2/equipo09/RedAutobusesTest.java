package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

public class RedAutobusesTest {

	@Test
	public void testTDDConstructorRedAutobuses() {
		Coordenada cord1 = new Coordenada(1, 1);
		Coordenada cord2 = new Coordenada(2, 2);
		Linea[] lineas = {new Linea(1, cord1), new Linea(2, cord2) };
		RedAutobuses red = new RedAutobuses(lineas);
		assertEquals(red.getLineas(), lineas);
	}

}
