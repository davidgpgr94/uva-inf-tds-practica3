package uva.tds.pr2.equipo09;

import java.util.ArrayList;
/**
 * Representación de una línea de bus.
 * @author ginquin
 * @author davidgo
 * 
 */
public class Linea {
	
	protected ArrayList<Coordenada> paradas;
	protected int identificador;
	
	/**
	 * Inicializa una línea con identificador y una serie de coordenadas(paradas).
	 * @pre.condition {@code identificador>=1}
	 * @pre.condition {@code coordenadas.size() >=3}
	 * @param identificador Identificador de la linea, debe ser >=1.
	 * @param coordenadas paradas que tiene la línea,mínimo de tres paradas.
	 * @throws IllegalArgumentException Identificador no válido.
	 * @throws IllegalArgumentException coordenada inicial y final distan más o igual a 100 metros.
	 * @throws IllegalArgumentException coordenadas(paradas) nulas.
	 */
	public Linea(int identificador, Coordenada[] coordenadas) {
		this.identificador=identificador;
		this.paradas=new ArrayList<>();
	}

	/**
	 * Añade una parada intermedia a la lista de paradas de la línea.
	 * @pre.condition {@code posicion > 0 || posicion < paradas.size()-1}
	 * @pre.condition {@code !coordenadas.contains(nuevaParadaInicial)}
	 * @post.condition se ha añadido una nueva parada intermedia.
	 * @param posicion posición de la parada. 
	 * @param nuevaParada parada que se va a añadir a las paradas de líneas.
	 * @throws IllegalArgumentException nueva parada es null.
	 * @throws IllegalArgumentException nueva parada ya existe.
	 * @throws IllegalArgumentException posicion menor igual que el inicio del recorrido.
	 * @throws IllegalArgumentException posicion mayor igual que el final del recorrido.
	 */
	public void añadirParada(int posicion, Coordenada nuevaParada) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Elimina una parada intermedia de la línea.
	 * @pre.condition {@code posicion > 0 || posicion < paradas.size()-1}
	 * @post.condition se ha eliminado una parada intermedia.
	 * @param posicion posicion de la parada a eliminar.
	 * @throws IllegalArgumentException posicion menor igual que el inicio del recorrido
	 * @throws IllegalArgumentException posicion mayor igual que el final del drecoriido.
	 * @throws IllegalStateException no se puede eliminar, no pueden haber menos de 3 paradas.
	 */
	public void eliminarParada(int posicion) {
		// TODO Auto-generated method stub		
	}

	/**
	 * Permite cambiar la parada Inicial de la línea.
	 * @pre.condition {@code !paradas.contains(nuevaParadaInicial)}
	 * @post.condition se ha cambiado la parada inicial.
	 * @param nuevaParadaInicial nueva parada incial de la linea.
	 * @throws IllegalArgumentException nueva parada es null.
	 * @throws IllegalArgumentException nueva parada ya existe.
	 * @throws IllegalStateException nueva parada dista mas o igual a 100 metros de la parada final.
	 */
	public void cambiarParadaInicial(Coordenada nuevaParadaInicial) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Permite cambiar la parada Final de la linea.
	 * @param nuevaParadaInicial nueva parada final de la línea.
	 * @pre.condition {@code !coordenadas.contains(nuevaParadaFinal)}
	 * @post.condition se ha cambiado la parada final.
	 * @throws IllegalArgumentException nueva parada es null.
	 * @throws IllegalArgumentException nueva parada ya existe.
	 * @throws IllegalStateException nueva parada dista mas o igual a 100 metros de la parada inicial.
	 */
	public void cambiarParadaFinal(Coordenada nuevaParadaFinal) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Permite obtener las paradas cercanas a una coordenada dada.
	 * @post.condition colección de paradas cercanas.
	 * @param coordenadaDeBusqueda coordenada con la que se va a realizar la búsqueda.
	 * @return coleccion de paradas cercanas, o vacío en caso de que no haya.
	 * @throws IllegalArgumentException coordenada de búsqueda null.
	 */
	public Coordenada[] getParadasCercanas(Coordenada coordenadaDeBusqueda) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Permite saber si hay o no paradas cercanas a una coordenada dada.
	 * @post.condition hay o no paradas cercanas.
	 * @param coordenadaDeBusqueda coordenada con la que se va a realizar la busqueda.
	 * @return  true si hay paradas cercanas y falso en caso contrario.
	 * @throws IllegalArgumentException coordenada de busqueda null.
	 */
	public boolean hayParadasCercanas(Coordenada coordenadaDeBusqueda) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Permite obtener una parada a través de su id (posicion).
	 * @pre.condition {@code idParada >= 0 || idParada < coordenadas.size()}
	 * @post.condition devuelve la parada solicitada.
	 * @param idParada identificador de la parada a obtener.
	 * @return parada solicitada.
	 * @throws IllegalArgumentException idParada < 0 || idParada >= coordenadas.size()
	 */
	public Coordenada getParada(int idParada) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
