package categoriasEntidadJuridica;

public class OSC implements ICategoria {
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}


//Deprecado, agregado el sufijo "Old" para indicar que no se debe utilizar. Queda de respaldo
/*public class OscOld {
	String nombre;
	long numero;
	String provincia;
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getprovincia() {
		return provincia;
	}
	public void setprovincia(String provincia) {
		this.provincia = provincia;
	}
	public long getnumero() {
		return numero;
	}
	public void setnumero(long numero) {
		this.numero = numero;
	}
}
*/