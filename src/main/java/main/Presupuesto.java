package main;


import java.util.List;

public class Presupuesto {
	
	double valorTotal;
	Proveedor proveedor;
	String detalle;
	List<DocumentoComercial> documentos;
	List<Item> items;
	
	public Presupuesto(double valorTotal, Proveedor proveedor,String detalle, List<Item> items, List<DocumentoComercial> documentos) {
		this.valorTotal = 0;
		this.proveedor = proveedor;
		this.items = items;
		this.documentos = documentos;
		for (Item item : items) {
			this.valorTotal += item.getValor();
		}
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<DocumentoComercial> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<DocumentoComercial> documentos) {
		this.documentos = documentos;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
