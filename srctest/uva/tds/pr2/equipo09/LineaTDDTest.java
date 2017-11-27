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
			assertEquals(linea.coordenadas.size(),3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaIdentificadorNoValido() {
			int identificador=-1;
			Coordenada[] coordenadas={new Coordenada(9.25639,10.25639),new Coordenada(11.25639,12.25639),new Coordenada(12.25639,13.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaCoordenadasNoValidas() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(9.25639,10.25639),new Coordenada(11.25639,12.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
			
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorCoordenadasNull() {
			int identificador=1;
			Coordenada[] coordenadas=null; 
			Linea linea = new Linea(identificador,coordenadas);
			
	}

	@Test
	public void testTDDAñadirParada(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(9.25639,10.25639),new Coordenada(11.25639,12.25639),new Coordenada(12.25639,13.25639)};
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParada=new Coordenada(9.55639,10.55639);
		
		linea.añadirParada(nuevaParada);
		assertEquals(4, linea.coordenadas.size());
	}
	
	
	

}
