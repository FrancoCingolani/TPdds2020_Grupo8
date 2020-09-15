package categoriasEntidadJuridica;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("osc")
public class OSC implements ICategoria {
	
	@Id @GeneratedValue
	int id_categoria;
	public String getDescripcionCategoria() {
		return this.getClass().getSimpleName();
	}
}