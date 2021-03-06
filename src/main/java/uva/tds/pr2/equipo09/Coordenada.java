package uva.tds.pr2.equipo09;

/**
 * Representación de una coordenada GPS en formato GD
 * @author ginquin
 * @author davidgo
 *
 */
public class Coordenada {
	static final double RADIO_TIERRA=6371.0;
	private double latitud;
	private double longitud;
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
		this.latitud=lat;
		this.longitud=lon;
	}

	public double getLatitud() {
		return this.latitud;
	}

	public double getLongitud() {
		return this.longitud;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 32 * hash + new Double(this.getLatitud()).hashCode();
		hash = hash + new Double(this.getLongitud()).hashCode();
		return hash;
	
	}

	@Override
	public boolean equals(Object otro) {
		if (this == otro) {
			return true;
		}
		if (otro instanceof Coordenada) {
			Coordenada tmpOtro = (Coordenada)otro;
			if (this.latitud != tmpOtro.getLatitud()) {
				return false;
			} else {
				return this.longitud == tmpOtro.getLongitud();
			}
		}
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
		if(otra==null){
			throw new IllegalArgumentException("coordenada nula.");
		}
		double dLong= Math.toRadians(otra.getLongitud()-this.getLongitud());
		double dLat= Math.toRadians(otra.getLatitud() -this.getLatitud());
		double a = (Math.sin(dLat/2)* Math.sin(dLat/2))+Math.cos(this.getLatitud())*Math.cos(otra.getLatitud())*
					(Math.sin(dLong/2)* Math.sin(dLong/2));
		double c=	2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return (double)Math.round(RADIO_TIERRA*c*1000d)/1000d;
	}

}
