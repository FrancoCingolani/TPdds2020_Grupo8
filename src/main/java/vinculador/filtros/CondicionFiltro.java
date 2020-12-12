package vinculador.filtros;

import java.util.List;

import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Proyecto;

public interface CondicionFiltro {
	public List<OperacionEgreso> filtrarEgresos(List<OperacionEgreso> egresos, OperacionIngreso opIngreso);
	public Boolean filtrarEgresos(OperacionEgreso egreso, OperacionIngreso opIngreso);
	public Boolean filtrarProyectos( OperacionIngreso opIngreso, Proyecto proyecto);
}
