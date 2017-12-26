package uva.tds.pr2.equipo09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(Sequences.class)
public class RedAutobusesSequencesTest {
	
	//Las lineas 1 y 2 tienen correspondencia (paradas: 2-0, 2-2)
	//Las lineas 2 y 4 tienen correspondencia (paradas: 0-1, 2-1)
	//Las lineas 1 y 4 tienen transbordo directo (paradas 2 y 1 respectivamente)
	//La linea 3 no tiene ni correspondencias ni transbordos directos
	private Coordenada[] cords1 = { new Coordenada(12, 12), new Coordenada(12.002, 12.002), new Coordenada(12.01, 12.01), new Coordenada(12.005, 12.005), new Coordenada(12.0005, 12.0005) };
	private Coordenada[] cords2 = { new Coordenada(12.01, 12.0082), new Coordenada(12.02, 12.0082), new Coordenada(12.0109, 12.0082) };
	private Coordenada[] cords3 = { new Coordenada(24.3, 24.3), new Coordenada(24.303, 24.303), new Coordenada(24.3006, 24.3006) };
	private Coordenada[] cords4 = { new Coordenada(12.05, 12.05), new Coordenada(12.01, 12.01), new Coordenada(12.0506, 12.0506) };
	private Linea linea1 = new Linea(1, cords1);
	private Linea linea2 = new Linea(2, cords2);
	private Linea linea3 = new Linea(3, cords3);
	private Linea linea4 = new Linea(4, cords4);
	private RedAutobuses red;

	@Before
	public void setUp() throws Exception {
		Linea[] lineas = { linea1, linea3};
		red = new RedAutobuses(lineas);
	}

	@Test
	public void testSecuenciaAñadirDosLineasConCorrespondenciaYTansbordo() {
		red.addLinea(new Linea(2, cords2));
		red.addLinea(new Linea(4, cords4));
		Linea[] exp = {linea1, linea4};
		Coordenada[] paradasExp = {cords2[2], cords2[0]};
		assertArrayEquals(exp,red.getCorrespondencias(2));
		assertArrayEquals(paradasExp, red.getParadasCorrespondencia(2));
	}

}
