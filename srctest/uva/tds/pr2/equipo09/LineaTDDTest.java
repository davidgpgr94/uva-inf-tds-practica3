package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
/**
 * 
 * @author quinquin
 * @author davidgo
 * 
 */
public class LineaTDDTest {

	@Test
	public void testTDDConstructorLinea() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
			Linea linea = new Linea(identificador,coordenadas);
			
			assertEquals(1,linea.identificador);
			assertEquals(3,linea.paradas.size());
			assertArrayEquals(coordenadas, linea.paradas.toArray(new Coordenada[1]));
			assertNotNull(linea);;
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
	public void testTDDEliminarParada(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		Linea linea = new Linea(identificador,coordenadas);
		
		int posicion =1;
		linea.eliminarParada(posicion);
		
		Coordenada[] resultado={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
		
		assertEquals(3, linea.paradas.size());
		assertArrayEquals(resultado, linea.paradas.toArray(new Coordenada[1]));
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
		
		int posicion =3;
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
