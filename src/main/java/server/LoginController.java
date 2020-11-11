package server;

/*import java.util.HashMap;

import domain.repos.RepositorioUsuarios;
import domain.usuario.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {
	
	private static final HashMap<String, Object> badLoginResponsePayload = new HashMap<String, Object>() {
		private static final long serialVersionUID = 1L;
		{
			put("feedback", "Usuario o contraseña invalidas");
		}
	}; 

	public ModelAndView getLoginPage(Request req, Response res) {
		return new ModelAndView(new HashMap<>(), "login.hbs");
	}

	public ModelAndView login(Request req, Response res) {
		/*
		 * //Usuarie usuarie = RepositorioUsuaries.buscarPorNombre(req.params("user"))
		 * //si no existe, lanzar excepcion Usuario usuario = new Usuario("foo", "foo");
		 * usuario.validarContrasenia(req.queryParams("pass"));
		 * 
		 * 
		 * res.cookie("uid", usuario.getId().toString());
		 * 
		 * // redirijan al perfil res.redirect("/guardarropas"); return null;
		 
		String nombreUsuario = req.queryParams("usuario");
		String password = req.queryParams("contrasenia");
		System.out.println("Alguien se quiso loguear con usuario " + nombreUsuario + " y contrasenia " + password);

		Usuario usuario = RepositorioUsuarios.instance().findUsuario(nombreUsuario);
		
		if( usuario == null ) {
			return new ModelAndView(badLoginResponsePayload, "login.hbs");
		}

		// System.out.println(usuario2);

		if (usuario.password.equals(password)) {
			System.out.println("Login exitoso");
			req.session(true);
			req.session().attribute("user", nombreUsuario);
			res.redirect("/guardarropas");
		} else {
			return new ModelAndView(badLoginResponsePayload, "login.hbs");
		}

		return null;
	}

	public ModelAndView logout(Request req, Response res) {
		req.session().invalidate();
		res.redirect("/");
		return null;
	}

}
*/