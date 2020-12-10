package main;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "presupuestos")
public class Presupuesto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_presupuesto;
	
	@ManyToOne
	@JoinColumn(name = "id_moneda")
	CurrencyML id_moneda;
	double valorTotal;
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	ProveedorFisico proveedor;
	String detalle;
	
	@ManyToMany
	private List<DocumentoComercial> documentos = new ArrayList<DocumentoComercial>();
	
	@OneToMany
	private List<Item> items = new ArrayList<Item>();
	
	int numeroPresupuesto;
	
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	Proyecto proyecto;
	
	@ManyToOne
	@JoinColumn(name = "id_clasificacion")
	Clasificacion clasificacion;
	
	public Presupuesto() {
	}

	
	public Presupuesto(ProveedorFisico proveedor,String detalle, List<Item> items, List<DocumentoComercial> documentos) {
		this.valorTotal = 0;
		this.proveedor = proveedor;
		this.detalle = detalle;
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

	public void setProveedor(ProveedorFisico proveedor) {
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
	
	public int getId_presupuesto() {
		return id_presupuesto;
	}
	
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
