package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * @author ginquin
 * @author davidgo
 *
 */
@Category(Isolation.class)
public class RedAutobusesFixtureMockingLineaRedConTresLineasDosConTransbordoDirectoTest {

	private RedAutobuses red;
	private Coordenada[] cords1;
	private Coordenada[] cords2;
	private Coordenada[] cords3;
	private Linea[] lineas;
	
	@Mock
	private Linea linea1, linea2, linea3;
	
	private static double ERROR_ADMISIBLE = 0.0001;

	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1 = { new Coordenada(12, 12), new Coordenada(12.002, 12.002), new Coordenada(12.01, 12.01), new Coordenada(12.005, 12.005), new Coordenada(12.0005, 12.0005) };
		Coordenada[] cords2 = { new Coordenada(12.05, 12.05), new Coordenada(12.01, 12.01), new Coordenada(12.0506, 12.0506) };
		Coordenada[] cords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		this.cords1 = cords1;
		this.cords2 = cords2;
		this.cords3 = cords3;
		
		linea1 = createMock(Linea.class);
		linea2 = createMock(Linea.class);
		linea3 = createMock(Linea.class);
		expect(linea1.getId()).andReturn(1).anyTimes();
		expect(linea2.getId()).andReturn(2).anyTimes();
		expect(linea3.getId()).andReturn(3).anyTimes();
		expect(linea1.getParadas()).andReturn(this.cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(this.cords2).anyTimes();
		expect(linea3.getParadas()).andReturn(this.cords3).anyTimes();
		
		lineas = new Linea[3];
		lineas[0] = linea1;
		lineas[1] = linea2;
		lineas[2] = linea3;
	}
	
	@Test
	public void testMockHayTransbordoDirecto() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		assertTrue(red.hayTransbordoDirecto(1, 2));
		
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test
	public void testMockHayTransbordoDirectoFalse() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		assertFalse(red.hayTransbordoDirecto(1, 3));
		
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockHayTransbordoDirectoLaRedNoTieneLaLineaA() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(4, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockHayTransbordoDirectoLaRedNoTieneLaLineaB() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(1, 4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockHayTransbordoDirectoLaRedNoTieneLaLineaANiB() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(4, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMockAmplCoberturaHayTransbordoDirectoIdentificadoresIguales() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		boolean respuesta = red.hayTransbordoDirecto(1, 1);
	}
	
	@Test
	public void testMockGetParadasConTransbordoDirecto() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		Coordenada[] paradasEsperadas = { new Coordenada(12.01, 12.01) };
		assertArrayEquals(paradasEsperadas, red.getParadasConTransbordo(1, 2));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetParadasConTransbordoDirectoLaRedNoTieneLaLineaA() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(4, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetParadasConTransbordoDirectoLaRedNoTieneLaLineaB() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(1, 4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetParadasConTransbordoDirectoNoHayParadasConTransbordoDirecto() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(1, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMockAmplCoberturaGetParadasConTransbordoDirectoIdentificadoresIguales() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		Coordenada[] respuesta = red.getParadasConTransbordo(1, 1);
	}
	
	@Test
	public void testMockGetDistanciaParadas() {
		expect(linea1.getParada(eq(3))).andReturn(this.cords1[3]).anyTimes();
		expect(linea2.getParada(eq(2))).andReturn(this.cords2[2]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		assertEquals(red.getDistanciaParadas(1, 3, 2, 2), 6682, ERROR_ADMISIBLE);
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetDistanciaParadasLaRedNoContieneAlgunaDeLasLineas() {
		expect(linea1.getParada(eq(2))).andReturn(this.cords1[2]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(4, 1, 1, 2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockAmplCoberturaGetDistanciaParadasLaRedNoContieneLaSegundaLineaIndicada() {
		expect(linea1.getParada(eq(1))).andReturn(this.cords1[1]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, 1, 4, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetDistanciaParadasPosicionParadaAInvalida() {
		expect(linea2.getParada(eq(1))).andReturn(this.cords2[1]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, 6, 2, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockAmplCoberturaGetDistanciaParadasPosicionParadaAInvalidaMenorQueCero() {
		expect(linea2.getParada(eq(1))).andReturn(this.cords2[1]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, -1, 2, 1);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetDistanciaParadasPosicionParadaBInvalida() {
		expect(linea1.getParada(eq(1))).andReturn(this.cords1[1]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, 1, 2, 4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockAmplCoberturaGetDistanciaParadasPosicionParadaBInvalidaMenorQueCero() {
		expect(linea1.getParada(eq(1))).andReturn(this.cords1[1]).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		@SuppressWarnings("unused")
		double respuesta = red.getDistanciaParadas(1, 1, 2, -1);
	}
	
}
