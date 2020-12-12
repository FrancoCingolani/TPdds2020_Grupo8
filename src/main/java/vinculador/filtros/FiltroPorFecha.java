package vinculador.filtros;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Proyecto;

public class FiltroPorFecha implements CondicionFiltro{

	private static final long DIAS_MARGEN = 7;

	@Override
	public List<OperacionEgreso> filtrarEgresos(List<OperacionEgreso> egresos, OperacionIngreso opIngreso) {
		List<OperacionEgreso> egresosFiltrados = new ArrayList<OperacionEgreso>(); 
		for (int i = 0; i < egresos.size(); i++) {
			OperacionEgreso egActual = egresos.get(i);
			if (Math.abs(ChronoUnit.DAYS.between(egActual.getDate().toInstant(), opIngreso.getDate().toInstant())) <= DIAS_MARGEN) { // Si tiene menos (o igual) de la cantidad de días indicados, antes o después, es válido y lo agrego a los filtrados 
				egresosFiltrados.add(egActual);
			}
		}
		
		return egresosFiltrados;
	}

	@Override
	public Boolean filtrarEgresos(OperacionEgreso egreso, OperacionIngreso opIngreso) {
		return Math.abs(ChronoUnit.DAYS.between(egreso.getDate().toInstant(), opIngreso.getDate().toInstant())) <= DIAS_MARGEN;
	}
	@Override
	public Boolean filtrarProyectos( OperacionIngreso opIngreso, Proyecto proyecto) {
		return Math.abs(ChronoUnit.DAYS.between(opIngreso.getDate().toInstant(), opIngreso.getDate().toInstant())) <= DIAS_MARGEN;
	}
	
}
