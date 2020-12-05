package server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.Clasificacion;
import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Presupuesto;
import main.Proyecto;
import repositorios.RepositorioCategorias;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioPresupuesto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClasificadorController {
	public ModelAndView clasificador(Request req, Response res) {
		
				
				// Operacion egreso
				RepositorioOpEgreso repoOpEg = RepositorioOpEgreso.getInstance();
				List<OperacionEgreso> OpEg = repoOpEg.buscarOpEgreso();
				
				// Proyecto
				RepositorioPresupuesto repoPresu = RepositorioPresupuesto.getInstance();
				List<Presupuesto> presu = repoPresu.buscarPresupuesto();
				//Y las categorias para mas tarde..
				RepositorioCategorias repoCategoria =RepositorioCategorias.getInstance();
				List<Clasificacion> clasificacion = repoCategoria.buscarClasificacion();
				
				// Se junta todo en 1 solo objeto para poder pasarlo a la vista
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("OpEg", OpEg);
				model.put("proyecto", presu);
				model.put("clasificacion", clasificacion);
				
		return new ModelAndView(null, "clasificador.hbs");
	}
}
