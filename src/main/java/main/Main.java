package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import constantes.ConstantesCategorizacion;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		Usuario usuario = new Usuario("franco", "diseno2020!", 'A');
		/*int a = ConstantesCategorizacion.PERSONAL_CONSTRUCCION_PEQUEÑA;
		System.out.println(a);*/
		usuario.iniciarSesion("franco", "diseno2020!");
	
	}

}
