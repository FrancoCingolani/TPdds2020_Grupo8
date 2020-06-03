import constantes.ConstantesTipoDeUsuario;
import main.Usuario;
import mensajes.Mensaje;
import mensajes.MensajeValidadorCompra;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class mensajesTest {

    private static Usuario usuario;

    static {
        try {
            usuario = new Usuario("franco", "lalapapa!", ConstantesTipoDeUsuario.ADMIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // por ahora es el único tipo de mensaje, por eso se usa este para probar
    Mensaje mensaje1 = new MensajeValidadorCompra("Prueba de mensaje numero 1");
    Mensaje mensaje2 = new MensajeValidadorCompra("Prueba de mensaje numero 2");

    @BeforeClass
    public static void beforeMensajesTest() throws IOException {
        usuario.iniciarSesion("franco", "diseno2020!");
    }

    @Test
    public void creacionDeMensaje(){
        // envío el mensaje a la bandeja de entrada del usuario
		usuario.recibirMensaje(mensaje1);

        List<Mensaje> todosLosMensajes = usuario.getMensajes();
        // tengo solo el mensaje 1
        assert(todosLosMensajes.contains(mensaje1));

        /*
		System.out.println("Prueba sobre mensajes - TODOS");
		for (Mensaje msj : todosLosMensajes) {
            System.out.println("Asunto: " + msj.getAsuntoMensaje() + " - Texto: " + msj.getTextoMensaje());
        } */

		usuario.recibirMensaje(mensaje2); // envío el mensaje a la bandeja de entrada del usuario
        todosLosMensajes = usuario.getMensajes();  // Tengo mensaje 1 y 2

        assert(todosLosMensajes.contains(mensaje1)&&todosLosMensajes.contains(mensaje2));
		/*System.out.println("Prueba sobre mensajes - TODOS");
		for (Mensaje msj : todosLosMensajes) {
            System.out.println("Asunto: " + msj.getAsuntoMensaje() + " - Texto: " + msj.getTextoMensaje());
        }*/

		mensaje1.leerMensaje(); // Lo marco como leído

        todosLosMensajes = usuario.getMensajes();  // Tengo mensaje 1 y 2
        List<Mensaje> mensajesLeidos = usuario.getMensajesNoLeidos(); // Tengo solo mensaje 2

        assert(mensajesLeidos.contains(mensaje2));
		/*
        System.out.println("Prueba sobre mensajes - TODOS");
		for (Mensaje msj : todosLosMensajes) {
		    System.out.println("Asunto: " + msj.getAsuntoMensaje() + " - Texto: " + msj.getTextoMensaje());
        }*/

        assert(!mensajesLeidos.contains(mensaje1));
		/*System.out.println("Prueba sobre mensajes - SIN LEER");
		for (Mensaje msj : mensajesLeidos) {
            System.out.println("Asunto: " + msj.getAsuntoMensaje() + " - Texto: " + msj.getTextoMensaje());
        }*/

    }
}
