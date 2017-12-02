package uva.tds.pr2.equipo09;

/**
 * Representación de una coordenada GPS en formato GD
 * @author ginquin
 * @author davidgo
 *
 */
public class Coordenada {

	/**
	 * Crea un objeto que representa una coordenada en formato GD. 
	 * Las latitudes Norte son positivas, y las latitudes Sur son negativas.
	 * Las longitudes Este son positivas, y las longitudes Oeste son negativas.
	 * @param lat valor para la latitud
	 * @param lon valor para la longitud
	 * @post.condition {@code lat = this.getLatitud() }
	 * @post.condition {@code lon = this.getLongitud() }
	 */
	public Coordenada(double lat, double lon) {
		// TODO Auto-generated constructor stub
	}

	public double getLatitud() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getLongitud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object otro) {
		//TODO 
		return false;
	}
	
	/**
	 * Devuelve la distancia entre las coordenadas this y otra.
	 * @param otra
	 * @return distancia la distancia entre las coordenadas this y otra
	 * @pre.condition {@code otra != null}
	 * @post.condition {@code distancia >= 0}
	 * @throws IllegalArgumentException cuando no se cumple la precondición
	 */
	public double distanciaA(Coordenada otra) {
		// TODO Auto-generated method stub
		return -1;
	}

}
