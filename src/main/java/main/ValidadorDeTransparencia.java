package main;

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
	
	public boolean requierePresupuesto() {
		List<Presupuesto> presupuestos = this.compra.getPresupuestos();
		if(presupuestos.size() != this.compra.getCantPresuReq()) {
			return false;
		}
		return true;
	}
	
	public boolean fueRealizadaEnBasePresu() {
		Presupuesto presupuestoElegido = this.compra.getPresupestoElegido();
		List<Item> itemsPresupuesto = presupuestoElegido.getItems();
		List<OperacionEgreso> opsEgreso = this.compra.getOperacionesEgre();
		List<Item> itemsCompra;
		//Se que no hace lo que quiero
		//La idea es unir todos los items de las distintas compras en una lista.
		/*for(List<OperacionEgreso> opsEgreso : Items){
            for(OperacionEgreso i: list){
               itemsCompra.add(i);
            }
        }*/
		//Luego ordenarlos por algun criterio
		/*Collections.sort(itemsPresupuesto);
	    Collections.sort(itemsCompra);  
	    */
	    //Al final Comprarlos
	    return itemsCompra.equals(itemsPresupuesto);
		
		//tambien se me habia ocurrido mirar primero el valor pagado con el presupuestado
	    //Si no es asi, listo. Si lo es, comparamos con lo de arriba
	}
	
	public boolean validarSeleccionMenorValor() {
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
	
	public void notificarRevisores(boolean resultadoReqPresupuesto, boolean resultadoBasePresupuesto, boolean resultadoPresupuestoMenorValor) {
		String textoBase = "Cumple con cantidad de presupuestos requeridos: %s | Cumple con haber sido realizada en base a algun presupuesto: %s | Cumple con haberse realizado en base al presupuesto de menor valor: %s";
		String textoMensaje = String.format(textoBase, String.valueOf(resultadoReqPresupuesto), String.valueOf(resultadoBasePresupuesto), String.valueOf(resultadoPresupuestoMenorValor)).replaceAll("true", "OK").replaceAll("false", "ERROR");
		for (Usuario user : compra.revisores) {
			user.recibirMensaje(new MensajeValidadorCompra(textoMensaje));
		}
	}

}
