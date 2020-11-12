package server;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AsociarEgreIngreController {
	public ModelAndView asociarEgreIngre(Request req, Response res) {
		return new ModelAndView(null, "asociarEgresoIngreso.hbs");
	}
}
