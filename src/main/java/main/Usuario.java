package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exceptions.ContraseniaCortaException;
import exceptions.ContraseniaInseguraException;

public class Usuario {
	
	String nombre;
	String contrasenia;
	char tipo;
	int intentosMaximos = 3;
	int cantidadIntentos = 0;
	
	MD5Hashing hash = new MD5Hashing();
	
	public Usuario(String nombre, String contrasenia, char tipo) throws FileNotFoundException, IOException {
		this.nombre = nombre;
		this.contrasenia = hash.getMd5(contrasenia);
		this.tipo = tipo;
		
		this.validarContrasenia(contrasenia);
		
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
	
	public String validarContrasenia(String contrasenia) throws FileNotFoundException, IOException {
		
		if(contrasenia.length()<= 8) {
			throw new ContraseniaCortaException();
		}
		
		
		File file = new File("./files/topContraseniasInseguras.txt");  
	    String cadena;
	    FileReader f = new FileReader(file);
	    BufferedReader b = new BufferedReader(f);
	    while((cadena = b.readLine())!=null) {
	    	if(cadena.equals(contrasenia)) {
	    		throw new ContraseniaInseguraException();
	    	}
	    }
	    b.close();
	    System.out.println("Contraseña segura");
		return ("Contraseña segura"); 
	}


	
	
	

}


