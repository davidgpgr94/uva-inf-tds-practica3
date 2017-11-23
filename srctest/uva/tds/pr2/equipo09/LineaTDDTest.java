package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineaTDDTest {

	@Test
	public void testTDDConstructorLinea() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(9.25639,10.25639),new Coordenada(11.25639,12.25639),new Coordenada(12.25639,13.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
			assertEquals(linea.getIdentificador(), 1);
			assertEquals(coordenadas.length,3);
	}
	
	
	

	

}
