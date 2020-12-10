package main;

import java.io.FileNotFoundException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.IOException;

import exceptions.CriterioPadreException;

@Entity
@Table(name = "clasificaciones")
public class Clasificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_clasificacion;
	String descripcion;
	@ManyToOne
	@JoinColumn(name = "id_criterio")
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
	
	public Clasificacion(){
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
	
	public int getId_clasificacion() {
		return id_clasificacion;
	}
	
	//clasificar() :: void

}
