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
		model.put("opEg", OpEg);
		model.put("proyecto", proyecto);
		
		
		return new ModelAndView(model, "asociarEgresoIngreso.hbs");
	}
	
public ModelAndView altaOpEgreso(Request req, Response res) throws ParseException {
		
		OperacionEgreso opEgreso = new OperacionEgreso();
		OperacionIngreso opIngreso = new OperacionIngreso();
		RepositorioProveedores repoProveedores = new RepositorioProveedores();
		RepositorioMonedas repoMonedas = new RepositorioMonedas();
		RepositorioMedioDePago repoMedioDePago = new RepositorioMedioDePago();
		RepositorioDocumentosComerciales repoDocumentoComercial = new RepositorioDocumentosComerciales();
		RepositorioItems repoItems = new RepositorioItems();
		RepositorioOrganizaciones repoOrganizaciones = new RepositorioOrganizaciones();
		RepositorioCompras repoCompras = new RepositorioCompras();
		
		String proveedorParam = req.queryParams("proveedor");
		int id_proveedor = Integer.parseInt(proveedorParam);
		String fechaParam = req.queryParams("fecha");
		String monedaParam = req.queryParams("moneda");
		int id_moneda = Integer.parseInt(monedaParam);
		String valorTotalParam = req.queryParams("valor");
		int valorTotal = Integer.parseInt(valorTotalParam);
		String medioDePagoParam = req.queryParams("medioDePago");
		int id_medioDePago = Integer.parseInt(medioDePagoParam);
		String comprobanteParam = req.queryParams("item");
		int id_comprobante = Integer.parseInt(comprobanteParam);
		String itemParam = req.queryParams("comprobante");
		int id_item = Integer.parseInt(itemParam);
		String organizacion = req.queryParams("organizacion");
		String compraParam = req.queryParams("compra");
		int id_compra = Integer.parseInt(compraParam);
		
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaParseada = formato.parse(fechaParam);
		

		

		String descripcion = req.queryParams("descripcion");
		
		res.redirect("/");
		
		return null;	
	}
}
