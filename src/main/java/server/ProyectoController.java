package server;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import main.Proyecto;

import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioProyecto;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class ProyectoController {
	public <T> ModelAndView altaProyectoFront(Request req, Response res) {
		
		
		RepositorioOpIngreso repoOpIngreso = RepositorioOpIngreso.getInstance();
		
		List<T> opIngreso = (List<T>) repoOpIngreso.buscarOpIngreso();	

		HashMap<String, List<T>> proyectoOptions = new HashMap<String, List<T>>();

	    // Agrego valores al Hashmap (nombreReferencia, List)
		proyectoOptions.put("opIngreso", opIngreso);

		
		return new ModelAndView(proyectoOptions, "altaProyecto.hbs");
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
