package main;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Proyectos")
public class Proyecto {
	
	@Id @GeneratedValue
	int id_proyecto;
	
	String nombre;
	String descripcion;
	double montoAsignado;
	@OneToMany
	@JoinColumn(name = "id_subsidio")
	List<OperacionIngreso> subsidios;
	
	public Proyecto(String nombre, String descripcion, double montoAsignado, List<OperacionIngreso> operacionesIngre) {
		this.nombre= nombre;
		this.descripcion = descripcion;
		this.montoAsignado = montoAsignado;
		this.subsidios = operacionesIngre;
		
	}
	
	public double getmontoAsignadoOperacion() {
		return montoAsignado;
	}

	public void setmontoAsignado(double montoAsignado) {
		this.montoAsignado = montoAsignado;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void agregarOperacionIngreso(OperacionIngreso nuevaOperacion) {
		this.subsidios.add(nuevaOperacion);
	//	this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();//Para mi va en este...
	}
	public int getIdProyecto() {
		return id_proyecto;
	}
}


