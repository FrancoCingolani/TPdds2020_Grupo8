package main;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import enumeradores.Actividad;


@Entity
@Table(name = "EntidadesJuridicas")
@PrimaryKeyJoinColumn(name = "id_entidad_base")
public class EntidadBase extends Organizacion{
	String nombreFicticio;
	String descripcion;
	
	@ManyToOne
	EntidadJuridica perteneceA;
	
	public EntidadBase(String nombreFicticio, String descripcion, int personal, String direccionPostal, Actividad actividad, int periodo) {
		this (nombreFicticio, descripcion, personal, direccionPostal, actividad, null, periodo);
	}
	
	public EntidadBase(String nombreFicticio, String descripcion, int personal, String direccionPostal, Actividad actividad, EntidadJuridica perteneceA, int periodo) {
		this.nombreFicticio = nombreFicticio;
		this.descripcion = descripcion;
		this.personal = personal;
		this.direccionPostal = direccionPostal;
		this.actividad = actividad;
		this.perteneceA = perteneceA;
		this.categoria = null;
		this.tipo = null;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.operacionesIngresoEntidad = new ArrayList<OperacionIngreso>();
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
