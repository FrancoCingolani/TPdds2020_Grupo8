package server;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class OperacionEgresoController {
	
	public ModelAndView altaOpEgreso(Request req, Response res) {
		return new ModelAndView(null, "altaOpEgreso.hbs");
	}

}
