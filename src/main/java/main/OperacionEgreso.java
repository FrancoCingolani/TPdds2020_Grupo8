package main;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class OperacionEgreso{
	
	@Id @GeneratedValue
	int id_operacion_egreso;
	
	@ManyToOne
	Proveedor proveedor;
	Date fecha;
	double valorTotal;
	@ManyToOne
	MedioDePago medioDePago;
	@OneToMany
	List<Item> items;
	@OneToMany
	List<DocumentoComercial> documentosComerciales;
	@OneToOne
	Organizacion organizacion;
	boolean fueVinculado;

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
		this.fueVinculado = false;
		
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
