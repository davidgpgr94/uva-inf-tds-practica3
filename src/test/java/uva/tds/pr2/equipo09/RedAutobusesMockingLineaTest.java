package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.easymock.Mock;
import static org.easymock.EasyMock.*;
import org.junit.Test;

/**
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobusesMockingLineaTest {
	
	@Mock
	private Linea linea1, linea2;

	@Test
	public void testTDDConstructorRedAutobuses() {
		
		linea1 = createMock(Linea.class);
		linea2 = createMock(Linea.class);
		
		expect(linea1.getId()).andReturn(1).anyTimes();
		expect(linea2.getId()).andReturn(2).anyTimes();
		replay(linea1);
		replay(linea2);
		
		Linea[] lineas = { linea1, linea2 };
		
		RedAutobuses red = new RedAutobuses(lineas);
		assertArrayEquals(red.lineas.values().toArray(new Linea[0]), lineas);
		verify(linea1);
		verify(linea2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTDDConstructorRedAutobusesSoloUnaLinea() {
		
		linea1 = createMock(Linea.class);
		expect(linea1.getId()).andReturn(1).once();
		
		Linea[] lineas = { linea1 };
		@SuppressWarnings("unused")
		RedAutobuses red = new RedAutobuses(lineas);
	}

}
