package main;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Proveedor")
@Table(name = "Proveedores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Proveedor {
	
	@Id @GeneratedValue
	int id_proveedor;
	String direccionPostal;
	@ManyToOne
	@JoinColumn(name = "id_ciudad")
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
