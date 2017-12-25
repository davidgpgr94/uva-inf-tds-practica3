package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.Test;

public class RedAutobusesFixtureConCorrespondenciaMockingLineaTest {

	private RedAutobuses red;
	
	
	@Mock
	private Linea linea1,linea2,linea3,lineaE1;

	

	@Before
	public void setUp() throws Exception {
		Coordenada[] cords1 = { new Coordenada(12, 12), new Coordenada(12.002, 12.002), new Coordenada(12.01, 12.01), new Coordenada(12.005, 12.005), new Coordenada(12.0005, 12.0005) };
		Coordenada[] cords2 = { new Coordenada(12.01, 12.0082), new Coordenada(12.02, 12.0082), new Coordenada(12.0109, 12.0082) };
		Coordenada[] cords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		
		linea1=createMock(Linea.class);
		linea2=createMock(Linea.class);
		linea3=createMock(Linea.class);
		
		expect(linea1.getId()).andReturn(1).anyTimes();
		expect(linea2.getId()).andReturn(2).anyTimes();
		expect(linea3.getId()).andReturn(3).anyTimes();
		expect(linea1.getParadas()).andReturn(cords1).anyTimes();
		expect(linea2.getParadas()).andReturn(cords2).anyTimes();
		expect(linea3.getParadas()).andReturn(cords3).anyTimes();
		replay(linea1);
		replay(linea2);
		replay(linea3);
		Linea[] lineas = new Linea[3];
		lineas[0]=linea1;
		lineas[1]=linea2;
		lineas[2]=linea3;
		red = new RedAutobuses(lineas);
	}
	


	@Test
	public void testTDDgetLineasEnRadio() {
		Coordenada[] auxCords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
		
		lineaE1=createMock(Linea.class);
		
		expect(lineaE1.getId()).andReturn(3).anyTimes();
		expect(lineaE1.getParadas()).andReturn(auxCords3).anyTimes();
		replay(lineaE1);
		
		Linea[] lineasEsperadas = {lineaE1};
		Linea[] lineasRadio = red.getLineasEnRadio(new Coordenada(24.30031, 24.30031), 50);
		assertArrayEquals(lineasEsperadas, lineasRadio);
		verify(lineaE1);
	}
	
	


	@Test
	public void testTDDgetCorrespondencias() {
		Coordenada[] auxCords2 = { new Coordenada(12.01, 12.0082), new Coordenada(12.02, 12.0082), new Coordenada(12.0109, 12.0082) };
		lineaE1=createMock(Linea.class);
		
		expect(lineaE1.getId()).andReturn(2).anyTimes();
		expect(lineaE1.getParadas()).andReturn(auxCords2).anyTimes();
		replay(lineaE1);
		
		Linea[] lineasEsperadas = {lineaE1};
		Linea[] correspondencias=  red.getCorrespondencias(1);
		
		assertArrayEquals(lineasEsperadas,correspondencias);
		verify(lineaE1);
	}


}
