package main;

import java.util.Date;
import java.util.List;

public class OperacionEgreso extends Operacion {
	
	Proveedor proveedor;
	Date fecha;
	double valorTotal;
	MedioDePago medioDePago;
	List<Item> items;
	List<DocumentoComercial> documentoComercial;
	
	
	public OperacionEgreso(Proveedor proveedor, Date fecha, MedioDePago medioDePago, List<Item> items, List<DocumentoComercial> documentoComercial) {
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.medioDePago = medioDePago;
		this.items = items;
		this.documentoComercial = documentoComercial;
		this.valorTotal = 0;
		
		for (Item item : items) {
			this.valorTotal += item.getValor();
		}
		
	}
	
	public double getValorTotalOperacion() {
		return this.valorTotal;
	}
}
