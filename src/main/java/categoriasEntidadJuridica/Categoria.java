package categoriasEntidadJuridica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity(name="Categorias")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_categoria;
	
	@Transient
	private ICategoria categoria;		
	
	public Categoria() {
	}
	
	public Categoria(ICategoria categoria) {
		this.categoria = categoria;
	}
	
	public String getDescripcionCategoria() {
		return this.categoria.getDescripcionCategoria();
	}
}
