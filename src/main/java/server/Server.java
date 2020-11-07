package server;

import server.Router;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void iniciar() {
		String port = System.getenv("PORT");
		Spark.port(port == null ? 8010 : Integer.parseInt(port));
		Router.configure();
		DebugScreen.enableDebugScreen();
		Spark.init();
	}

}
