package main;

import java.util.Date;
import java.util.List;

public class OperacionEgreso{
	
	Proveedor proveedor;
	Date fecha;
	double valorTotal;
	MedioDePago medioDePago;
	List<Item> items;
	List<DocumentoComercial> documentosComerciales;
	Organizacion organizacion;

	public OperacionEgreso(Proveedor proveedor, Date fecha, MedioDePago medioDePago, List<Item> items, List<DocumentoComercial> documentosComerciales, Organizacion organizacion) {
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.medioDePago = medioDePago;
		this.items = items;
		this.documentosComerciales = documentosComerciales;
		this.valorTotal = 0;
		
		for (Item item : items) {
			this.valorTotal += item.getValor();
		}
		this.organizacion = organizacion;
		
	}
	
	public double getValorTotalOperacion() {
		return this.valorTotal;
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
