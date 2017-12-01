package uva.tds.pr2.equipo09;

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
	 */
	public void eliminarLinea(int id) {
		// TODO Auto-generated method stub
		
	}

}
