package main;

import java.util.List;

public class Organizacion {
	List<OperacionEgreso> operacionesEgresoEntidad;
	double ventasAnuales;
	
	public void agregarOperacionEgreso(OperacionEgreso nuevaOperacion) {
		this.operacionesEgresoEntidad.add(nuevaOperacion);
		this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();
	}
	
	public double getTotalVentas() {
		return this.ventasAnuales;
	}
}
