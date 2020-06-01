package mensajes;

public abstract class Mensaje {
	String textoMensaje;
	String asuntoMensaje;
	Boolean leido;
	
	public Mensaje(String texto) {
		this.textoMensaje = texto;
		this.leido = false;
	}
	
	public String getTextoMensaje() {
		return this.textoMensaje;
	}
	
	public String getAsuntoMensaje() {
		return this.asuntoMensaje;
	}
	
	public void leerMensaje() {
		this.leido = true;
	}
	
	public Boolean mensajeFueLeido() {
		return this.leido;
	}
}
