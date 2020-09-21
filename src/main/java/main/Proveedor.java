package main;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name="Proveedor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Proveedor {
	
	@Id @GeneratedValue
	int id_proveedor;
	String direccionPostal;
	CityML ciudad;

	public Proveedor(){}	
	
	public Proveedor(String direccionPostal, CityML Ciudad) {
		this.direccionPostal = direccionPostal;
		this.ciudad = Ciudad;
	}
	
	public String getdireccionPostal() {
		return direccionPostal;
	}
	public void setdireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}
	

}
