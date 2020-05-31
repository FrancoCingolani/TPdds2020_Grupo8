package main;

import java.util.List;

public class ValidadorDeTransparencia {
	
	Compra compra;
	
	public ValidadorDeTransparencia(Compra compra) {
		this.compra = compra;
	}
	

	public void setCompra(Compra compra) {
		this.compra = compra;
	}



	public void validarCompra(Compra compra) {
		this.requierePresupuesto();
		this.fueRealizadaEnBasePresu();
		this.validarSeleccionMenorValor();
	}
	
	public boolean requierePresupuesto() {
		List<Presupuesto> presupuestos = this.compra.getPresupuestos();
		if(presupuestos.size() != compra.getCantPresuReq()) {
			return false;
		}
		return true;
	}
	
	public boolean fueRealizadaEnBasePresu() {
		return true;
	}
	
	public boolean validarSeleccionMenorValor() {
		
		List<Presupuesto> presupuestos = this.compra.getPresupuestos();
		Presupuesto presupuestoElegido = this.compra.getPresupestoElegido();
		
		for (Presupuesto presupuesto : presupuestos) {
		    if(presupuesto.getValorTotal() < presupuestoElegido.getValorTotal()) {
		    	return false;
		    }
		}
		
		return true; 
		
	}

}
