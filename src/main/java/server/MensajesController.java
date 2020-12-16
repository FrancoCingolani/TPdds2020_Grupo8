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
	public ModelAndView mensajesFront(Request req, Response res) {
		
		RepositorioMensajes repoMensajes = RepositorioMensajes.getInstance();
		
		int idUser = Integer.parseInt(req.session().attribute("id").toString());
		List<Mensaje> listaMensajes = (List<Mensaje>) repoMensajes.buscarMensajesPorID(idUser);
		
		return new ModelAndView(listaMensajes, "bandejaMensajes.hbs");
	}
	
	public ModelAndView mensajes(Request req, Response res) throws ParseException {
		
	//MensajeValidadorCompra unMensaje = new MensajeValidadorCompra();

		String textoMensaje = req.queryParams("textoMensaje");
		String asuntoMensaje = req.queryParams("asuntoMensaje");
		Boolean leido = Boolean.parseBoolean("leido");
		
		MensajeValidador unMensaje = new MensajeValidador(textoMensaje, asuntoMensaje , leido);
		
		
		unMensaje.setTextoMensaje(textoMensaje) ;
		unMensaje.setAsuntoMensaje(asuntoMensaje) ;
		unMensaje.setLeido(leido);
		RepositorioMensajes.getInstance().persist(unMensaje); 

		res.redirect("/");
		return null;
	}	
	
}
