package main;
import java.util.List;
import java.util.Date;

public class OperacionIngreso {
	String descripcion;
	double valorTotal;
	List<OperacionEgreso> egresos;
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

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<OperacionEgreso> getOperacionesEgre() {
		return egresos;
	}

	public void agregarOperacionesEgreso(List<OperacionEgreso> operacionesEgre) {
		this.egresos = operacionesEgre;
	}
}
