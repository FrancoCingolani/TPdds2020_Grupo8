package categoriasEntidadJuridica;

public class Peque�a implements ICategoria {
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}
