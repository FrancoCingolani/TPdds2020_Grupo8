package main;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import enumeradores.*;

@Entity
@Table(name = "entidadesjuridicas")
@PrimaryKeyJoinColumn(name = "id_entidad_juridica")
public class EntidadJuridica extends Organizacion{
	
	String razonSocial;
	String nombreFicticio;
	int codigoInscripcionIGJ;
	String CUIT;
		
	//Categoria 
	
	public EntidadJuridica () {
	}
	
	// Constructor; como el codigoInscripcionIGJ es opcional, creo 2 constructores diferentes (overloading). Ver si conviene realizarlo con el patrón builder
	public EntidadJuridica (String razonSocial, String nombreFicticio, String CUIT, String direccionPostal,CityML Ciudad, int personal, Actividad actividad, TipoEntidadJuridica tipo, int codigoInscripcionIGJ, int periodo) {
		this.razonSocial = razonSocial;
		this.nombreFicticio = nombreFicticio;
		this.CUIT = CUIT;
		this.direccionPostal = direccionPostal;
		this.id_ciudad = Ciudad;
		this.personal = personal;
		this.actividad = actividad;
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
		this.tipo = tipo;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.operacionesIngresoEntidad = new ArrayList<OperacionIngreso>();
		this.ventasAnuales = 0;
		CategorizadorEntidad.categorizar(this);
		this.periodoVinculacion = periodo;
	}
	
	public EntidadJuridica (String razonSocial, String nombreFicticio, String CUIT, String direccionPostal, CityML Ciudad,int personal, Actividad actividad, TipoEntidadJuridica tipo, int periodo) {
		this (razonSocial, nombreFicticio, CUIT, direccionPostal,Ciudad, personal, actividad, tipo, 0, periodo);
	}
	
	// Para cambiar una entidad juridica a una base
	public EntidadJuridica (EntidadBase viejaEntidad, String razonSocial, TipoEntidadJuridica tipo, String CUIT, int codigoInscripcionIGJ, int periodo) {
		this.razonSocial = razonSocial;
		this.nombreFicticio = viejaEntidad.nombreFicticio;
		this.CUIT = CUIT;
		this.direccionPostal = viejaEntidad.direccionPostal;
		this.id_ciudad = viejaEntidad.id_ciudad;
		this.personal = viejaEntidad.personal;
		this.actividad = viejaEntidad.actividad;
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
		this.tipo = tipo;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.operacionesIngresoEntidad = new ArrayList<OperacionIngreso>();
		this.ventasAnuales = viejaEntidad.ventasAnuales;
		CategorizadorEntidad.categorizar(this);
		this.periodoVinculacion = periodo;
	}
	
	public EntidadJuridica (EntidadBase viejaEntidad, String razonSocial, TipoEntidadJuridica tipo, String CUIT, int periodo) {
		this (viejaEntidad, razonSocial, tipo, CUIT, 0, periodo);
	}
	
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNombreFicticio() {
		return nombreFicticio;
	}
	public void setNombreFicticio(String nombreFicticio) {
		this.nombreFicticio = nombreFicticio;
	}
	public int getcodigoInscripcionIGJ() {
		return codigoInscripcionIGJ;
	}
	public void setcodigoInscripcionIGJ(int codigoInscripcionIGJ) {
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
	}
	
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String CUIT) {
		this.CUIT = CUIT;
	}

}
