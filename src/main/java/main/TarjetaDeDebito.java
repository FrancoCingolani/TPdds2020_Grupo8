package main;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tarjetadedebito")
public class TarjetaDeDebito extends MedioDePago{
	
	String numero;
	String codigoSeguridad;
	Date fechaExpiracion;
	String duenioNombre;
	String duenioNroIdentificacion;
	String duenoTipoIdentificacion;
	
	public TarjetaDeDebito() {
	}
	
	public TarjetaDeDebito(String numero, String codigoSeguridad, Date fechaExpiracion, String duenioNombre, String duenioNroIdentificacion, String duenoTipoIdentificacion) {
		this.numero = numero;
		this.codigoSeguridad = codigoSeguridad;
		this.fechaExpiracion = fechaExpiracion;
		this.duenioNombre = duenioNombre;
		this.duenioNroIdentificacion = duenioNroIdentificacion;
		this.duenoTipoIdentificacion = duenoTipoIdentificacion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
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

	public String getDuenioNroIdentificacion() {
		return duenioNroIdentificacion;
	}

	public void setDuenioNroIdentificacion(String duenioNroIdentificacion) {
		this.duenioNroIdentificacion = duenioNroIdentificacion;
	}

	public String getDuenoTipoIdentificacion() {
		return duenoTipoIdentificacion;
	}

	public void setDuenoTipoIdentificacion(String duenoTipoIdentificacion) {
		this.duenoTipoIdentificacion = duenoTipoIdentificacion;
	}
	
	

}
