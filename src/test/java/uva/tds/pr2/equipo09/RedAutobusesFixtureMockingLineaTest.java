package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobusesFixtureMockingLineaTest {
	
	private RedAutobuses red;
	private Coordenada[] cords1;
	private Coordenada[] cords2;
	private Linea[] lineas;
	
	@Mock
	private Linea linea1, linea2, linea3;
	
	
	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1aux = { new Coordenada(12.25580, 12.25580), new Coordenada(12.25570, 12.25570), new Coordenada(12.25639, 12.25639) };
		Coordenada[] cords2aux = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		cords1 = cords1aux;
		cords2 = cords2aux;
		
		linea1 = createMock(Linea.class);
		linea2 = createMock(Linea.class);
		expect(linea1.getId()).andReturn(1).anyTimes();
		expect(linea2.getId()).andReturn(2).anyTimes();
		
		lineas = new Linea[2];
		lineas[0] = linea1;
		lineas[1] = linea2;
		//red = new RedAutobuses(lineas); //creamos la red en cada metodo test tras definir los expect que faltan para las lineas
	}
	
	@Test
	public void testMockGetLinea() {
		expect(linea1.getParadas()).andReturn(cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(cords2).anyTimes();
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		Linea l1 = red.getLinea(1);
		assertEquals(linea1, l1);
		verify(linea1);
		verify(linea2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetLineaConIdNoExistenteEnLaRed() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Linea l1 = red.getLinea(3);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMockGetLineaConIdNoValido() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Linea l1 = red.getLinea(0);
	}
	
	@Test
	public void testMockAddLinea() {
		Coordenada[] cords3 = { new Coordenada(10.2, 10.2), new Coordenada(10.21, 10.21), new Coordenada(10.2004, 10.2004) };
		linea3 = createMock(Linea.class);
		expect(linea3.getId()).andReturn(3).anyTimes();
		expect(linea1.getParadas()).andReturn(cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(cords2).anyTimes();
		expect(linea3.getParadas()).andReturn(cords3).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		red.addLinea(linea3);
		Linea[] lineasEsperadas = { linea1, linea2, linea3 };
		assertArrayEquals(lineasEsperadas, red.lineas.values().toArray(new Linea[0]));
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMockAddLineaArgumentoNulo() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		red.addLinea(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockAddLineaConIdentificadorDeNuevaYaExistenteEnLaRed() {
		linea3 = createMock(Linea.class);
		expect(linea3.getId()).andReturn(2).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		red.addLinea(linea3);
	}
	
	@Test
	public void testMockHayLinea() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		assertTrue(red.hayLinea(2));
	}
	
	@Test
	public void testMockHayLineaFalse() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		assertFalse(red.hayLinea(3));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMockHayLineaConParametroInvalido() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		boolean res = red.hayLinea(0);
	}
	
	@Test
	public void testMockEliminarLinea() {
		linea3 = createMock(Linea.class);
		
		expect(linea3.getId()).andReturn(3).anyTimes();
		expect(linea1.getParadas()).andReturn(cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(cords2).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		
		Linea[] lineas = { linea1, linea2, linea3 };
		red = new RedAutobuses(lineas);
		red.eliminarLinea(3);
		Linea[] lineasEsperadas = { linea1, linea2 };
		assertArrayEquals(lineasEsperadas, red.lineas.values().toArray(new Linea[0]));
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockEliminarLineaNoExistenteEnLaRed() {
		linea3 = createMock(Linea.class);
		
		expect(linea3.getId()).andReturn(3).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		
		Linea[] lineas = { linea1, linea2, linea3 };
		red = new RedAutobuses(lineas);
		red.eliminarLinea(4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockEliminarLineaHabiendoSoloDosLineasEnLaRed() {
		replay(linea1);
		replay(linea2);
		red = new RedAutobuses(lineas);
		red.eliminarLinea(2);
	}
	
	@Test
	public void testMockGetLineas() {
		expect(linea1.getParadas()).andReturn(cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(cords2).anyTimes();
		replay(linea1);
		replay(linea2);
		
		red = new RedAutobuses(lineas);
		Linea[] lineasEsperadas = { linea1, linea2 };
		assertArrayEquals(lineasEsperadas, red.getLineas());
		verify(linea1);
		verify(linea2);
	}
	
}
