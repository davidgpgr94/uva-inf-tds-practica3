package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.Test;

public class RedAutobusesFixtureConCorrespondenciaMockingLineaTest {

	private RedAutobuses red;
	private Coordenada[] cords1;
	private Coordenada[] cords2;
	private Coordenada[] cords3;
	Linea[] lineas;
	
	@Mock
	private Linea linea1,linea2,linea3;

	

	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1 = { new Coordenada(12, 12), new Coordenada(12.002, 12.002), new Coordenada(12.01, 12.01), new Coordenada(12.005, 12.005), new Coordenada(12.0005, 12.0005) };
		Coordenada[] cords2 = { new Coordenada(12.05, 12.05), new Coordenada(12.01, 12.01), new Coordenada(12.0506, 12.0506) };
		Coordenada[] cords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		this.cords1=cords1;
		this.cords2=cords2;
		this.cords3=cords3;
		
		linea1=createMock(Linea.class);
		linea2=createMock(Linea.class);
		linea3=createMock(Linea.class);
		
		expect(linea1.getId()).andReturn(1).anyTimes();
		expect(linea2.getId()).andReturn(2).anyTimes();
		expect(linea3.getId()).andReturn(3).anyTimes();
		expect(linea1.getParadas()).andReturn(cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(cords2).anyTimes();
		expect(linea3.getParadas()).andReturn(cords3).anyTimes();
		
		lineas= new Linea[3];
		lineas[0]=linea1;
		lineas[1]=linea2;
		lineas[2]=linea3;
		
	}
	
	@Test
	public void testMockHayLineasEnRadio() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		assertTrue(red.hayLineasEnRadio(new Coordenada(24.30031, 24.30031), 50));
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test
	public void testMockHayLineasEnRadioFalse() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		assertFalse(red.hayLineasEnRadio(new Coordenada(50, 50), 100));
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMockHayLineasEnRadioCoordenadaNula() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		boolean respuesta = red.hayLineasEnRadio(null, 10);
	}

	@Test
	public void testMockGetLineasEnRadio() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		
		Linea[] lineasEsperadas = {linea3};
		Linea[] lineasRadio = red.getLineasEnRadio(new Coordenada(24.30031, 24.30031), 50);
		assertArrayEquals(lineasEsperadas, lineasRadio);
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testMockGetLineasEnRadioCoordenadaNula() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Linea[] lineas = red.getLineasEnRadio(null, 10);
	}

	@Test(expected = IllegalStateException.class)
	public void testMockGetLineasEnRadioSinLineasEnElRadio() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Linea[] lineas = red.getLineasEnRadio(new Coordenada(50, 50), 100);
	}
	
	@Test
	public void testMockTieneAlgunaCorrespondenciaTrue() {
		expect(linea2.hayParadasCercanas(cords1[0])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[1])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[2])).andReturn(true).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[3])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[4])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[0])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[1])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[2])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[3])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[4])).andReturn(false).anyTimes();
		
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		assertTrue(red.tieneAlgunaCorrespondencia(1));
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test
	public void testMockTieneAlgunaCorrespondenciaFalse() {
		expect(linea1.hayParadasCercanas(cords3[0])).andReturn(false).anyTimes();
		expect(linea1.hayParadasCercanas(cords3[1])).andReturn(false).anyTimes();
		expect(linea1.hayParadasCercanas(cords3[2])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[0])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[1])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[2])).andReturn(false).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		assertFalse(red.tieneAlgunaCorrespondencia(3));
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockTieneAlgunaCorrespondenciaLaRedNoTieneLaLineaConsultada() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		boolean respuesta = red.tieneAlgunaCorrespondencia(4);
	}
	


	@Test
	public void testMockGetCorrespondencias() {
		expect(linea2.hayParadasCercanas(cords1[0])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[1])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[2])).andReturn(true).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[3])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[4])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[0])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[1])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[2])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[3])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[4])).andReturn(false).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
				
		Linea[] lineasEsperadas = {linea2};
		Linea[] correspondencias=  red.getCorrespondencias(1);
		
		assertArrayEquals(lineasEsperadas,correspondencias);
		verify(linea1);
		verify(linea2);
		verify(linea3);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetCorrespondenciasLaRedNoTieneLaLineaConsultada() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Linea[] respuesta = red.getCorrespondencias(4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetCorrespondenciaLaLineaNoTieneCorrespondencias() {
		expect(linea1.hayParadasCercanas(cords3[0])).andReturn(false).anyTimes();
		expect(linea1.hayParadasCercanas(cords3[1])).andReturn(false).anyTimes();
		expect(linea1.hayParadasCercanas(cords3[2])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[0])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[1])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[2])).andReturn(false).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Linea[] respuesta = red.getCorrespondencias(3);
	}
	
	@Test
	public void testMockGetParadasCorrespondencia() {
		expect(linea2.hayParadasCercanas(cords1[0])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[1])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[2])).andReturn(true).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[3])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords1[4])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[0])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[1])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[2])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[3])).andReturn(false).anyTimes();
		expect(linea3.hayParadasCercanas(cords1[4])).andReturn(false).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		Coordenada[] solucion = red.getParadasCorrespondencia(1);
		Coordenada[] esperado = {new Coordenada(12.01, 12.01)};
		assertArrayEquals(esperado, solucion);
		verify(linea1);
		verify(linea2);
		verify(linea3);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetParadasCorrespondenciaLaRedNoTieneLaLineaConsultada() {
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Coordenada[] solucion = red.getParadasCorrespondencia(4);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testMockGetParadasCorrespondenciaLaLineaNoTieneCorrespondencias() {
		expect(linea1.hayParadasCercanas(cords3[0])).andReturn(false).anyTimes();
		expect(linea1.hayParadasCercanas(cords3[1])).andReturn(false).anyTimes();
		expect(linea1.hayParadasCercanas(cords3[2])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[0])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[1])).andReturn(false).anyTimes();
		expect(linea2.hayParadasCercanas(cords3[2])).andReturn(false).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		red = new RedAutobuses(lineas);
		@SuppressWarnings("unused")
		Coordenada[] solucion = red.getParadasCorrespondencia(3);
	}



}
