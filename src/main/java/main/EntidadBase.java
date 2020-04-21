package main;

public class EntidadBase {
	String nombreFicticio ;
	String descripcion;
	EntidadJuridica perteneceA;
	
	public String getNombreFicticio() {
		return nombreFicticio;
	}
	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public EntidadJuridica getperteneceA() {
		return perteneceA;
	}
	public void setperteneceA(EntidadJuridica perteneceA) {
		this.perteneceA = perteneceA;
	}
	
}
