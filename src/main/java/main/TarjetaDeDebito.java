package main;

import java.util.Date;

public class TarjetaDeDebito extends MedioDePago{
	
	int numero;
	int codigoSeguridad;
	Date fechaExpiracion;
	String duenioNombre;
	long duenioNroIdentificacion;
	long duenoTipoIdentificacion;
	
	public TarjetaDeDebito(int numero, int codigoSeguridad, Date fechaExpiracion, String duenioNombre, long duenioNroIdentificacion, long duenoTipoIdentificacion) {
		this.numero = numero;
		this.codigoSeguridad = codigoSeguridad;
		this.fechaExpiracion = fechaExpiracion;
		this.duenioNombre = duenioNombre;
		this.duenioNroIdentificacion = duenioNroIdentificacion;
		this.duenoTipoIdentificacion = duenoTipoIdentificacion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(int codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getDuenioNombre() {
		return duenioNombre;
	}

	public void setDuenioNombre(String duenioNombre) {
		this.duenioNombre = duenioNombre;
	}

	public long getDuenioNroIdentificacion() {
		return duenioNroIdentificacion;
	}

	public void setDuenioNroIdentificacion(long duenioNroIdentificacion) {
		this.duenioNroIdentificacion = duenioNroIdentificacion;
	}

	public long getDuenoTipoIdentificacion() {
		return duenoTipoIdentificacion;
	}

	public void setDuenoTipoIdentificacion(long duenoTipoIdentificacion) {
		this.duenoTipoIdentificacion = duenoTipoIdentificacion;
	}
	
	

}
