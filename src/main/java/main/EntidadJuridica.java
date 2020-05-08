package main;

import java.util.ArrayList;

import enumeradores.*;

public class EntidadJuridica extends Organizacion{
	
	String razonSocial;
	String nombreFicticio;
	int codigoInscripcionIGJ;
	String CUIT;
		
	//Categoria 
	
	// Constructor; como el codigoInscripcionIGJ es opcional, creo 2 constructores diferentes (overloading). Ver si conviene realizarlo con el patrón builder
	public EntidadJuridica (String razonSocial, String nombreFicticio, String CUIT, String direccionPostal, int personal, Actividad actividad, TipoEntidadJuridica tipo, int codigoInscripcionIGJ) {
		this.razonSocial = razonSocial;
		this.nombreFicticio = nombreFicticio;
		this.CUIT = CUIT;
		this.direccionPostal = direccionPostal;
		this.personal = personal;
		this.actividad = actividad;
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
		this.tipo = tipo;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.ventasAnuales = 0;
		CategorizadorEntidad.categorizar(this);
	}
	
	public EntidadJuridica (String razonSocial, String nombreFicticio, String CUIT, String direccionPostal, int personal, Actividad actividad, TipoEntidadJuridica tipo) {
		this (razonSocial, nombreFicticio, CUIT, direccionPostal, personal, actividad, tipo, 0);
	}
	
	// Para cambiar una entidad jurídica a una base
	public EntidadJuridica (EntidadBase viejaEntidad, String razonSocial, TipoEntidadJuridica tipo, String CUIT, int codigoInscripcionIGJ) {
		this.razonSocial = razonSocial;
		this.nombreFicticio = viejaEntidad.nombreFicticio;
		this.CUIT = CUIT;
		this.direccionPostal = viejaEntidad.direccionPostal;
		this.personal = viejaEntidad.personal;
		this.actividad = viejaEntidad.actividad;
		this.codigoInscripcionIGJ = codigoInscripcionIGJ;
		this.tipo = tipo;
		this.operacionesEgresoEntidad = new ArrayList<OperacionEgreso>();
		this.ventasAnuales = viejaEntidad.ventasAnuales;
		CategorizadorEntidad.categorizar(this);
	}
	
	public EntidadJuridica (EntidadBase viejaEntidad, String razonSocial, TipoEntidadJuridica tipo, String CUIT) {
		this (viejaEntidad, razonSocial, tipo, CUIT, 0);
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
