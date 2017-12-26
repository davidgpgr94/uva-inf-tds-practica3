package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Sequences.class)
public class LineaSequencesTest {

	private Linea linea;
	private Coordenada p0 = new Coordenada(10, 10);
	private Coordenada p1 = new Coordenada(10.001, 10.001);
	private Coordenada p2 = new Coordenada(10.0006, 10.0006);
	
	@Before
	public void setUp() throws Exception {
		Coordenada[] paradasIniciales = {p0, p1, p2};
		
		linea = new Linea(1, paradasIniciales);
	}

	@Test
	public void testSecuenciaAñadirYEliminarParada() {
		Coordenada nuevaParada = new Coordenada(10.009, 10.009);
		linea.añadirParada(1, nuevaParada);
		linea.eliminarParada(2);
		Coordenada[] exp = {p0, nuevaParada, p2};
		assertArrayEquals(exp, linea.getParadas());
	}
	
	@Test
	public void testSecuenciaAñadirAñadirYEliminarParada() {
		Coordenada np1 = new Coordenada(10.009, 10.009);
		Coordenada np2 = new Coordenada(10.01, 10.01);
		linea.añadirParada(1, np1);
		linea.añadirParada(2, np2);
		linea.eliminarParada(3);
		Coordenada[] exp = {p0, np1, np2, p2};
		assertArrayEquals(exp, linea.getParadas());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSecuenciaAñadirEliminarYEliminarParada() {
		Coordenada np = new Coordenada(10.009, 10.009);
		linea.añadirParada(1, np);
		linea.eliminarParada(2);
		linea.eliminarParada(1);
	}
	
	@Test
	public void testSecuenciaAñadirParadaYModificarInicial() {
		Coordenada np = new Coordenada(10.009, 10.009);
		Coordenada ni = new Coordenada(10.0001, 10.0001);
		linea.añadirParada(1, np);
		linea.cambiarParadaInicial(ni);
		Coordenada[] exp = {ni, np, p1, p2};
		assertArrayEquals(exp, linea.getParadas());
	}
	
	@Test
	public void testSecuenciaAñadirEliminarYModificarFinal() {
		Coordenada np = new Coordenada(10.009, 10.009);
		Coordenada nf = new Coordenada(10.0001, 10.0001);
		linea.añadirParada(1, np);
		linea.eliminarParada(2);
		linea.cambiarParadaFinal(nf);
		Coordenada[] exp = {p0, np, nf};
		assertArrayEquals(exp, linea.getParadas());
	}
	
	@Test
	public void testSecuenciaAñadirEliminarYAñadirParada() {
		Coordenada np = new Coordenada(10.009, 10.009);
		linea.añadirParada(1, np);
		linea.eliminarParada(2);
		linea.añadirParada(1, p1);
		Coordenada[] exp = {p0, p1, np, p2};
		assertArrayEquals(exp, linea.getParadas());
	}
}
