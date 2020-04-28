package categoriasEntidadJuridica;

public class Categoria {
	private ICategoria categoria;
	
	public Categoria(ICategoria categoria) {
		this.categoria = categoria;
	}
	
	public String getDescripcionCategoria() {
		return this.categoria.getDescripcionCategoria();
	}
}
