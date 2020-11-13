package server;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class AuditoriaController {
	public ModelAndView auditoria(Request req, Response res) {
		return new ModelAndView(null, "auditoria.hbs");
	}
}
