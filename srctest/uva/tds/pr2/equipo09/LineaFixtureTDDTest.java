package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author quinquin
 * @author davidgo
 *
 */
public class LineaFixtureTDDTest {
	private Linea linea;

	
	@Before
	public void setUp(){
		int identificador=1;
		Coordenada[] paradas={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
		linea = new Linea(identificador,paradas);
	}
	
	@After
	public void tearDown(){
		linea=null;
	}

	@Test
	public void testTDDAñadirParada(){
		int posicion=1;
		Coordenada nuevaParada=new Coordenada(12.25600,12.25600);
		linea.añadirParada(posicion,nuevaParada);
		
		Coordenada[] resultado={new Coordenada(12.25580,12.25580),new Coordenada(12.25600,12.25600),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)};
		
		assertEquals(4, linea.paradas.size());
		assertArrayEquals(resultado, linea.paradas.toArray(new Coordenada[1]));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaRepetida(){
		int posicion=1;
		Coordenada nuevaParada=new Coordenada(12.25570,12.25570);
		
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaNull(){
		int posicion=1;
		Coordenada nuevaParada=null;
		
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaPosicionIncorrectaMenor(){
		int posicion=0;
		Coordenada nuevaParada=new Coordenada(12.25600,12.25600);
		
		linea.añadirParada(posicion,nuevaParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDAñadirParadaPosicionIncorrectaMayor(){
		int posicion=2;
		Coordenada nuevaParada=new Coordenada(12.25600,12.25600);
		
		linea.añadirParada(posicion,nuevaParada);
	}
	

	@Test
	public void testTDDCambiarInicioParada(){	
		Coordenada nuevaParadaInicial= new Coordenada(12.25585,12.25585);
		linea.cambiarParadaInicial(nuevaParadaInicial);
		
		Coordenada[] resultado={new Coordenada(12.25585,12.25585),new Coordenada(12.25570,12.25570),new Coordenada(12.25639,12.25639)}; 
		
		assertEquals(3, linea.paradas.size());
		assertArrayEquals(resultado, linea.paradas.toArray(new Coordenada[1]));
		assertEquals(nuevaParadaInicial, linea.paradas.get(0));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarInicioParadaNuevaParadaNull(){
		Coordenada nuevaParadaInicial= null;
		linea.cambiarParadaInicial(nuevaParadaInicial);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarInicioParadaNuevaParadaYaExiste(){
		Coordenada nuevaParadaInicial=new Coordenada(12.25580,12.25580);
		linea.cambiarParadaInicial(nuevaParadaInicial);		
	}
	
	@Test(expected=IllegalStateException.class)
	public void testTDDCambiarInicioParadaNuevaParadaDistaMasMetros(){
		Coordenada nuevaParadaInicial= new Coordenada(12.25575,12.25575);
		linea.cambiarParadaInicial(nuevaParadaInicial);		
	}
	
	@Test
	public void testTDDCambiarParadaFinal(){		
		Coordenada nuevaParadaFinal= new Coordenada(12.25630,12.25630);
		linea.cambiarParadaInicial(nuevaParadaFinal);	
		
		Coordenada[] resultado={new Coordenada(12.25580,12.25580),new Coordenada(12.25570,12.25570),new Coordenada(12.25630,12.25630)}; 
	
		assertEquals(3, linea.paradas.size());
		assertArrayEquals(resultado, linea.paradas.toArray(new Coordenada[1]));
		assertEquals(nuevaParadaFinal, linea.paradas.get(linea.paradas.size()-1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarParadaFinalNuevaParadaNull(){
		Coordenada nuevaParadaFinal= null;
		linea.cambiarParadaFinal(nuevaParadaFinal);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDCambiarParadaFinalNuevaParadaYaExiste(){		
		Coordenada nuevaParadaFinal= new Coordenada(12.25639,12.25639);
		linea.cambiarParadaFinal(nuevaParadaFinal);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testTDDCambiarParadaFinalNuevaParadaDistaMasMetros(){
		Coordenada nuevaParadaFinal= new Coordenada(12.25645,12.25645);
		linea.cambiarParadaFinal(nuevaParadaFinal);
	}
	
	@Test
	public void testTDDgetParadaCercaDeUnaCoordenada(){
		
		Coordenada coordenadaDeBusqueda=new Coordenada(12.25550, 12.25570);
		Coordenada[] paradasCercanas=linea.getParadasCercanas(coordenadaDeBusqueda);
		
		Coordenada[] resultado={new Coordenada(12.25570,12.25570)};
		
		assertEquals(1, paradasCercanas!=null?paradasCercanas.length:new Integer(1));
		assertArrayEquals(resultado, paradasCercanas);
	}
	
	
	
	@Test
	public void testTDDgetParadaCercaDeUnaCoordenadaDevuelveMasDeUna(){
		Coordenada coordenadaDeBusqueda=new Coordenada(12.25700,12.25710);
		Coordenada[] paradasCercanas=linea.getParadasCercanas(coordenadaDeBusqueda);
		
		Coordenada[] resultado={new Coordenada(12.25580,12.25580),new Coordenada(12.25639,12.25639)};
		
		assertEquals(2, paradasCercanas!=null?paradasCercanas.length:new Integer(2));
		assertArrayEquals(resultado, paradasCercanas);
	}
	
	@Test
	public void testTDDgetParadaCercaDeUnaCoordenadaDevuelveVacio(){
		Coordenada coordenadaDeBusqueda=new Coordenada(12.25800, 12.25800);
		
		Coordenada[] paradasCercanas=linea.getParadasCercanas(coordenadaDeBusqueda);
		
		Coordenada[] resultado={};
		
		assertEquals(0, paradasCercanas!=null?paradasCercanas.length:new Integer(0));
		assertArrayEquals(resultado, paradasCercanas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDgetParadaCercaDeUnaCoordenadaNull(){
		Coordenada coordenadaDeBusqueda=null;
		
		Coordenada[] paradasCercanas=linea.getParadasCercanas(coordenadaDeBusqueda);
	}
	
	@Test
	public void testTDDHayParadaCercana(){
		Coordenada coordenadaDeBusqueda=new Coordenada(12.25570,12.25570);
		
		boolean hayParadasCercanas=linea.hayParadasCercanas(coordenadaDeBusqueda);
		
		assertTrue(hayParadasCercanas);
	}
	
	@Test
	public void testTDDHayParadaCercanaFalso(){
		Coordenada coordenadaDeBusqueda=new Coordenada(12.25800, 12.25800);
		
		boolean hayParadasCercanas=linea.hayParadasCercanas(coordenadaDeBusqueda);
		
		assertFalse(hayParadasCercanas);
		fail("Obligado a fallar");//TODO modificar despues de implementar el metodo		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDHayParadaCercanaCoordenadaNull(){
		Coordenada coordenadaDeBusqueda=null;
		boolean hayParadasCercanas=linea.hayParadasCercanas(coordenadaDeBusqueda);
	}
	
	@Test
	public void testTDDGetParada(){
		int idParada=0;
		Coordenada paradaObtenida=linea.getParada(idParada);
		
		Coordenada resultado=new Coordenada(12.25580,12.25580);
		
		assertEquals(resultado, paradaObtenida);
	}
	
	@Test
	public void testTDDGetParadaidParadaMaximo(){
		int idParada=2;
		Coordenada paradaObtenida=linea.getParada(idParada);
		
		Coordenada resultado=new Coordenada(12.25639,12.25639);
		
		assertEquals(resultado, paradaObtenida);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDGetParadaIdParadaMenor(){
		int idParada=-1;
		Coordenada paradaObtenida=linea.getParada(idParada);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTDDGetParadaIdParadaMayor(){
		int idParada=3;
		Coordenada paradaObtenida=linea.getParada(idParada);
	}
}

