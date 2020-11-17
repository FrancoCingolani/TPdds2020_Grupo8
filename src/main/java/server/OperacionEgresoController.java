package server;

import java.time.LocalDate;
import java.util.List;

import domain.Guardarropas;
import domain.prenda.RepositorioGuardarropas;
import domain.repos.RepositorioUsuarios;
import domain.usuario.Usuario;
import main.CurrencyML;
import main.OperacionEgreso;
import main.Proveedor;
import repositorios.RepositorioMonedas;
import repositorios.RepositorioOpEgreso;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class OperacionEgresoController {
	
	RepositorioMonedas repoMonedas = RepositorioMonedas.getInstance();
	
	public ModelAndView altaOpEgresoFront(Request req, Response res) {
		
	

		//List<CurrencyML> monedas = repoMonedas.buscarMonedas();	
		
		
		return new ModelAndView(null, "altaOpEgreso.hbs");
	}
	
	public ModelAndView altaOpEgreso(Request req, Response res) {
		
		OperacionEgreso opEgreso = new OperacionEgreso();

		String proveedor = req.queryParams("proveedor");
		String fecha = req.queryParams("fecha");
		String medioDePago = req.queryParams("medioDePago");
		String items = req.queryParams("items");
		String documentosComerciales = req.queryParams("documentosComerciales");
		String organizacion = req.queryParams("organizacion");
		
		/*
		opEgreso.setProveedor(proveedor);
		opEgreso.setFecha(fecha);
		opEgreso.setMedioDePago(medioDePago);
		opEgreso.setItems(items);
		opEgreso.setDocumentosComerciales(documentosComerciales);
		opEgreso.setOrganizacion(organizacion);
		*/


		RepositorioOpEgreso.getInstance().persist(opEgreso);

		res.redirect("/");
		return null;
	}

}
