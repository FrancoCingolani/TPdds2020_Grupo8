package main;

public class Item {
	
	String descripcion;
	double valor;
	int cantidad;
	
	public Item (String descripcion, double valor, int cantidad) {
		this.descripcion = descripcion;
		this.valor = valor;
		this.cantidad = cantidad;
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
	
	public double precioTotal() {
		return valor * cantidad;
	}

}
