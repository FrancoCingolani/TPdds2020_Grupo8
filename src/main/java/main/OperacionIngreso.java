package main;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "OperacionesIngreso")
public class OperacionIngreso {
	
	@Id @GeneratedValue
	int id_operacion_ingreso;
	
	String descripcion;
	@ManyToOne
	@JoinColumn(name = "id_moneda")
	CurrencyML id_moneda;
	double valorTotal;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operacionIngreso")
	List<OperacionEgreso> egresos;
	@ManyToOne
	@JoinColumn(name = "id_organizacion")
	Organizacion organizacion;
	Date fechaIngreso;
	
	public OperacionIngreso() {
	}
	
	public OperacionIngreso(String descrip, double valorTtal, List<OperacionEgreso> operacionesEgre, Organizacion organizacion) {
		this.descripcion = descrip;
		this.valorTotal = valorTtal;
		this.egresos = operacionesEgre;
		this.organizacion = organizacion;
		this.fechaIngreso = new Date();
	}
	
	public CurrencyML getId_moneda() {
		return id_moneda;
	}

	public void setId_moneda(CurrencyML id_moneda) {
		this.id_moneda = id_moneda;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Organizacion getOrganizacion() {
		return organizacion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<OperacionEgreso> getOperacionesEgre() {
		return egresos;
	}

	public void agregarOperacionesEgreso(List<OperacionEgreso> operacionesEgre) {
		this.egresos = operacionesEgre;
	}
	
	public int getId_operacion_ingreso() {
		return id_operacion_ingreso;
	}
	
	public Date getDate() {
		return fechaIngreso;
	}


	public double getSumaParcialEgresosAsociados() {
		double sumaParcial = 0;
		for (OperacionEgreso egreso : this.egresos) {
			sumaParcial += egreso.getValorTotalOperacion();
		}
		
		return sumaParcial;
	}
}
