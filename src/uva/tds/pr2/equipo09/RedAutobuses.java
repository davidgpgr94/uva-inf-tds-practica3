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
	 * @param id identificador de la línea
	 * @return la línea con el identificador. Null si no existe la línea con el identificador pasado
	 * @throws IllegalArgumentException si {@code id < 1}
	 */

	public Linea getLinea(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
