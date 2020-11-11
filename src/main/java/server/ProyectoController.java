package server;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectoController {
	public ModelAndView altaProyecto(Request req, Response res) {
		return new ModelAndView(null, "altaProyecto.hbs");
	}
}
