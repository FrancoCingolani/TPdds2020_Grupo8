package main;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "OperacionesEgreso")
public class OperacionEgreso{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
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
	@ManyToOne
	@JoinColumn(name = "id_compra")
	Compra compra;
	@ManyToOne
	@JoinColumn(name = "id_clasificacion")
	Clasificacion clasificacion;
	
	public OperacionEgreso() {
	}

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
	
	public void setIdOperacionIngreso(int idOpIngreso) {
		this.id_operacion_egreso = idOpIngreso;
	}

	public Date getDate() {
		return fecha;
	}
	
	public Organizacion getOrganizacion() {
		return organizacion;
	}
	
	public int getId_operacion_egreso() {
		return id_operacion_egreso;
	}

	public void setId_operacion_egreso(int id_operacion_egreso) {
		this.id_operacion_egreso = id_operacion_egreso;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CurrencyML getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(CurrencyML id_moneda) {
		this.id_moneda = id_moneda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public MedioDePago getMedioDePago() {
		return medioDePago;
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
	}

	public List<DocumentoComercial> getDocumentosComerciales() {
		return documentosComerciales;
	}

	public void setDocumentosComerciales(List<DocumentoComercial> documentosComerciales) {
		this.documentosComerciales = documentosComerciales;
	}

	public boolean isFueVinculado() {
		return fueVinculado;
	}

	public void setFueVinculado(boolean fueVinculado) {
		this.fueVinculado = fueVinculado;
	}

	public OperacionIngreso getOperacionIngreso() {
		return operacionIngreso;
	}

	public void setOperacionIngreso(OperacionIngreso operacionIngreso) {
		this.operacionIngreso = operacionIngreso;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
}
