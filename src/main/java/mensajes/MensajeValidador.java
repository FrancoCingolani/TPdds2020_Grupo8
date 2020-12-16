package mensajes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("validadorCompra")
public class MensajeValidador extends Mensaje {
	public MensajeValidador(String texto) {
		super(texto);
		this.asuntoMensaje = "Resultado validador";
	}
	public MensajeValidador() {}
	public MensajeValidador (String textoMensaje, String asuntoMensaje , Boolean leido) {
		super(textoMensaje, leido);
		this.asuntoMensaje = asuntoMensaje;
	}
}
