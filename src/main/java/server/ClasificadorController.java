package server;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ClasificadorController {
	public ModelAndView clasificador(Request req, Response res) {
		return new ModelAndView(null, "clasificador.hbs");
	}
}
