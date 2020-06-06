package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import constantes.*;
import enumeradores.*;
import mensajes.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
        
        Scanner sn = new Scanner(System.in);
    	boolean salir = false;
    	int opcion;
    	while (!salir) {
    		
    	    System.out.println("1. Crear usuario");
    	    System.out.println("2. Crear organización");
    	    System.out.println("3. Salir");
    	    
    	    try {
    	    	 System.out.println("Escribe una de las opciones:");
    		        opcion = sn.nextInt();
    		      
    		      switch (opcion) {
    		      	case 1:
    		      		System.out.println("Ingresar nombre de usuario: ");
    	                Scanner usuarioElegido = new Scanner(System.in);
    	                String usuario = usuarioElegido.nextLine ();
    	                System.out.println("Ingresar password: ");
    	                Scanner passwordElegida = new Scanner(System.in);
    	                String password = passwordElegida.nextLine ();
    	                Usuario usuarioCreado = new Usuario(usuario, password, ConstantesTipoDeUsuario.ADMIN);
    		      	case 2:
    		      		
    		      }
    	            	
    	    } catch (InputMismatchException e) {
    	        System.out.println("Debes insertar un número");
    	        sn.next();
    	    }

    	}
	}
}
/*  
	EJEMPLO DE OTRO EJERCICIO QUE HICE ANTES
	
	Scanner sn = new Scanner(System.in);
	boolean salir = false;
	int opcion;
	while (!salir) {
	
	    System.out.println("1. Crear evento");
	    System.out.println("2. Ver historial");
	    System.out.println("3. Salir");
	
	    try {
	
	        System.out.println("Escribe una de las opciones:");
	        opcion = sn.nextInt();
	
	        switch (opcion) {
	            case 1:
	            	Usuario usuario = new Usuario(0);
	            	java.util.Date fechaYHoraActual = new java.util.Date();
	                System.out.println("Elegir usuario (1 a 3)");
	                Scanner usuarioSeleccionado = new Scanner(System.in);
	                int opcionUsuario = usuarioSeleccionado.nextInt();
	                if (opcionUsuario <= 3 && opcionUsuario >= 1) {
	                	usuario.setNumUsuario(opcionUsuario);
	                }
	                
	                else {
	                	System.out.println("Usuario inválido");
	                	break;
	                }
	                System.out.println("Elegir boton (Cualquier numero)");
	                Scanner botonSeleccionado = new Scanner(System.in);
	                int opcionBoton = botonSeleccionado.nextInt();
	                Evento evento = new Evento(fechaYHoraActual, usuario, opcionBoton);
	                eventoRepositorio.addEvento(evento);
	                System.out.println("Evento creado. Volviendo al menu principal...");
	                break;
	            case 2:
	            	System.out.println("-------------");
	            	System.out.println("HISTORIAL DE EVENTOS:");
	            	for (Evento e:eventoRepositorio.historialEventos) {
	            		System.out.println("Fecha: "+ e.getFecha());
	            		System.out.println("Usuario: "+ (e.getUsuario().getNumUsuario()));
	            		System.out.println("Opción: "+ e.getOpcion());
	            		System.out.println("-------------");
	            	}
	            	
	                break;
	            case 3:
	            	salir = true;
	            	sn.close();
	                break;
	            default:
	                System.out.println("Solo números entre 1 y 3");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Debes insertar un número");
	        sn.next();
	    }
	}
*/