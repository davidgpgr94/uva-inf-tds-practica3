package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
}
