package main;

public class Clasificacion {
	String descripcion;
	Criterio criterio;
	Clasificacion clasificacionPadre;
	
	public Clasificacion(String descripcion, Criterio criterio, Clasificacion padre ) {
		this.descripcion = descripcion;
		this.criterio = criterio;
		this.clasificacionPadre = padre;
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
	//compararCriterioPadre() : bool
}
