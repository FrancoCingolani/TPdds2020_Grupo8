package main;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		Usuario usuario = new Usuario("franco", "123456", 'A');
		//System.out.println(usuario.validarContrasenia());
		
		//MD5Hashing hash = new MD5Hashing();
        //System.out.println("El hash MD5 generado es: " + hash.getMd5(usuario.contrasenia)); 
        //usuario.setContrasenia(hash.getMd5(usuario.contrasenia));
		

		
	}

}
