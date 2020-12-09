package server;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.Clasificacion;
import main.OperacionEgreso;
import main.Presupuesto;
import repositorios.RepositorioCategorias;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioPresupuesto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClasificadorController {
	public ModelAndView clasificadorFront(Request req, Response res) {
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
		model.put("presupuestos", presu);
		model.put("clasificacion", clasificacion);
				
		return new ModelAndView(model, "clasificador.hbs");
	}
	
	public ModelAndView clasificarEgreso(Request req, Response res) throws ParseException {
		
		RepositorioOpEgreso repoOpEgreso = new RepositorioOpEgreso();
		RepositorioCategorias repoCategoria = new RepositorioCategorias();
		
		String opEgresoParam = req.queryParams("egreso");
		int id_operacion_egreso = Integer.parseInt(opEgresoParam);
		String categoriaParam = req.queryParams("categoria");
		int id_categoria = Integer.parseInt(categoriaParam);
		
		OperacionEgreso operacionEgreso = repoOpEgreso.buscarOpEgresoPorId(id_operacion_egreso);
		Clasificacion clasificacion = repoCategoria.buscarClasificacionPorId(id_categoria);
		
		operacionEgreso.setClasificacion(clasificacion);
		
		
		RepositorioOpEgreso.getInstance().persist(operacionEgreso);

		res.redirect("/");
		
		return null;	
	}
	
	public ModelAndView clasificarPresupuesto(Request req, Response res) throws ParseException {
		
		RepositorioPresupuesto repoPresupuesto = new RepositorioPresupuesto();
		RepositorioCategorias repoCategoria = new RepositorioCategorias();
		
		String presupuestoParam = req.queryParams("presupuesto");
		int id_presupuesto = Integer.parseInt(presupuestoParam);
		String categoriaParam = req.queryParams("categoria");
		int id_categoria = Integer.parseInt(categoriaParam);
		
		Presupuesto presupuesto = repoPresupuesto.buscarPresupuestoPorId(id_presupuesto);
		Clasificacion clasificacion = repoCategoria.buscarClasificacionPorId(id_categoria);
		
		presupuesto.setClasificacion(clasificacion);
		
		
		RepositorioPresupuesto.getInstance().persist(presupuesto);

		res.redirect("/");
		
		return null;	
	}	
	
}
