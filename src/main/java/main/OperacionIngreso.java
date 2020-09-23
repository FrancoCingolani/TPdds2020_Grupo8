package main;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Date;

@Entity
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
	
	public OperacionIngreso(String descrip, double valorTtal, List<OperacionEgreso> operacionesEgre, Organizacion organizacion) {
		this.descripcion = descrip;
		this.valorTotal = valorTtal;
		this.egresos = operacionesEgre;
		this.organizacion = organizacion;
		this.fechaIngreso = new Date();
	}
	
	public double getValorTotalOperacion() {
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
	
	public int getId() {
		return id_operacion_ingreso;
	}
	
	public Date getDate() {
		return fechaIngreso;
	}
	
}
