package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import exceptions.CriterioPadreException;

public class Clasificacion {
	String descripcion;
	Criterio criterio;
	Clasificacion clasificacionPadre;
	
	public Clasificacion(String descripcion, Criterio criterio, Clasificacion padre ) throws CriterioPadreException, IOException{
		if(padre == null) {
			this.descripcion = descripcion;
			this.criterio = criterio;
			this.clasificacionPadre = null;
		}else if((padre != null) && (padre.getCriterio() == criterio)){//Si va a tener una clasificación padre y tienen el mismo criterio
			this.descripcion = descripcion;
			this.criterio = criterio;
			this.clasificacionPadre = padre;
		}else if((padre != null) && (padre.getCriterio() != criterio)){//Si va a tener una clasificación padre y no tienen el mismo criterio
			throw new CriterioPadreException();
		}
		
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
