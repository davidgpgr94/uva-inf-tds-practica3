package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

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
			@SuppressWarnings("unused")
			Linea linea = new Linea(identificador,coordenadas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaCoordenadasDistanMasMetros() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25510,12.25510),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
			@SuppressWarnings("unused")
			Linea linea = new Linea(identificador,coordenadas);
			
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorLineaCantidadCoordenadasNoValidas() {
			int identificador=1;
			Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25639,13.25639)};
			@SuppressWarnings("unused")
			Linea linea = new Linea(identificador,coordenadas);
			
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDConstructorCoordenadasNull() {
			int identificador=1;
			Coordenada[] coordenadas=null; 
			@SuppressWarnings("unused")
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
	
	@Test
	public void testLineaEqualsThis(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		
		Linea linea = new Linea(identificador,coordenadas);
		

		assertEquals(linea, linea);
		assertTrue(linea.hashCode()==linea.hashCode());
	}

	
	@Test
	public void testLineaEqualsLinea(){
		int identificador=1;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		
		Linea linea1,linea2;
		linea1 = new Linea(identificador,coordenadas);
		linea2= new Linea(identificador, coordenadas);

		assertEquals(linea1, linea2);
		assertTrue(linea1.hashCode()==linea2.hashCode());
	}
	
	@Test
	public void testLineaEqualsLineaOtroId(){
		int identificador1=1;
		int identificador2=2;
		Coordenada[] coordenadas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		
		Linea linea1,linea2;
		linea1 = new Linea(identificador1,coordenadas);
		linea2= new Linea(identificador2, coordenadas);
		assertNotEquals(linea1, linea2);
		assertFalse(linea1.hashCode()==linea2.hashCode());
	}
	
	@Test
	public void testLineaEqualsLineaOtrasCoordenadas(){
		int identificador=1;
		Coordenada[] coordenadas1={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
		Coordenada[] coordenadas2={new Coordenada(12.25590,12.25590),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
		
		Linea linea1,linea2;
		linea1 = new Linea(identificador,coordenadas1);
		linea2= new Linea(identificador, coordenadas2);
		assertNotEquals(linea1, linea2);
		assertFalse(linea1.hashCode()==linea2.hashCode());
	}
	
	
}
