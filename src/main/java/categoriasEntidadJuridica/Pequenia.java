package categoriasEntidadJuridica;

public class Pequenia implements ICategoria {
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}
