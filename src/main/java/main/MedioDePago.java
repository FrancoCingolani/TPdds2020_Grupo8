package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "mediodepago")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MedioDePago {
	
	@Id
	int id_medio_de_pago;

}
