package main;
//QUIEN CAMBIE ESTO TAMBIEN TIENE QUE CAMBIAR EN EL MAIN......  ES MUUUUCHO
public class Item {
	
	String descripcion;
	double valor;
	int cantidad;
	Clasificacion clasificacion;
	
	public Item (String descripcion, double valor, int cantidad, Clasificacion clasificacion) {
		this.descripcion = descripcion;
		this.valor = valor;
		this.cantidad = cantidad;
		this.clasificacion = clasificacion;
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
