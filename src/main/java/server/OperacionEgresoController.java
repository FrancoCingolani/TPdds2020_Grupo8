package server;

import java.time.LocalDate;
import java.util.List;

import main.CurrencyML;
import repositorios.RepositorioMonedas;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class OperacionEgresoController {
	
	RepositorioMonedas repoMonedas = RepositorioMonedas.getInstance();
	
	public ModelAndView altaOpEgreso(Request req, Response res) {
		
	

		List<CurrencyML> monedas = repoMonedas.buscarMonedas();	
		
		
		return new ModelAndView(monedas, "altaOpEgreso.hbs");
	}

}
