package main;

import java.io.FileNotFoundException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.io.IOException;

import exceptions.CriterioPadreException;

@Entity
public class Clasificacion {
	
	@Id @GeneratedValue
	int id_clasificacion;
	String descripcion;
	Criterio criterio;
	@OneToOne
	Clasificacion clasificacionPadre;
	
	public Clasificacion(String descripcion, Criterio criterio, Clasificacion padre ) throws CriterioPadreException, IOException{
		if((padre != null) && (padre.getCriterio() == criterio)){//Si va a tener una clasificación padre y tienen el mismo criterio
			this.descripcion = descripcion;
			this.criterio = criterio;
			this.clasificacionPadre = padre;
		}else if((padre != null) && (padre.getCriterio() != criterio)){//Si va a tener una clasificación padre y no tienen el mismo criterio
			throw new CriterioPadreException();
		}
		
	}
	
	public Clasificacion(String descripcion, Criterio criterio){
		this.descripcion = descripcion;
		this.criterio = criterio;
		this.clasificacionPadre = null;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Criterio getCriterio() {
		return criterio;
	}
	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}
	public Clasificacion getclasificacionPadre() {
		return clasificacionPadre;
	}

	public void setclasificacionPadre(Clasificacion clasificacionPadre) {
		this.clasificacionPadre = clasificacionPadre;
	}
	
	//clasificar() :: void

}
