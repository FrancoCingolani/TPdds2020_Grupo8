package main;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("juridico")
public class ProveedorJuridico extends Proveedor{
	
	String razonSocial;
	String cuit;
	
	
	public ProveedorJuridico() {
	}
	public ProveedorJuridico(String direccionPostal,CityML Ciudad, String razonSocial, String cuit) {
		super(direccionPostal, Ciudad);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
