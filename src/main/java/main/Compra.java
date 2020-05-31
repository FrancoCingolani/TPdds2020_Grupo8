package main;

import java.util.List;

public class Compra {
	
	List<Presupuesto> presupuestos;
	List<OperacionEgreso> operacionesEgre;
	List<Usuario> revisores;
	List<Item> items;
	
	public Compra(List<Presupuesto> presupuestos, List<OperacionEgreso> operacionesEgre, List<Usuario> revisores, List<Item> items) {
		this.presupuestos = presupuestos;
		this.operacionesEgre = operacionesEgre;
		this.revisores = revisores;
		this.items = items;
		
	}
	
}
