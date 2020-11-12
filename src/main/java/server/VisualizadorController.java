package server;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class VisualizadorController {
	public ModelAndView visualizador(Request req, Response res) {
		return new ModelAndView(null, "visualizarEgresoIngreso.hbs");
	}
}
