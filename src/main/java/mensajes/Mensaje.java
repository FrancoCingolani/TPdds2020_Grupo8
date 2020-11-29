package mensajes;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Mensajes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Mensaje {
	
	@Id @GeneratedValue
	int id_mensaje;
	
	String textoMensaje;
	String asuntoMensaje;
	Boolean leido;
	public Mensaje(){
	}
	
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
	public void setTextoMensaje(String txtMensaje) {
		this.textoMensaje = txtMensaje;
	}
	public void setAsuntoMensaje(String asuntoMensaje) {
		this.asuntoMensaje = asuntoMensaje;
	}
	public void setLeido(Boolean leido) {
		this.leido = leido;
	}
}
