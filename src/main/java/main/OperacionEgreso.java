package main;

import java.io.File;
import java.util.Date;
import java.util.List;

public class OperacionEgreso {
	
	Proveedor proveedor;
	Date fecha;
	int valorTotal;
	MedioDePago medioDePago;
	List<Item> items;
	DocumentoComercial documentoComercial;
	
	
	public OperacionEgreso(Proveedor proveedor, Date fecha, int valorTotal, MedioDePago medioDePago, List<Item> items, DocumentoComercial documentoComercial) {
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.valorTotal = valorTotal;
		this.medioDePago = medioDePago;
		this.items = items;
		this.documentoComercial = documentoComercial;
	}
	

}
