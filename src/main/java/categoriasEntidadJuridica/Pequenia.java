package categoriasEntidadJuridica;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("pequenia")
public class Pequenia implements ICategoria {
	
	@Id @GeneratedValue
	int id_categoria;
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}
