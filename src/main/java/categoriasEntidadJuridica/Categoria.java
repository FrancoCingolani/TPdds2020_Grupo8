package categoriasEntidadJuridica;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="Categorias")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Categoria {
	
	@Id @GeneratedValue
	int id_categoria;
	
	private ICategoria categoria;		
	
	public Categoria(ICategoria categoria) {
		this.categoria = categoria;
	}
	
	public String getDescripcionCategoria() {
		return this.categoria.getDescripcionCategoria();
	}
}
