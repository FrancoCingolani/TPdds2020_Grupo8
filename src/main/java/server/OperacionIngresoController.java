package server;
import main.OperacionEgreso;
import main.OperacionIngreso;
import repositorios.RepositorioOpEgreso;
import repositorios.RepositorioOpIngreso;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.CurrencyML;

public class OperacionIngresoController {
	public ModelAndView altaOpIngresoFront(Request req, Response res) {
		return new ModelAndView(null, "altaOpIngreso.hbs");
	}
	
	
public ModelAndView altaOpIngreso(Request req, Response res) throws ParseException {
		
		OperacionIngreso opIngreso = new OperacionIngreso();

		String descripcion = req.queryParams("descripcion");
		//String fechaParam = req.queryParams("fecha");
		//String moneda = req.queryParams("moneda");
		String valorTotalParam = req.queryParams("valorTotal");
		int valorTotal = Integer.parseInt(valorTotalParam);
		
		CurrencyML monedaPrueba = new CurrencyML("Forint Hungaro", "F", 2);
		
		Date fechaNow = new Date();
		
		//SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		//Date fechaParseada = formato.parse(fechaParam);
		
		opIngreso.setDescripcion(descripcion);
		opIngreso.setFechaIngreso(fechaNow);
		opIngreso.setId_moneda(monedaPrueba);
		opIngreso.setValorTotal(valorTotal);
		


		RepositorioOpIngreso.getInstance().persist(opIngreso);

		res.redirect("/");
		return null;
	}
}
