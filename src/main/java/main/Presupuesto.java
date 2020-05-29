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
}
