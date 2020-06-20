package main;

import java.util.List;

import categoriasEntidadJuridica.Categoria;
import enumeradores.Actividad;
import enumeradores.TipoEntidadJuridica;

public class Organizacion {
	List<OperacionEgreso> operacionesEgresoEntidad;
	List<OperacionIngreso> operacionesIngresoEntidad;
	double ventasAnuales;
	int personal;
	String direccionPostal;
	Actividad actividad;
	Categoria categoria;
	TipoEntidadJuridica tipo;
	
	public void agregarOperacionEgreso(OperacionEgreso nuevaOperacion) {
		this.operacionesEgresoEntidad.add(nuevaOperacion);
		this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();//revisar xq una de egreso es una compra
	}
	
	public void agregarOperacionIngreso(OperacionIngreso nuevaOperacion) {
		this.operacionesIngresoEntidad.add(nuevaOperacion);
	//	this.ventasAnuales += nuevaOperacion.getValorTotalOperacion();//Para mi va en este...
	}
	
	
	public double getTotalVentas() {
		return this.ventasAnuales;
	}
	
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}

	public String getDescripcionCategoria() {
		if (this.categoria == null) {
			return "EntidadBase";
		}
		
		return this.categoria.getDescripcionCategoria();
	}
	
	public double getVentasAnuales() {
		return this.ventasAnuales;
	}
	
	public void setCategoria(Categoria nuevaCategoria) {
		this.categoria = nuevaCategoria;
	}
}
