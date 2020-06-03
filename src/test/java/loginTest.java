import constantes.ConstantesTipoDeUsuario;
import main.Usuario;
import org.junit.Test;

import java.io.IOException;

public class loginTest {
    @Test
    public void loginCorrecto() throws IOException {
        // Prueba creación de usuario e inicio de sesión
        Usuario usuario = new Usuario("franco", "lalapapa!", ConstantesTipoDeUsuario.ADMIN);
        usuario.iniciarSesion("franco", "diseno2020!");
    }
}
