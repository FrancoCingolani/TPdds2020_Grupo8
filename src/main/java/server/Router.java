package server;

import spark.Request;
import spark.Response;
import spark.Spark;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class Router {
	
	private static void chequearLoginInexistente(Request req, Response res) {
		if (req.session(false) == null) {
			res.redirect("/login");
			Spark.halt();
		}
	}
	
	private static void chequearLoginExistente(Request req, Response res) {
		if (req.session(false) != null) {
			res.redirect("/");
			Spark.halt();
		}
	}
	
	public static void configure() {
		HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();
		Spark.staticFiles.location("/public");
		Spark.init();
		
		/* AC� SE CREAN LOS CONTROLLERS */
		HomeController homeController = new HomeController();
		 
		 
		
		
		//HOME
		Spark.get("/", homeController::pantallaPrincipal, engine);
		
		
		/* ESTO ES SI QUEREMOS QUE EL USUARIO EST� LOGUEADO ANTES DE ACCEDER A LA P�GINA. IR AGREGANDO LAS DISTINTAS P�GINAS QUE HAGAMOS */
		//Spark.before("/", Router::chequearLoginInexistente);
		
		DebugScreen.enableDebugScreen();
	}

}
