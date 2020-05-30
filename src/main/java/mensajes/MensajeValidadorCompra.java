package mensajes;

public class MensajeValidadorCompra extends Mensaje {
	public MensajeValidadorCompra(String texto) {
		super(texto);
		this.asuntoMensaje = "Resultado validador de compra";
	}
}
