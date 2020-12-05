package server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import main.CurrencyML;
import main.DocumentoComercial;
import main.Item;
import main.MedioDePago;
import main.OperacionEgreso;
import main.Proveedor;
import main.TarjetaDeCredito;
import repositorios.RepositorioDocumentosComerciales;
import repositorios.RepositorioMedioDePago;
import repositorios.RepositorioMonedas;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioOrganizaciones;
import repositorios.RepositorioProveedores;
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
		RepositorioProveedores repoProveedores = new RepositorioProveedores();
		RepositorioMonedas repoMonedas = new RepositorioMonedas();
		RepositorioMedioDePago repoMedioDePago = new RepositorioMedioDePago();
		RepositorioDocumentosComerciales repoDocumentoComercial = new RepositorioDocumentosComerciales();
		RepositorioItems repoItems = new RepositorioItems();
		RepositorioOrganizaciones repoOrganizaciones = new RepositorioOrganizaciones();
		
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
		
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaParseada = formato.parse(fechaParam);
		
		opEgreso.setFecha(fechaParseada);
		opEgreso.setProveedor(repoProveedores.buscarProveedorPorId(id_proveedor));
		System.out.println("Yeeeii, pasó el problema");
		opEgreso.setId_moneda(repoMonedas.buscarMonedaPorID(id_moneda));
		opEgreso.setValorTotal(valorTotal);
		opEgreso.setMedioDePago(repoMedioDePago.buscarMedioDePagoPorId(id_medioDePago));
		opEgreso.setDocumentosComerciales((List<DocumentoComercial>) repoDocumentoComercial.buscarDocumentosComercialesPorId(id_comprobante));
		opEgreso.setItems((List<Item>) repoItems.buscarItemsPorId(id_item));
		opEgreso.setOrganizacion(repoOrganizaciones.buscarOrganizacionPorNombre(organizacion)); 
						

		RepositorioOpEgreso.getInstance().persist(opEgreso);

		res.redirect("/");
		
		return null;	
	}

}
