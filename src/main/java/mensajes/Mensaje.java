package mensajes;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.Usuario;

@Entity
@Table(name = "Mensajes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Mensaje {
	
	@Id @GeneratedValue
	int id_mensaje;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	Usuario id_usuario;
	
	String textoMensaje;
	String asuntoMensaje;
	Boolean leido;
	
	public Mensaje() {
		}
	
	public Mensaje(String texto) {
		this.textoMensaje = texto;
		this.leido = false;
	}
	
	public Mensaje(String texto, Boolean leido) {
		this.textoMensaje = texto;
		this.leido = leido;
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
	
	public Boolean getLeido() {
		return leido;
	}
}
