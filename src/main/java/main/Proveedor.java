package main;

public class Proveedor {
	
	String nombre;
	String apellido;
	String razonSocial;
	long dni;
	
	
	public Proveedor(String nombre, String apellido, String razonSocial, long dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.razonSocial = razonSocial;
		this.dni = dni;
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
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	
	

}
