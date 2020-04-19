package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Usuario {
	
	String nombre;
	String contrasenia; //Buscar algún algoritmo para hashear la contraseña
	char tipo;
	int intentosMaximos = 3;
	int cantidadIntentos = 0;
	
	public Usuario(String nombre, String contrasenia, char tipo) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.tipo = tipo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public boolean iniciarSesion(String nombre, String contrasenia) {
		if(nombre == this.nombre && contrasenia == this.contrasenia && this.cantidadIntentos < this.intentosMaximos) {
			System.out.println("El usuario se ha logueado exitosamente.");
			return true;
		}else {
			this.cantidadIntentos++;
			return false;
		}
	}
	
	public String validarContrasenia() throws FileNotFoundException, IOException {
		File file = new File("./files/topContraseniasInseguras.txt");  
	    String cadena;
	    FileReader f = new FileReader(file);
	    BufferedReader b = new BufferedReader(f);
	    while((cadena = b.readLine())!=null) {
	    	if(cadena.equals(this.contrasenia)) {
	    		return("Contraseña insegura");
	    	}
	    }
	    b.close();
	    return("Contraseña segura");    
	}


	
	
	

}


