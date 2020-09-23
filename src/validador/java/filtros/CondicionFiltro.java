package filtros;

import java.util.List;

import main.OperacionEgreso;
import main.OperacionIngreso;

public interface CondicionFiltro {
	public List<OperacionEgreso> filtrarEgresos(List<OperacionEgreso> egresos, OperacionIngreso opIngreso);
}
