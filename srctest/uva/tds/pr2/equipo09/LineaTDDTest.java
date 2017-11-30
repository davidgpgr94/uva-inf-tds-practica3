package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineaTDDTest {

	@Test
	public void testTDDConstructorLinea() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
			assertEquals(linea.identificador, 1);
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
	

	@Test
	public void testTDDCambiarInicioParada(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaInicial= new Coordenada(12.25585,12.25585);
		linea.cambiarParadaInicial(nuevaParadaInicial);
		assertEquals(4, linea.coordenadas.size());
		assertEquals(nuevaParadaInicial, linea.coordenadas.get(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarInicioParadaNuevaParadaNull(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaInicial= null;
		linea.cambiarParadaInicial(nuevaParadaInicial);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarInicioParadaNuevaParadaYaExiste(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaInicial=new Coordenada(12.25580,12.25580);
		linea.cambiarParadaInicial(nuevaParadaInicial);		
	}
	
	@Test(expected=IllegalStateException.class)
	public void testTDDCambiarInicioParadaNuevaParadaDistaMasMetros(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaInicial= new Coordenada(12.25575,12.25575);
		linea.cambiarParadaInicial(nuevaParadaInicial);		
	}
	
	@Test
	public void testTDDCambiarParadaFinal(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaFinal= new Coordenada(12.25630,12.25630);
		linea.cambiarParadaInicial(nuevaParadaFinal);
		assertEquals(4, linea.coordenadas.size());
		assertEquals(nuevaParadaFinal, linea.coordenadas.get(linea.coordenadas.size()-1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarParadaFinalNuevaParadaNull(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaFinal= null;
		linea.cambiarParadaFinal(nuevaParadaFinal);
		assertEquals(4, linea.coordenadas.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarParadaFinalNuevaParadaYaExiste(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaFinal= new Coordenada(12.25639,12.25639);
		linea.cambiarParadaFinal(nuevaParadaFinal);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testTDDCambiarParadaFinalNuevaParadaDistaMasMetros(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada nuevaParadaFinal= new Coordenada(12.25645,12.25645);
		linea.cambiarParadaFinal(nuevaParadaFinal);
	}
	
	@Test
	public void testTDDgetParadaCercaDeUnaCoordenada(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		Coordenada coordenadaDeBusqueda=new Coordenada(12.25550, 12.25570);
		
		Coordenada[] paradasCercanas=linea.getParadasCercanas(coordenadaDeBusqueda);
		Coordenada[] resultado={new Coordenada(12.25570,12.25570)};
		
		assertEquals(1, paradasCercanas.length);
		assertArrayEquals(resultado, paradasCercanas);
	}
	
	

}
