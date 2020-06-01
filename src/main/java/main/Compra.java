package main;

import java.util.List;

public class Compra extends Operacion{
	
	int cantPresuReq;
	List<Presupuesto> presupuestos;
	List<OperacionEgreso> operacionesEgre;
	List<Usuario> revisores;
	List<Item> items;
	Presupuesto presupuestoElegido;
	
	public Compra(int cantPresuReq, List<Presupuesto> presupuestos, List<OperacionEgreso> operacionesEgre, List<Usuario> revisores, List<Item> items, Presupuesto presupuestoElegido) {
		/** Ignacio: No es lógico que al momento de crearse la necesidad de compra se carguen al mismo tiempo los presupuestos, los egresos, los revisores y el presupuesto
		 * Se supone que primero se carga la compra, sin presupuestos, sin revisores, sin egresos y sin presupuesto elegido. Los presupuestos se van pidiendo a los proveedores
		 * quienes los envían y luego se agregan a la compra en caso de cumplir ciertos parámetros. Mismo con revisores. El presupuesto elegido sale de comprar todos
		 * los presupuestos cargados y elegir alguno de ellos. Y las operaciones de egreso se cargan cuando se efectúa el intercambio "item por dinero"
		 */
		this.cantPresuReq = cantPresuReq;
		this.presupuestos = presupuestos;
		this.operacionesEgre = operacionesEgre;
		this.revisores = revisores;
		this.items = items;
		this.presupuestoElegido = presupuestoElegido;
		
	}
	
	public int getCantPresuReq() {
		return cantPresuReq;
	}
	public void setCantPresuReq(int cantPresuReq) {
		this.cantPresuReq = cantPresuReq;
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
	
	public void agregarRevisor(Usuario nuevoRevisor) {
		this.revisores.add(nuevoRevisor);
	}
	
	public void agregarPresupuesto (Presupuesto nuevoPresupuesto) {
		// @TODO verificar que cada item del presupuesto coincida con un item de la compra
		this.presupuestos.add(nuevoPresupuesto);
	}
	
	
}
