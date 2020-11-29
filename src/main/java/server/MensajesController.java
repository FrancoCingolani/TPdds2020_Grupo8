package server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import main.OperacionIngreso;
import mensajes.*;

import repositorios.RepositorioMensajes;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MensajesController {
	public ModelAndView mensajesFront(Request req, Response res) {
RepositorioMensajes repoMensajes = RepositorioMensajes.getInstance();
		
		List<Mensaje> listaMensajes = repoMensajes.buscarMensaje();
		
		return new ModelAndView(listaMensajes, "bandejaMensajes.hbs");
	}
	
public ModelAndView mensajes(Request req, Response res) throws ParseException {
		
		Mensaje unMensaje = new Mensaje();

		String textoMensaje = req.queryParams("textoMensaje");
		String asuntoMensaje = req.queryParams("asuntoMensaje");
		Boolean leido = Boolean.parseBoolean("leido");
		
		
		
		
		unMensaje.setTextoMensaje(textoMensaje) ;
		unMensaje.setAsuntoMensaje(asuntoMensaje) ;
		unMensaje.setLeido(leido);
		
		
		
		


		//RepositorioMensajes.getInstance().persist(unMensaje); averiguar como mostrar

		res.redirect("/");
		return null;
	}	
	
}
