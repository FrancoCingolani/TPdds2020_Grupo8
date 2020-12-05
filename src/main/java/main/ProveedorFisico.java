package main;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("fisico")
public class ProveedorFisico extends Proveedor {
	String nombre;
	String apellido;
	String dni;
	String cuil;
	
	
	public ProveedorFisico() {
	}
	
	public ProveedorFisico(String direccionPostal, CityML Ciudad, String nombre, String apellido, String dni, String cuil) {
		super(direccionPostal, Ciudad);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuil = cuil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

}
