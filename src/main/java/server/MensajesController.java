package server;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MensajesController {
	public ModelAndView mensajes(Request req, Response res) {
		return new ModelAndView(null, "bandejaMensajes.hbs");
	}
}
