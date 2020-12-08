package server;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import main.Item;
import main.OperacionIngreso;
import main.Organizacion;
import main.Proyecto;

import repositorios.RepositorioOpIngreso;
import repositorios.RepositorioOrganizaciones;
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
		RepositorioOpIngreso repoOpIngreso = new RepositorioOpIngreso();
		RepositorioOrganizaciones repoOrganizaciones = new RepositorioOrganizaciones();

		String nombre = req.queryParams("nombre");
		String descripcion = req.queryParams("descripcion");
		String montoParam = req.queryParams("valor");
		int montoAsignado = Integer.parseInt(montoParam);
		String ingresosParam = req.queryParams("ingresos");
		int id_ingreso = Integer.parseInt(ingresosParam);
		String organizacion = req.queryParams("organizacion");
		
		proyecto.setNombre(nombre);
		proyecto.setDescripcion(descripcion);
		proyecto.setmontoAsignado(montoAsignado);
		proyecto.vincular(repoOpIngreso.buscarOpIngresoPorId(id_ingreso));
		Organizacion organizacionTraida = repoOrganizaciones.buscarOrganizacionPorNombre(organizacion);
		proyecto.setOrganizacion(organizacionTraida);
		
		RepositorioProyecto.getInstance().persist(proyecto);

		res.redirect("/");
		return null;
	}
}
