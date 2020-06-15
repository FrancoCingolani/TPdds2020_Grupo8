package main;

import java.util.Arrays;
import java.util.List;

import mensajes.MensajeValidadorCompra;

public class ValidadorDeTransparencia {
	
	Compra compra;
	
	public ValidadorDeTransparencia(Compra compra) {
		this.compra = compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public void validarCompra(Compra compra) {
		boolean reqPresupuesto = this.requierePresupuesto();
		boolean basePresupuesto = this.fueRealizadaEnBasePresu();
		boolean presupuestoMenorValor = this.validarSeleccionMenorValor();
		this.notificarRevisores(reqPresupuesto, basePresupuesto, presupuestoMenorValor);
	}
	
	public List<Boolean> resultadosValidadorCompra() {
		return Arrays.asList(new Boolean[] {this.requierePresupuesto(), this.fueRealizadaEnBasePresu(), this.validarSeleccionMenorValor()});
	}
	
	private boolean requierePresupuesto() {
		List<Presupuesto> presupuestos = this.compra.getPresupuestos();
		if(presupuestos.size() != this.compra.getCantPresuReq()) {
			return false;
		}
		return true;
	}
	
	private boolean fueRealizadaEnBasePresu() {
		
		List<Presupuesto> presupuestos = this.compra.getPresupuestos();
		Presupuesto presupuestoElegido = this.compra.getPresupestoElegido();
		
		for (Presupuesto presupuesto : presupuestos) {
		    if(presupuesto == presupuestoElegido) {
		    	return true;
		    }
		}
		
		return false;
	}
	
	private boolean validarSeleccionMenorValor() {
		/**
		 * Ignacio: Si fuera lógico el proceso de compra, se debería validar que las variables presupuestos y presupuestoElegido estén seteadas y tengan
		 * datos cargados. Como nos guíamos por otra lógica, esto es correcto
		 */
		List<Presupuesto> presupuestos = this.compra.getPresupuestos();
		Presupuesto presupuestoElegido = this.compra.getPresupestoElegido();
		
		for (Presupuesto presupuesto : presupuestos) {
		    if(presupuesto.getValorTotal() < presupuestoElegido.getValorTotal()) {
		    	return false;
		    }
		}
		
		return true; 
	}
	
	private void notificarRevisores(boolean resultadoReqPresupuesto, boolean resultadoBasePresupuesto, boolean resultadoPresupuestoMenorValor) {
		String textoBase = "Cumple con cantidad de presupuestos requeridos: %s | Cumple con haber sido realizada en base a algun presupuesto: %s | Cumple con haberse realizado en base al presupuesto de menor valor: %s";
		String textoMensaje = String.format(textoBase, String.valueOf(resultadoReqPresupuesto), String.valueOf(resultadoBasePresupuesto), String.valueOf(resultadoPresupuestoMenorValor)).replaceAll("true", "OK").replaceAll("false", "ERROR");
		for (Usuario user : compra.revisores) {
			user.recibirMensaje(new MensajeValidadorCompra(textoMensaje));
		}
	}

}
