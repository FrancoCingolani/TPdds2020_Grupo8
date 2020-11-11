package server;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class OperacionIngresoController {
	public ModelAndView altaOpIngreso(Request req, Response res) {
		return new ModelAndView(null, "altaOpIngreso.hbs");
	}
}
