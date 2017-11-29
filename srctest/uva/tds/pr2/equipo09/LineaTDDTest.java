package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineaTDDTest {

	@Test
	public void testTDDConstructorLinea() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
			assertEquals(linea.getIdentificador(), 1);
			assertEquals(3,linea.coordenadas.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaIdentificadorNoValido() {
			int identificador=0;
			Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaCoordenadasDistanMasMetros() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25510,12.25510),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
			Linea linea = new Linea(identificador,coordenadas);
			
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaCantidadCoordenadasNoValidas() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25639,13.25639)};
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
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParada=new Coordenada(12.25600,12.25600);
		int posicion=1;
		linea.añadirParada(posicion,nuevaParada);
		assertEquals(4, linea.coordenadas.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaRepetida(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParada=new Coordenada(12.25570,12.25570);
		int posicion=1;
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaNull(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParada=null;
		int posicion=1;
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaPosicionIncorrectaMenor(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParada=new Coordenada(12.25600,12.25600);
		int posicion=0;
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaPosicionIncorrectaMayor(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParada=new Coordenada(12.25600,12.25600);
		int posicion=linea.coordenadas.size()-1;
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test
	public void testTDDEliminarParada(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		int posicion =1;
		linea.eliminarParada(posicion);
		assertEquals(3, linea.coordenadas.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDEliminarParadaPosicionIncorrectaMenor(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		int posicion =0;
		linea.eliminarParada(posicion);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDEliminarParadaPosicionIncorrectaMayor(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		int posicion =linea.coordenadas.size()-1;
		linea.eliminarParada(posicion);		
	}
	
	@Test(expected=IllegalStateException.class)
	public void testTDDEliminarParadaMenorATresParadas(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		int posicion =1;
		linea.eliminarParada(posicion);
	}
	

	
	
	

}
