package server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.CurrencyML;
import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Proyecto;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioProyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VisualizadorController {
	public ModelAndView visualizador(Request req, Response res) {
		// Tengo que traer los detalles de 3 modelos, los busco de a 1
		// Operacion ingreso
		RepositorioOpIngreso repoOpIng = RepositorioOpIngreso.getInstance();
		List<OperacionIngreso> OpIng = repoOpIng.buscarOpIngreso();
				
		// Operacion egreso
		RepositorioOpEgreso repoOpEg = RepositorioOpEgreso.getInstance();
		List<OperacionEgreso> OpEg = repoOpEg.buscarOpEgreso();
		
		// Proyecto
		RepositorioProyecto repoProy = RepositorioProyecto.getInstance();
		List<Proyecto> proyecto = repoProy.buscarProyecto();
		
		// Se junta todo en 1 solo objeto para poder pasarlo a la vista
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("opIng", OpIng);
		model.put("OpEg", OpEg);
		model.put("proyecto", proyecto);
		
		return new ModelAndView(model, "visualizarEgresoIngreso.hbs");
	}
}
