package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Sequences.class)
public class LineaSequencesTest {

	private Linea linea;
	
	@Before
	public void setUp() throws Exception {
		Coordenada p0 = new Coordenada(10, 10);
		Coordenada p1 = new Coordenada(10.001, 10.001);
		Coordenada p2 = new Coordenada(10.0006, 10.0006);
		Coordenada[] paradasIniciales = {p0, p1, p2};
		
		linea = new Linea(1, paradasIniciales);
	}

	@Test
	public void testSecuenciaAñadirYEliminarParada() {
		Coordenada nuevaParada = new Coordenada(10.009, 10.009);
		linea.añadirParada(1, nuevaParada);
		linea.eliminarParada(2);
		Coordenada[] exp = {new Coordenada(10, 10), nuevaParada, new Coordenada(10.0006, 10.0006)};
		assertArrayEquals(exp, linea.getParadas());
	}

}
