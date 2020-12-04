package server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import main.CurrencyML;
import main.MedioDePago;
import main.OperacionEgreso;
import main.Proveedor;
import main.TarjetaDeCredito;
import repositorios.RepositorioDocumentosComerciales;
import repositorios.RepositorioMedioDePago;
import repositorios.RepositorioMonedas;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioItems;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class OperacionEgresoController {
	
	RepositorioMonedas repoMonedas = RepositorioMonedas.getInstance();
	
	public <T> ModelAndView altaOpEgresoFront(Request req, Response res) {
		
		RepositorioMonedas repoMonedas = RepositorioMonedas.getInstance();
		RepositorioMedioDePago repoMedioDePago = RepositorioMedioDePago.getInstance();
		RepositorioDocumentosComerciales repoDocComerciales = RepositorioDocumentosComerciales.getInstance();
		RepositorioItems repoItems = RepositorioItems.getInstance();
		
		List<T> currencyml = (List<T>) repoMonedas.buscarMonedas();	
		//List<T> mediosDePago = (List<T>) repoMedioDePago.buscarMediosDePago();
		List<T> documentosComerciales = (List<T>) repoDocComerciales.buscarDocumentosComerciales();	
		List<T> items = (List<T>) repoItems.buscarItems();	
		
		
		HashMap<String, List<T>> opEgresoOptions = new HashMap<String, List<T>>();

	    // Agrego valores al Hashmap (nombreReferencia, List)
		opEgresoOptions.put("monedas", currencyml);
		//opEgresoOptions.put("mediosDePago", mediosDePago);
		opEgresoOptions.put("documentosComerciales", documentosComerciales);
		opEgresoOptions.put("items", items);
		
		
		return new ModelAndView(opEgresoOptions, "altaOpEgreso.hbs");
	}
	
	public ModelAndView altaOpEgreso(Request req, Response res) throws ParseException {
		
		OperacionEgreso opEgreso = new OperacionEgreso();
		
		String cuitProveedor = req.queryParams("proveedor");
		String fechaParam = req.queryParams("fecha");
		String monedaParam = req.queryParams("moneda");
		int id_moneda = Integer.parseInt(monedaParam);
		String medioDePagoParam = req.queryParams("medioDePago");
		int id_medioDePago = Integer.parseInt(medioDePagoParam);
		String comprobanteParam = req.queryParams("item");
		int id_comprobante = Integer.parseInt(comprobanteParam);
		String itemParam = req.queryParams("comprobante");
		int id_item = Integer.parseInt(itemParam);
		
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaParseada = formato.parse(fechaParam);
		
		opEgreso.setFecha(fechaParseada);
		//opEgreso.setMedioDePago(medioDePago);
		//opEgreso.setItems(items);
		//opEgreso.setDocumentosComerciales(documentosComerciales);
		//opEgreso.setOrganizacion(organizacion);
		
		
		
		/*

		String proveedor = req.queryParams("proveedor");
		String fecha = req.queryParams("fecha");
		//String medioDePago = req.queryParams("medioDePago");
		String items = req.queryParams("items");
		String documentosComerciales = req.queryParams("documentosComerciales");
		String organizacion = req.queryParams("organizacion");
		
		Date fechaMedioDePago = new Date();
		TarjetaDeCredito medioDePago = new TarjetaDeCredito("785430001547", "246", fechaMedioDePago, "Franco", "DNI", "456123789");
		
		
		opEgreso.setProveedor(proveedor);
		
		
		


		RepositorioOpEgreso.getInstance().persist(opEgreso);

		res.redirect("/");
		
		return null;
		
		*/
		
		return new ModelAndView(null, "home.hbs");
		
		
	}

}
