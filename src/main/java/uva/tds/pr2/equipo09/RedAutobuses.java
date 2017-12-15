package uva.tds.pr2.equipo09;

/**
 * Representación de una red de transporte que contiene diferentes líneas de autobuses
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobuses {

	protected Linea[] lineas;
	
	/**
	 * Crea una instancia de RedAutobuses con las líneas pasadas como parámetro.
	 * 
	 * @pre.condition {@code lineas.length >= 2}
	 * @param lineas las líneas de autobús que forman la red de autobuses.
	 * @throws IllegalArgumentException si {@code lineas.length < 2}
	 */
	public RedAutobuses(Linea[] lineas) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Devuelve la línea con el identificador pasado como parámetro
	 * 
	 * @pre.condition {@code id > 0}
	 * @pre.condition {@code hayLinea(id)}
	 * @param id identificador de la línea
	 * @return la línea con el identificador.
	 * @throws IllegalStateException si {@code !hayLinea(id)}
	 * @throws IllegalArgumentException si {@code id < 1}
	 */
	public Linea getLinea(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Añade una nueva línea a la red de autobuses.
	 * 
	 * @pre.condition {@code getLinea(nueva.identificador) == null}
	 * @post.condition se ha añadido una nueva línea.
	 * @param nueva la línea a añadir
	 * @throws IllegalStateException si {@code hayLinea(nueva.identificador)}
	 * @throws IllegalArgumentException si {@code nueva == null}
	 */
	public void addLinea(Linea nueva) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Devuelve true en caso de que la red contenga una línea con el identificador del parámetro. 
	 * False en caso contrario.
	 * 
	 * @param id identificador de la línea.
	 * @return true en caso de que haya una línea en la red con el identificador id. False en caso contrario
	 * @throws IllegalArgumentException si {@code id < 1}
	 */
	public boolean hayLinea(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina la línea indicada mediante el parámetro.
	 * 
	 * @pre.condition {@code hayLinea(id)}
	 * @pre.condition {@code lineas.length > 2}
	 * @post.condition la línea con identificador id ha sido eliminada de la red
	 * @param id identificador de la línea
	 * @throws IllegalStateExcepcion si {@code !hayLinea(id)}
	 * @throws IllegalStateException si {@code lineas.length < 3}
	 */
	public void eliminarLinea(int id) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Devuelve todas las líneas que hay en la red de autobuses.
	 * 
	 * @return un array de Linea
	 */
	public Linea[] getLineas() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve si hay no alguna línea con alguna parada dentro de un área circular dados una coordenada central
	 * y un radio.
	 * 
	 * @param coordenada coordenada central del área
	 * @param radio radio del área expresado en metros
	 * @return true en caso de haber alguna línea con alguna parada dentro del área. False en caso contrario.
	 * @throws IllegalArgumentException si {@code coordenada == null}
	 */
	public boolean hayLineasEnRadio(Coordenada coordenada, double radio) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Devuelve las líneas que tienen alguna parada dentro del área circular dada mediante una coordenada central
	 * y un radio.
	 * 
	 * @pre.condition {@code hayLineaEnRadio(coordenada, radio)}
	 * @pre.condition {@code coordenada != null}
	 * @param coordenada coordenada central del área circular
	 * @param radio radio en metros del área circular
	 * @return un array de Linea con las líneas que tienen parada dentro del área
	 * @throws IllegalArgumentException si {@code coordenada == null}
	 * @throws IllegalStateException si {@code !hayLineasEnRadio(coordenada, radio)}
	 */
	public Linea[] getLineasEnRadio(Coordenada coordenada, double radio) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Devuelve si tiene o no alguna correspondencia con otra línea la línea con el identificador id
	 * 
	 * @pre.condition {@code hayLinea(id)}
	 * @param id identificador de la línea de la cual se quiere saber si tiene alguna correspondencia con otra línea
	 * @return true si la línea tiene alguna correspondencia. False en caso contrario
	 * @throws IllegalStateException si {@code !hayLinea(id)}
	 */
	public boolean tieneAlgunaCorrespondencia(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Devuelve las líneas con las que tiene correspondencia la línea identificada mediante el argumento.
	 * Se dice que una línea tiene correspondencia con otra si alguna de sus paradas distan menos de 200 metros.
	 * 
	 * @pre.condition {@code hayLinea(id)}
	 * @pre.condition {@code tieneAlgunaCorrespondencia(id)}
	 * @param id identificador del la línea de la que se quieren obtener sus correspondencias
	 * @return las líneas con las que tiene correspondencia
	 * @throws IllegalStateException si {@code !hayLinea(id)}
	 * @throws IllegalSteteException si {@code !tieneAlgunaCorrespondencia(id)}
	 */
	public Linea[] getCorrespondencias(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve si hay o no posibilidad de transborod directo entre las líneas A y B
	 * Se dice que una línea tiene transbordo directo con otra si al menos tienen una parada en común
	 * 
	 * @pre.condition {@code hayLinea(idLineaA) && hayLinea(idLineaB)}
	 * @param idLineaA identificador de una línea
	 * @param idLineaB idenfificador de la otra línea
	 * @return true en caso de haber transbordo directo. False en caso contrario
	 * @throws IllegalStateException si {@code !hayLinea(idLineaA) || !hayLinea(idLineaB)}
	 */
	public boolean hayTransbordoDirecto(int idLineaA, int idLineaB) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Devuelve una lista de coordenadas que representan las paradas de la lineaA que
	 * tienen transbordo directo con la lineaB.
	 * 
	 * @pre.condition {@code hayLinea(idLineaA) && hayLinea(idLineaB)}
	 * @pre.condition {@code hayTransbordoDirecto(idLineaA, idLineaB)}
	 * @param idLineaA identificador de una línea
	 * @param idLineaB idenfiticador de la otra línea
	 * @return las coordenadas de las paradas que tienen transbordo directo entre la lineaA y la lineaB
	 * @throws IllegalStateException si {@code !hayLinea(idLineaA) || !hayLinea(idLineaB)}
	 * @throws IllegalStateException si {@code !hayTransbordoDirecto(idLineaA, idLineaB)}
	 */
	public Coordenada[] getParadasConTransbordo(int idLineaA, int idLineaB) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Devuelve la distancia en metros entre la parada idParadaLineaA de la lineaA, y la parada
	 * idParadaLineaB de la lineaB.
	 * 
	 * @pre.condition {@code hayLinea(idLineaA) && hayLinea(idLineaB)}
	 * @pre.condition {@code getLinea(idLineaA).coordenadas.size() >= posParadaA}
	 * @pre.condition {@code getLinea(idLineaB).coordenadas.size() >= posParadaB}
	 * @param idLineaA identificador de una línea
	 * @param posParadaA posición de la parada en la ruta de la líneaA
	 * @param idLineaB identificador de otra línea
	 * @param posParadaB posición de la parada en la ruta de la líneaB
	 * @return distancia en metros entre la paradaA y la paradaB
	 * @throws IllegalStateException si {@code !hayLinea(idLineaA) || !hayLinea(idLineaB)}
	 * @throws IllegalStateException si {@code getLinea(idLineaA).coordenadas.size() < posParadaA}
	 * @throws IllegalStateException si {@code getLinea(idLineaB).coordenadas.size() < posParadaB}
	 */
	public double getDistanciaParadas(int idLineaA, int posParadaA, int idLineaB, int posParadaB) {
		// TODO Auto-generated method stub
		return -1;
	}

}
