package main;

public class Item {
	
	String descripcion;
	double valor;
	
	public Item (String descripcion, double valor) {
		this.descripcion = descripcion;
		this.valor = valor;
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
	
	

}
