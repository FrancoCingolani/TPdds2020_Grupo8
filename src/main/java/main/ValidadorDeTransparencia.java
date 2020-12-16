package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mensajes.MensajeValidador;
import repositorios.RepositorioUsuarios;

public class ValidadorDeTransparencia {
	
	Compra compra;
	Proyecto proyecto =null;
	
	public ValidadorDeTransparencia(Compra compra) {
		this.compra = compra;
	}
	public ValidadorDeTransparencia(Compra compra,Proyecto proyecto) {
		this.compra = compra;
		this.proyecto = proyecto;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	

	public void validarCompra() {
		boolean reqPresupuesto = this.requierePresupuesto();
		boolean basePresupuesto = this.fueRealizadaEnBasePresu();
		boolean presupuestoMenorValor = this.validarSeleccionMenorValor();
		this.notificarRevisores(reqPresupuesto, basePresupuesto, presupuestoMenorValor);
	}
	
	public void validarProyecto() {
		boolean dentroDelMaximoSinPresu = this.dentroDelMaximoSinPresu();
		this.notificarDirectorProyecto(dentroDelMaximoSinPresu);
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
		 * Ignacio: Si fuera logico el proceso de compra, se deberia validar que las variables presupuestos y presupuestoElegido estan seteadas y tengan
		 * datos cargados. Como nos guardamos por otra logica, esto es correcto
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
			user.recibirMensaje(new MensajeValidador(textoMensaje));
		}
	}
	
	//PROYECTOS
	private boolean dentroDelMaximoSinPresu() {
		List<OperacionIngreso> ingresos = this.proyecto.getSubsidios();
		List<OperacionEgreso> egresos =  new ArrayList<OperacionEgreso>();
		double sumaEgresos= 0;
		for (OperacionIngreso ingreso : ingresos) {
			egresos.addAll(ingreso.getOperacionesEgre());
		}
		for (OperacionEgreso egreso : egresos) {
			sumaEgresos += egreso.getValorTotal();
		}
		
		if(sumaEgresos > this.proyecto.getMaxSinPresu()) {
			return false;
		}
		
		return true;
	}
	
	
	private void notificarDirectorProyecto(boolean dentroDelMaximoSinPresu) {
		RepositorioUsuarios repoUser = new RepositorioUsuarios();
		
		String textoBase = "Cumple con gastos dentro del maximo sin presupuesto: %s";
		String textoMensaje = String.format(textoBase, String.valueOf(dentroDelMaximoSinPresu)).replaceAll("true", "OK").replaceAll("false", "ERROR");
		Usuario director = repoUser.getUserByID(proyecto.getIDDirector());
		director.recibirMensaje(new MensajeValidador(textoMensaje));

	}

}
