package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Criterios")
public class Criterio {
	
	@Id @GeneratedValue
	int id_criterio;
	
	String descripcion;
	
	public Criterio(String descipcion) {
		this.descripcion = descipcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
