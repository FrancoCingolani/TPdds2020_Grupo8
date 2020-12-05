package mensajes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("validadorCompra")
public class MensajeValidadorCompra extends Mensaje {
	public MensajeValidadorCompra(String texto) {
		super(texto);
		this.asuntoMensaje = "Resultado validador de compra";
	}
	public MensajeValidadorCompra() {}
	public MensajeValidadorCompra (String textoMensaje, String asuntoMensaje , Boolean leido) {
		super(textoMensaje, leido);
		this.asuntoMensaje = asuntoMensaje;
	}
}
