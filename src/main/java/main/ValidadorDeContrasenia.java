package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

import exceptions.ContraseniaCaracteresRepetidosException;
import exceptions.ContraseniaCortaException;
import exceptions.ContraseniaInseguraException;
import exceptions.ContraseniaUnicodeException;

import java.nio.charset.Charset;

public class ValidadorDeContrasenia {
	
	private static ValidadorDeContrasenia instance;
	
	private ValidadorDeContrasenia() {
	}
	
	public static ValidadorDeContrasenia getInstance() {
		if(instance == null) {
			instance = new ValidadorDeContrasenia();
		}
		return instance;
	}
	
	public static boolean isPureAscii(String v) {
	    return Charset.forName("US-ASCII").newEncoder().canEncode(v);
	    // or "ISO-8859-1" for ISO Latin 1
	    // or StandardCharsets.US_ASCII with JDK1.7+
	  }
	
	public void validar(String contrasenia) throws FileNotFoundException, IOException {
		
		
		if((contrasenia.length()<= 8) && (contrasenia.length()<= 64)) {
			throw new ContraseniaCortaException();
		}
		
		if(ValidadorDeContrasenia.isPureAscii(contrasenia) == false) {
			throw new ContraseniaUnicodeException();	
		}
		
		Pattern pattern = Pattern.compile("(.)\\1\\1", Pattern.CASE_INSENSITIVE);
		
		Matcher m = pattern.matcher(contrasenia);
		
		if (m.find()) {
			throw new ContraseniaCaracteresRepetidosException();
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
	}

}
