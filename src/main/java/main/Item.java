package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//QUIEN CAMBIE ESTO TAMBIEN TIENE QUE CAMBIAR EN EL MAIN......  ES MUUUUCHO

@Entity
@Table(name = "Items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_item;
	
	String descripcion;
	@ManyToOne
	@JoinColumn(name = "id_moneda")
	CurrencyML id_moneda;
	double valor;
	int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "id_clasificacion")
	Clasificacion clasificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_compra")
	Compra compra;
	
	int numeroPresupuesto;
	
	public Item () {
	}
	
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
	
	public int getId_item() {
		return id_item;
	}

}
