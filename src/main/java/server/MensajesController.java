package server;

/*
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MensajesController {
	public ModelAndView mensajes(Request req, Response res) {
		return new ModelAndView(null, "bandejaMensajes.hbs");
	}
}
*/
import java.text.ParseException;

import java.util.List;


import mensajes.*;

import repositorios.RepositorioMensajes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MensajesController {
	public <T> ModelAndView mensajesFront(Request req, Response res) {
		RepositorioMensajes repoMensajes = RepositorioMensajes.getInstance();
		
		List<T> listaMensajes = (List<T>) repoMensajes.buscarMensaje();
		
		return new ModelAndView(listaMensajes, "bandejaMensajes.hbs");
	}
	
public ModelAndView mensajes(Request req, Response res) throws ParseException {
		
	//MensajeValidadorCompra unMensaje = new MensajeValidadorCompra();

		String textoMensaje = req.queryParams("textoMensaje");
		String asuntoMensaje = req.queryParams("asuntoMensaje");
		Boolean leido = Boolean.parseBoolean("leido");
		
	MensajeValidadorCompra unMensaje = new MensajeValidadorCompra(textoMensaje, asuntoMensaje , leido);
		
		
		unMensaje.setTextoMensaje(textoMensaje) ;
		unMensaje.setAsuntoMensaje(asuntoMensaje) ;
		unMensaje.setLeido(leido);
		RepositorioMensajes.getInstance().persist(unMensaje); 

		res.redirect("/");
		return null;
	}	
	
}
