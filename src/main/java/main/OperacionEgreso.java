package main;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "OperacionesEgreso")
public class OperacionEgreso{
	
	@Id @GeneratedValue
	int id_operacion_egreso;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	Proveedor proveedor;
	Date fecha;
	@ManyToOne
	@JoinColumn(name = "id_moneda")
	CurrencyML id_moneda;
	double valorTotal;
	@ManyToOne
	@JoinColumn(name = "id_medio_de_pago")
	MedioDePago medioDePago;
	@ManyToMany
	List<Item> items;
	@ManyToMany
	List<DocumentoComercial> documentosComerciales;
	@OneToOne
	@JoinColumn(name = "id_organizacion")
	Organizacion organizacion;
	boolean fueVinculado;
	@ManyToOne
	@JoinColumn(name = "id_operacion_ingreso")
	OperacionIngreso operacionIngreso;

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
