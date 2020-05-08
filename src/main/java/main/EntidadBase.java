package main;

import java.util.ArrayList;

import enumeradores.Actividad;

public class EntidadBase extends Organizacion{
	String nombreFicticio;
	String descripcion;
	EntidadJuridica perteneceA;
	
	public EntidadBase(String nombreFicticio, String descripcion, int personal, String direccionPostal, Actividad actividad) {
		this (nombreFicticio, descripcion, personal, direccionPostal, actividad, null);
	}
	
	public EntidadBase(String nombreFicticio, String descripcion, int personal, String direccionPostal, Actividad actividad, EntidadJuridica perteneceA) {
		this.nombreFicticio = nombreFicticio;
		this.descripcion = descripcion;
		this.personal = personal;
		this.direccionPostal = direccionPostal;
		this.actividad = actividad;
		this.perteneceA = perteneceA;
		this.categoria = null;
		this.tipo = null;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.ventasAnuales = 0;
	}
	
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
