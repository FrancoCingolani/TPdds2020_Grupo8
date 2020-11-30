package server;
import main.OperacionIngreso;
import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioMonedas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import java.util.List;

import enumeradores.Actividad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import main.CurrencyML;

public class OperacionIngresoController {
	
	public ModelAndView altaOpIngresoFront(Request req, Response res) {
		
		RepositorioMonedas repoMonedas = RepositorioMonedas.getInstance();
		
		List<CurrencyML> currencyml = repoMonedas.buscarMonedas();
		
		
		
		return new ModelAndView(currencyml, "altaOpIngreso.hbs");
	}
	
	
	public ModelAndView altaOpIngreso(Request req, Response res) throws ParseException {
		
		OperacionIngreso opIngreso = new OperacionIngreso();

		String descripcion = req.queryParams("descripcion");
		String fechaParam = req.queryParams("fecha");
		String monedaParam = req.queryParams("moneda");
		int id_moneda = Integer.parseInt(monedaParam);
		//CurrencyML id_moneda = Integer.parseInt(monedaParam);
		String valorTotalParam = req.queryParams("valorTotal");
		int valorTotal = Integer.parseInt(valorTotalParam);
		
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaParseada = formato.parse(fechaParam);
		
		opIngreso.setDescripcion(descripcion);
		opIngreso.setFechaIngreso(fechaParseada);
		
		//OTRO DETALLE QUE ENCONTRÉ. PARA PERSISTIRLO TENGO QUE PASAR UN TIPO CURRENCYML, NO UN INTEGER. VOLVER A VER PARA CORREGIRLO
		//opIngreso.setId_moneda(id_moneda);
		
		opIngreso.setValorTotal(valorTotal);
		


		RepositorioOpIngreso.getInstance().persist(opIngreso);

		res.redirect("/");
		return null;
	}
}
