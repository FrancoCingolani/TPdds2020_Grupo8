package main;
import java.util.List;

public class OperacionIngreso {
	String descripcion;
	double valorTotal;
	List<OperacionEgreso> egresos;
	
	public OperacionIngreso(String descrip, double valorTtal, List<OperacionEgreso> operacionesEgre) {
		this.descripcion = descrip;
		this.valorTotal = valorTtal;
		this.egresos = operacionesEgre;
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
