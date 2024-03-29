package categoriasEntidadJuridica;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("medianaTramo1")
public class MedianaTramo1 implements ICategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_categoria;
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}
