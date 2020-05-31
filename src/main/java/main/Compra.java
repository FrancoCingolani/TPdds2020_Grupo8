package main;

import java.util.List;

public class Compra extends Operacion{
	
	List<Presupuesto> presupuestos;
	List<OperacionEgreso> operacionesEgre;
	List<Usuario> revisores;
	List<Item> items;
	Presupuesto presupuestoElegido;
	
	public Compra(List<Presupuesto> presupuestos, List<OperacionEgreso> operacionesEgre, List<Usuario> revisores, List<Item> items, Presupuesto presupuestoElegido) {
		this.presupuestos = presupuestos;
		this.operacionesEgre = operacionesEgre;
		this.revisores = revisores;
		this.items = items;
		this.presupuestoElegido = presupuestoElegido;
		
	}

	public List<Presupuesto> getPresupuestos() {
		return presupuestos;
	}

	public void setPresupuestos(List<Presupuesto> presupuestos) {
		this.presupuestos = presupuestos;
	}

	public List<OperacionEgreso> getOperacionesEgre() {
		return operacionesEgre;
	}

	public void setOperacionesEgre(List<OperacionEgreso> operacionesEgre) {
		this.operacionesEgre = operacionesEgre;
	}

	public List<Usuario> getRevisores() {
		return revisores;
	}

	public void setRevisores(List<Usuario> revisores) {
		this.revisores = revisores;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public Presupuesto getPresupestoElegido() {
		return presupuestoElegido;
	}

	public void setPresupuestoElegido(Presupuesto presupuestoElegido) {
		this.presupuestoElegido = presupuestoElegido;
	}
	
	
	
}
