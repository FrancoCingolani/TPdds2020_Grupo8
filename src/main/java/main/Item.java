package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//QUIEN CAMBIE ESTO TAMBIEN TIENE QUE CAMBIAR EN EL MAIN......  ES MUUUUCHO

@Entity
public class Item {
	
	@Id @GeneratedValue
	int id_item;
	
	String descripcion;
	CurrencyML moneda;
	double valor;
	int cantidad;
	
	@ManyToOne
	Clasificacion clasificacion;
	
	int numeroPresupuesto;
	
	public Item (String descripcion, double valor, int cantidad, Clasificacion clasificacion, int numeroPresupuesto) {
		this.descripcion = descripcion;
		this.valor = valor;
		this.cantidad = cantidad;
		this.clasificacion = clasificacion;
		this.numeroPresupuesto = numeroPresupuesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Clasificacion getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	public double precioTotal() {
		return valor * cantidad;
	}

}
