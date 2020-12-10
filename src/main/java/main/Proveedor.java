package main;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Proveedor")
@Table(name = "proveedores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
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

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public CityML getCiudad() {
		return ciudad;
	}

	public void setCiudad(CityML ciudad) {
		this.ciudad = ciudad;
	}
	

}
