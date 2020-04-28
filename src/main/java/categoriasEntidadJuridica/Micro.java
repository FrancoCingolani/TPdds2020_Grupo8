package categoriasEntidadJuridica;

public class Micro implements ICategoria {
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}
