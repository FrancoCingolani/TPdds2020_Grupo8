package server;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.StringTemplateSource;
import com.github.jknack.handlebars.io.TemplateLoader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.io.RuntimeIOException;
import org.hibernate.boot.jaxb.internal.stax.HbmEventReader;

import com.github.jknack.handlebars.Handlebars;

import main.CurrencyML;
import main.DocumentoComercial;
import main.Item;
import main.OperacionEgreso;
import main.OperacionIngreso;
import main.Proyecto;
import repositorios.RepositorioCompras;
import repositorios.RepositorioDocumentosComerciales;
import repositorios.RepositorioItems;
import repositorios.RepositorioMedioDePago;
import repositorios.RepositorioMonedas;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioOrganizaciones;
import repositorios.RepositorioProveedores;
import repositorios.RepositorioProyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AsociarEgreIngreController {
	public ModelAndView asociarEgreIngre(Request req, Response res) {
		Template t = null;
		// Tengo que traer los detalles de 3 modelos, los busco de a 1
		// Operacion ingreso
		RepositorioOpIngreso repoOpIng = RepositorioOpIngreso.getInstance();
		List<OperacionIngreso> OpIng = repoOpIng.buscarOpIngresoSinAsociar();
				
		// Operacion egreso
		RepositorioOpEgreso repoOpEg = RepositorioOpEgreso.getInstance();
		List<OperacionEgreso> OpEg = repoOpEg.buscarOpEgresoSinAsociar();
		
		// Proyecto
		RepositorioProyecto repoProy = RepositorioProyecto.getInstance();
		List<Proyecto> proyecto = repoProy.buscarProyecto();
		
		// Se junta todo en 1 solo objeto para poder pasarlo a la vista
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("opIng", OpIng);
		model.put("opEg", OpEg);
		model.put("proyecto", proyecto);
		
		
		return new ModelAndView(model, "asociarEgresoIngreso.hbs");
	}
	
	public ModelAndView asociarVinculadorEgreso (Request req, Response res){
		Template t = null;
		//VinculadorDeOperaciones vinculador = new VinculadorDeOperaciones();
		//vinculador.vincularEgresoAIngreso(opIngreso, orden)
		return new ModelAndView(null, "asociarEgresoIngreso.hbs");
	}
	
	public ModelAndView asociarVinculadorIngreso (Request req, Response res){
		Template t = null;
		//VinculadorDeOperaciones vinculador = new VinculadorDeOperaciones();
		//vinculador.vincularEgresoAIngreso(opIngreso, orden)
		return new ModelAndView(null, "asociarEgresoIngreso.hbs");
	}
	
	public ModelAndView asociarVinculadorProyecto (Request req, Response res){
		//este es el que es manual.. asi que solo seria poner en la bd el id del proyecto en la opIngreso	
		return new ModelAndView(null, "asociarEgresoIngreso.hbs");
	}

}
