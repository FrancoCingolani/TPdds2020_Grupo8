package categoriasEntidadJuridica;

public class OSC implements ICategoria {
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}