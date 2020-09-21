package vinculador;

import java.util.List;

import main.OperacionEgreso;

public interface CondicionFiltro {
	public List<OperacionEgreso> filtrarEgresos(List<OperacionEgreso> egresos);
}
