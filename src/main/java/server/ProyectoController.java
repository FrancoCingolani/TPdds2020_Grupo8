package server;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.OperacionIngreso;
import main.Proyecto;
import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioProyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectoController {
	public ModelAndView altaProyectoFront(Request req, Response res) {
		return new ModelAndView(null, "altaProyecto.hbs");
	}
	
	
	
	public ModelAndView altaProyecto(Request req, Response res) throws ParseException {
		
		Proyecto proyecto = new Proyecto();

		String nombre = req.queryParams("nombre");
		String descripcion = req.queryParams("descripcion");
		String monto = req.queryParams("montoAsignado");
		int montoAsignado = Integer.parseInt(monto);
		
		proyecto.setNombre(nombre);
		proyecto.setDescripcion(descripcion);
		proyecto.setmontoAsignado(montoAsignado);
		
		RepositorioProyecto.getInstance().persist(proyecto);

		res.redirect("/");
		return null;
	}
}
