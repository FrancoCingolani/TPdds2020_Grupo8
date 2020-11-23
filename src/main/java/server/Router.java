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
		
		/* ACÁ SE CREAN LOS CONTROLLERS */
		HomeController homeController = new HomeController();
		LoginController loginController = new LoginController();
		OperacionEgresoController operacionEgresoController = new OperacionEgresoController();
		OperacionIngresoController operacionIngresoController = new OperacionIngresoController();
		ProyectoController proyectoController = new ProyectoController();
		AsociarEgreIngreController asociarEgreIngreController = new AsociarEgreIngreController();
		AuditoriaController auditoriaController = new AuditoriaController();
		ClasificadorController clasificadorController = new ClasificadorController();
		MensajesController mensajesController = new MensajesController();
		VisualizadorController visualizadorController = new VisualizadorController();
		
		
		//HOME
		Spark.get("/", homeController::pantallaPrincipal, engine);
		//LOG IN USUARIIOS
		Spark.get("/login",
				loginController::loginFront, 
				new HandlebarsTemplateEngine());
		
		Spark.post("/login",
				loginController::login, 
				new HandlebarsTemplateEngine());
		
		Spark.post("/logout",
				loginController::logout, 
				new HandlebarsTemplateEngine());
		
		// ALTA DE OPERACIONES EGRESO
				Spark.get("/operacionesEgreso",
						operacionEgresoController::altaOpEgresoFront, 
						new HandlebarsTemplateEngine());
				
				Spark.post("/operacionesEgreso",
						operacionEgresoController::altaOpEgreso, 
						new HandlebarsTemplateEngine());
		
		// ALTA DE OPERACIONES INGRESO
				Spark.get("/operacionesIngreso",
						operacionIngresoController::altaOpIngresoFront, 
						new HandlebarsTemplateEngine());
				
				Spark.post("/operacionesIngreso",
						operacionIngresoController::altaOpIngreso, 
						new HandlebarsTemplateEngine());
		// ALTA DE OPERACIONES PROYECTO
				Spark.get("/proyecto",
						proyectoController::altaProyecto, 
						new HandlebarsTemplateEngine());
				
		// VISUALIZAR OPERACIONES Y PROYECTOS
				Spark.get("/visualizador",
						visualizadorController::visualizador, 
						new HandlebarsTemplateEngine());
			
		// ASOCIAR OPERACIONES
				Spark.get("/asociar",
						asociarEgreIngreController::asociarEgreIngre, 
						new HandlebarsTemplateEngine());
						
			// ADUTORIA
				Spark.get("/auditoria",
						auditoriaController::auditoria, 
						new HandlebarsTemplateEngine());			
			
		// CLASIFICADOR
				Spark.get("/clasificador",
						clasificadorController::clasificador, 
						new HandlebarsTemplateEngine());
						
		//BANDEJA DE MENSAJES
				Spark.get("/mensajes",
						mensajesController::mensajes, 
						new HandlebarsTemplateEngine());
				
				
		/* ESTO ES SI QUEREMOS QUE EL USUARIO ESTÉ LOGUEADO ANTES DE ACCEDER A LA PÁGINA. IR AGREGANDO LAS DISTINTAS PÁGINAS QUE HAGAMOS */
		//Spark.before("/", Router::chequearLoginInexistente);
		
		DebugScreen.enableDebugScreen();
	}

}
