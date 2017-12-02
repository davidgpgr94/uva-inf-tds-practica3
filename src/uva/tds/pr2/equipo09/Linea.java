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
	 * @pre.condition {@code identificador>=1}
	 * @pre.condition {@code coordenadas.size() >=3}
	 * @param identificador Identificador de la linea, debe ser >=1.
	 * @param coordenadas Coordenadas de las paradas que tiene la linea,mínimo de tres lineas.
	 * @throws IllegalArgumentException Identificador no valido.
	 * @throws IllegalArgumentException Coordenadas inicio y final distan mas o igual a 100 metros.
	 * @throws IllegalArgumentException Coordenadas nulas.
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
	 * Añade una parada intermedia a la lista de paradas de la linea.
	 * @pre.condition {@code posicion > 0 || posicion < coordenadas.size()-1}
	 * @pre.condition {@code coordenadas.get(nuevaParada)==null}
	 * @post.condition se ha añadido una nueva parada intermedia.
	 * @param posicion posicion de la parada. 
	 * @param nuevaParada parada que se va a añadir a las paradas de lineas.
	 * @throws IllegalArgumentException nueva parada es null.
	 * @throws IllegalArgumentException nueva parada ya existe.
	 * @throws IllegalArgumentException posicion menor igual que el inicio del recorrido.
	 * @throws IllegalArgumentException posicion mayor igual que el final del recorrido.
	 */
	public void añadirParada(int posicion, Coordenada nuevaParada) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Elimina una parada intermedia de la linea.
	 * @pre.condition {@code posicion > 0 || posicion < coordenadas.size()-1}
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
	 * Permite cambiar la parada Inicial de la linea.
	 * @pre.condition {@code !coordenadas.contains(nuevaParadaInicial)}
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
	 * @param nuevaParadaInicial nueva parada final de la linea.
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
	 * @post.condition coleccion de paradas cercanas.
	 * @param coordenadaDeBusqueda coordenada con la que se va a realizar la busqueda.
	 * @return coleccion de paradas cercanas, o vacio en caso de que no haya.
	 * @throws IllegalArgumentException coordenada de busqueda null.
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

	public Coordenada getParada(int idParada) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	

}
