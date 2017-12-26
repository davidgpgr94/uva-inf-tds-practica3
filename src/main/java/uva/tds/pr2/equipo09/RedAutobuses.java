package uva.tds.pr2.equipo09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Representación de una red de transporte que contiene diferentes líneas de autobuses
 * @author ginquin
 * @author davidgo
 *
 */
public class RedAutobuses {

	
	protected HashMap<Integer, Linea> lineas;
	
	/**
	 * Crea una instancia de RedAutobuses con las líneas pasadas como parámetro.
	 * 
	 * @pre.condition {@code lineas.length >= 2}
	 * @param lineas las líneas de autobús que forman la red de autobuses.
	 * @throws IllegalArgumentException si {@code lineas.length < 2}
	 */
	public RedAutobuses(Linea[] lineas) {
		if (lineas.length < 2) {
			throw new IllegalArgumentException("La red debe tener al menos dos lineas");
		}
		
		this.lineas = new HashMap<>();
		for (Linea linea : lineas) {
			this.lineas.put(linea.getId(), linea);
		}
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
		if (id <= 0) {
			throw new IllegalArgumentException("El id es invalido");
		}
		if (!hayLinea(id)) {
			throw new IllegalStateException("La linea no existe");
		}
		return lineas.get(id);
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
		if (nueva == null) {
			throw new IllegalArgumentException("La nueva linea no puede ser null");
		}
		if (hayLinea(nueva.getId())) {
			throw new IllegalStateException("Ya existe una linea en el sistema con el mismo identificador");
		}
		lineas.put(nueva.getId(), nueva);
	}

	/**
	 * Devuelve true en caso de que la red contenga una línea con el identificador del parámetro. 
	 * False en caso contrario.
	 * 
	 * @pre.condition {@code id > 0}
	 * @param id identificador de la línea.
	 * @return true en caso de que haya una línea en la red con el identificador id. False en caso contrario
	 * @throws IllegalArgumentException si {@code id < 1}
	 */
	public boolean hayLinea(int id) {
		if (id < 1) {
			throw new IllegalArgumentException("El identificador ha de ser mayor que cero");
		}
		return lineas.containsKey(id);
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
		if (!hayLinea(id)) {
			throw new IllegalStateException("En el sistema no existe la linea que se desea eliminar");
		}
		if (lineas.size() < 3) {
			throw new IllegalStateException("El sistema no se puede quedar con menos de dos lineas tras el borrado");
		}
		lineas.remove(id);
	}

	/**
	 * Devuelve todas las líneas que hay en la red de autobuses.
	 * 
	 * @return un array de Linea
	 */
	public Linea[] getLineas() {
		return lineas.values().toArray(new Linea[0]);
	}

	/**
	 * Devuelve si hay o no alguna línea con alguna parada dentro de un área circular dados una coordenada central
	 * y Exceptionun radio.
	 * 
	 * @pre.condition {@code coordenada != null}
	 * @param coordenada coordenada central del área
	 * @param radio radio del área expresado en metros
	 * @return true en caso de haber alguna línea con alguna parada dentro del área. False en caso contrario.
	 * @throws IllegalArgumentException si {@code coordenada == null}
	 */
	public boolean hayLineasEnRadio(Coordenada coordenada, double radio) {
		if (coordenada == null) {
			throw new IllegalArgumentException("La coordenada no puede ser nula");
		}
		for (Linea linea : lineas.values()) {
			for (Coordenada parada : linea.getParadas()) {
				if (coordenada.distanciaA(parada) <= radio/1000) {
					return true;
				}
			}
		}
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
		if (coordenada == null) {
			throw new IllegalArgumentException("La coordenada no puede ser nula");
		}
		if (!hayLineasEnRadio(coordenada, radio)) {
			throw new IllegalStateException("No hay lineas en el sistema dentro del radio dado");
		}
		ArrayList<Linea> solucion = new ArrayList<>();
		for (Linea linea : lineas.values()) {
			for (Coordenada parada : linea.getParadas()) {
				if (coordenada.distanciaA(parada) <= radio/1000) {
					solucion.add(linea);
					break;
				}
			}
		}
		return solucion.toArray(new Linea[0]);
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
		if (!hayLinea(id)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada");
		}
		for (Coordenada parada : lineas.get(id).getParadas()) {
			for (Linea linea : lineas.values()) {
				if (!linea.equals(lineas.get(id))) {
					if(linea.hayParadasCercanas(parada)) {
						return true;
					}					
				}
			}			
		}
		return false;
	}

	/**
	 * Devuelve las líneas con las que tiene correspondencia la línea identificada mediante el argumento.
	 * Se dice que una línea tiene correspondencia con otra si alguna de sus paradas distan menos de 200 metros.
	 * 
	 * @pre.condition {@code hayLinea(id)}
	 * @pre.condition {@code tieneAlgunaCorrespondencia(id)}
	 * @param id identificador de la línea de la que se quieren obtener sus correspondencias
	 * @return las líneas con las que tiene correspondencia
	 * @throws IllegalStateException si {@code !hayLinea(id)}
	 * @throws IllegalStateException si {@code !tieneAlgunaCorrespondencia(id)}
	 */
	public Linea[] getCorrespondencias(int id) {
		if (!hayLinea(id)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada");
		}
		if (!tieneAlgunaCorrespondencia(id)) {
			throw new IllegalStateException("La linea indicada no tiene correspondencia con alguna otra linea");
		}
		HashSet<Linea> solucion = new HashSet<>();
		for (Coordenada parada : lineas.get(id).getParadas()) {
			for (Linea linea : lineas.values()) {
				if (!linea.equals(lineas.get(id))) {
					if (linea.hayParadasCercanas(parada)) {
						
						solucion.add(linea);
					}					
				}
			}
		}
		return solucion.toArray(new Linea[0]);
	}

	/**
	 * Devuelve las paradas que tienen correspondencia con la linea indicada mediante el argumento.
	 * 
	 * @pre.condition {@code hayLinea(id)}
	 * @pre.condition {@code tieneAlgunaCorrespondencia(id)}
	 * @param id identificador de la línea de la que se quiere obtener las paradas con correspondencia con alguna otra línea
	 * @return las paradas con las que tiene correspondencia
	 * @throws IllegalStateException si {@code !hayLinea(id)}
	 * @throws IllegalStateException si {@code !tieneAlgunaCorrespondencia(id)}
	 */
	public Coordenada[] getParadasCorrespondencia(int id) {
		if (!hayLinea(id)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada");
		}
		if (!tieneAlgunaCorrespondencia(id)) {
			throw new IllegalStateException("La linea indicada no tiene correspondencia con alguna otra linea");
		}
		
		ArrayList<Coordenada> solucion = new ArrayList<>();
		for (Coordenada parada : lineas.get(id).getParadas()) {
			for (Linea linea : lineas.values()) {
				if (!linea.equals(lineas.get(id))) {
					if (linea.hayParadasCercanas(parada)) {
						solucion.add(parada);
					}
				}
			}
		}
		return solucion.toArray(new Coordenada[0]);
	}
	
	/**
	 * Devuelve si hay o no posibilidad de transborod directo entre las líneas A y B
	 * Se dice que una línea tiene transbordo directo con otra si al menos tienen una parada en común
	 * 
	 * @pre.condition {@code hayLinea(idLineaA) && hayLinea(idLineaB)}
	 * @pre.condition {@code idLineaA != idLineaB}
	 * @param idLineaA identificador de una línea
	 * @param idLineaB idenfificador de la otra línea
	 * @return true en caso de haber transbordo directo. False en caso contrario
	 * @throws IllegalStateException si {@code !hayLinea(idLineaA) || !hayLinea(idLineaB)}
	 * @throws IllegalArgumentException si {@code idLineaA == idLineaB}
	 */
	public boolean hayTransbordoDirecto(int idLineaA, int idLineaB) {
		if (!hayLinea(idLineaA)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada en el primer argumento");
		}
		if (!hayLinea(idLineaB)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada en el segundo argumento");
		}
		if (idLineaA == idLineaB) {
			throw new IllegalArgumentException("Las líneas indicadas por los parámetros son las mismas");
		}
		for (Coordenada paradaA : lineas.get(idLineaA).getParadas()) {
			for (Coordenada paradaB : lineas.get(idLineaB).getParadas()){
				if (paradaA.equals(paradaB)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Devuelve una lista de coordenadas que representan las paradas de la lineaA que
	 * tienen transbordo directo con la lineaB.
	 * 
	 * @pre.condition {@code hayLinea(idLineaA) && hayLinea(idLineaB)}
	 * @pre.condition {@code idLineaA != idLineaB}
	 * @pre.condition {@code hayTransbordoDirecto(idLineaA, idLineaB)}
	 * @param idLineaA identificador de una línea
	 * @param idLineaB idenfiticador de la otra línea
	 * @return las coordenadas de las paradas que tienen transbordo directo entre la lineaA y la lineaB
	 * @throws IllegalStateException si {@code !hayLinea(idLineaA) || !hayLinea(idLineaB)}
	 * @throws IllegalArgumentException si {@code idLineaA == idLineaB}
	 * @throws IllegalStateException si {@code !hayTransbordoDirecto(idLineaA, idLineaB)}
	 */
	public Coordenada[] getParadasConTransbordo(int idLineaA, int idLineaB) {
		if (!hayLinea(idLineaA)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada en el primer argumento");
		}
		if (!hayLinea(idLineaB)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada en el segundo argumento");
		}
		if (idLineaA == idLineaB) {
			throw new IllegalArgumentException("Las líneas indicadas por los parámetros son las mismas");
		}
		if (!hayTransbordoDirecto(idLineaA, idLineaB)) {
			throw new IllegalStateException("No hay posibilidad de transbordo directo entre las lineas A y B");
		}
		ArrayList<Coordenada> solucion = new ArrayList<>();
		for (Coordenada paradaA : lineas.get(idLineaA).getParadas()) {
			for (Coordenada paradaB : lineas.get(idLineaB).getParadas()) {
				if (paradaA.equals(paradaB)) {
					solucion.add(paradaA);
				}
			}
		}
		return solucion.toArray(new Coordenada[0]);
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
		if (!hayLinea(idLineaA)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada en el primer argumento");
		}
		if (!hayLinea(idLineaB)) {
			throw new IllegalStateException("No existe una linea en el sistema con la identificacion dada en el segundo argumento");
		}
		if (posParadaA < 0) {
			throw new IllegalStateException("Identificador de la parada de la linea A no valido (< 0)");
		}
		if (posParadaA >= getLinea(idLineaA).getParadas().length) {
			throw new IllegalStateException("Identificador de la parada de la linea A no valido (> numero de paradas de linea A)");
		}
		if (posParadaB < 0) {
			throw new IllegalStateException("Identificador de la parada de la linea B no valido (< 0)");
		}
		if (posParadaB >= getLinea(idLineaB).getParadas().length) {
			throw new IllegalStateException("Identificador de la parada de la linea B no valido (> numero de paradas de linea B)");
		}
		Linea a, b;
		a = lineas.get(idLineaA);
		b = lineas.get(idLineaB);
		return a.getParada(posParadaA).distanciaA(b.getParada(posParadaB)) * 1000;
	}

}
