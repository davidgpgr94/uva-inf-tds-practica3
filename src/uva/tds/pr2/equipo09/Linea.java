package uva.tds.pr2.equipo09;

import java.util.ArrayList;
/**
 * Representación de una linea de bus.
 */
public class Linea {
	
	protected ArrayList<Coordenada> coordenadas;
	protected int identificador;
	
	/**
	 * Inicializa una linea con identificador y una serie de coordenadas de las paradas.
	 * @param identificador Identificador de la linea, debe ser >=1.
	 * @param coordenadas Coordenadas de las paradas que tiene la linea,mínimo de tres lineas.
	 * @throws IllegalArgumentException Identificador no valido.
	 * @throws IllegalArgumentException Coordenadas no validas, o null.
	 */
	public Linea(int identificador, Coordenada[] coordenadas) {
		this.identificador=identificador;
		this.coordenadas=new ArrayList<>();
	}

	public Object getIdentificador() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Añade una parada a la linea a la lista de paradas.
	 * @param nuevaParada parada que se va a añadir a las paradas de lineas.
	 * @throws IllegalArgumentException nueva parada es null.
	 * @throws IllegalArgumentException nueva parada ya existe.
	 */
	public void añadirParada(Coordenada nuevaParada) {
		// TODO Auto-generated method stub
		
	}

}
