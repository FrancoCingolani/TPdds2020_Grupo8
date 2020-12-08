package server;


import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.StringTemplateSource;
import com.github.jknack.handlebars.io.TemplateLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.io.RuntimeIOException;
import org.hibernate.boot.jaxb.internal.stax.HbmEventReader;

import com.github.jknack.handlebars.Handlebars;

import main.Clasificacion;
import main.CurrencyML;
import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Proyecto;
import repositorios.RepositorioClasificacion;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioProyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VisualizadorController {
	public ModelAndView visualizador(Request req, Response res) {
		Template t = null;
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
		
		// Debo traer todas las clasificaciones disponibles para asi ponerlas en el filtro
		RepositorioClasificacion repoClas = RepositorioClasificacion.getInstance();
		List<Clasificacion> clasificaciones = repoClas.buscarClasificaciones();
		
		// Se junta todo en 1 solo objeto para poder pasarlo a la vista
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("opIng", OpIng);
		model.put("opEg", OpEg);
		model.put("proyecto", proyecto);
		model.put("clasificaciones", clasificaciones);
		
		return new ModelAndView(model, "visualizarEgresoIngreso.hbs");
	}
	
	public ModelAndView visualizadorClasificador(Request req, Response res) throws CloneNotSupportedException {
		Template t = null;
		int idClasificacionOpEgreso = Integer.parseInt(req.params(":id")); // id pasado por parámetro
		// Tengo que traer los detalles de 3 modelos, los busco de a 1
		// Operacion ingreso
		RepositorioOpIngreso repoOpIng = RepositorioOpIngreso.getInstance();
		List<OperacionIngreso> OpIng = repoOpIng.buscarOpIngreso();
				
		// Operacion egreso. Acá debo filtrar las op egreso para traer solo las de clasificacion pedida
		RepositorioOpEgreso repoOpEg = RepositorioOpEgreso.getInstance();
		List<OperacionEgreso> OpEg = repoOpEg.buscarOpEgresoPorClasificacion(idClasificacionOpEgreso);
		
		// Proyecto
		RepositorioProyecto repoProy = RepositorioProyecto.getInstance();
		List<Proyecto> proyecto = repoProy.buscarProyecto();
		
		// Debo traer todas las clasificaciones disponibles para asi ponerlas en el filtro
		RepositorioClasificacion repoClas = RepositorioClasificacion.getInstance();
		List<Clasificacion> clasificaciones = repoClas.buscarClasificaciones();
		
		// Se junta todo en 1 solo objeto para poder pasarlo a la vista
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("opIng", OpIng);
		model.put("opEg", OpEg);
		model.put("proyecto", proyecto);
		model.put("clasificaciones", clasificaciones);
		
		return new ModelAndView(model, "visualizarEgresoIngreso.hbs");
	}
}
