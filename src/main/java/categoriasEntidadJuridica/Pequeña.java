package categoriasEntidadJuridica;

public class Pequeña implements ICategoria {
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}
