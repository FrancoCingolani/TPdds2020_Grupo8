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
    		      		System.out.println("Ingrese nombre de usuario: ");
    	                Scanner usuarioElegido = new Scanner(System.in);
    	                String usuario = usuarioElegido.nextLine ();
    	                System.out.println("Ingresar password: ");
    	                Scanner passwordElegida = new Scanner(System.in);
    	                String password = passwordElegida.nextLine ();
    	                Usuario usuarioCreado = new Usuario(usuario, password, ConstantesTipoDeUsuario.ADMIN);
    		      	case 2:
    		      		System.out.println("Elige el tipo de Organización: ");
    		      		System.out.println("1. Entidad base");
    		    	    System.out.println("2. Entidad jurídica");
    	                Scanner tipoOrganizacionElegido = new Scanner(System.in);
    	                int opcionOrganizacion = tipoOrganizacionElegido.nextInt();
    	                
    	                if(opcionOrganizacion == 1) { //ENTIDAD BASE
    	                	System.out.println("Ingrese el nombre de la organización: ");
    	                	Scanner nombreElegido = new Scanner(System.in);
        	                String nombreOrganizacion = nombreElegido.nextLine ();
        	                System.out.println("Ingrese la descripción: ");
    	                	Scanner descripcionElegida = new Scanner(System.in);
        	                String descripcionOrganizacion = descripcionElegida.nextLine ();
        	                System.out.println("Cantidad de personal: ");
        	                Scanner personalSeleccionado = new Scanner(System.in);
        	                int personalOrganizacion = personalSeleccionado.nextInt();
        	                System.out.println("Dirección postal: ");
    	                	Scanner direccionElegida = new Scanner(System.in);
        	                String direccionOrganizacion = direccionElegida.nextLine ();
        	                System.out.println("Elegir tipo de actividad: ");
        	                System.out.println("1. Construcción");
        		    	    System.out.println("2. Servicio");
        		    	    System.out.println("3. Comercio");
        		    	    System.out.println("4. Industriamineria");
        		    	    System.out.println("5. Agropecuario");
        		    	    Scanner actividadSeleccionada = new Scanner(System.in);
        	                int actividad = actividadSeleccionada.nextInt();
        	                Actividad actividadOrganizacion = null;
        	                switch (actividad) {
        	                	case 1: actividadOrganizacion = Actividad.CONSTRUCCION;
        	                	break;
        	                	case 2: actividadOrganizacion = Actividad.SERVICIOS;
        	                	break;
        	                	case 3: actividadOrganizacion = Actividad.COMERCIO;
        	                	break;
        	                	case 4: actividadOrganizacion = Actividad.INDUSTRIA_Y_MINERIA;
        	                	break;
        	                	case 5: actividadOrganizacion = Actividad.AGROPECUARIO;
        	                	break;
        	                }
        	                EntidadBase entidadBase = new EntidadBase(nombreOrganizacion, descripcionOrganizacion, personalOrganizacion, direccionOrganizacion, actividadOrganizacion);
        	                System.out.println("Entidad base creada exitosamente");
    	                }else if(opcionOrganizacion == 2) {
    	                	System.out.println("Ingrese la razón social: ");
    	                	Scanner razonSocialElegida = new Scanner(System.in);
        	                String razonSocialOrganizacion = razonSocialElegida.nextLine ();
        	                System.out.println("Ingrese el nombre ficticio: ");
    	                	Scanner nombreElegido = new Scanner(System.in);
        	                String nombreOrganizacion = nombreElegido.nextLine ();
        	                System.out.println("CUIT: ");
        	                Scanner cuitElegido = new Scanner(System.in);
        	                String cuitOrganizacion = nombreElegido.nextLine ();
        	                System.out.println("Dirección postal: ");
    	                	Scanner direccionElegida = new Scanner(System.in);
        	                String direccionOrganizacion = direccionElegida.nextLine ();
        	                System.out.println("Cantidad de personal: ");
        	                Scanner personalSeleccionado = new Scanner(System.in);
        	                int personalOrganizacion = personalSeleccionado.nextInt();
        	                System.out.println("Elegir tipo de actividad: ");
        	                System.out.println("1. Construcción");
        		    	    System.out.println("2. Servicio");
        		    	    System.out.println("3. Comercio");
        		    	    System.out.println("4. Industriamineria");
        		    	    System.out.println("5. Agropecuario");
        		    	    Scanner actividadSeleccionada = new Scanner(System.in);
        	                int actividad = actividadSeleccionada.nextInt();
        	                Actividad actividadOrganizacion = null;
        	                switch (actividad) {
        	                	case 1: actividadOrganizacion = Actividad.CONSTRUCCION;
        	                	break;
        	                	case 2: actividadOrganizacion = Actividad.SERVICIOS;
        	                	break;
        	                	case 3: actividadOrganizacion = Actividad.COMERCIO;
        	                	break;
        	                	case 4: actividadOrganizacion = Actividad.INDUSTRIA_Y_MINERIA;
        	                	break;
        	                	case 5: actividadOrganizacion = Actividad.AGROPECUARIO;
        	                	break;
        	                }
        	                System.out.println("Elegir tipo de entidad jurídica: ");
        	                System.out.println("1. Empresa");
        		    	    System.out.println("2. OSC");
        	                Scanner tipoEntidadJurSeleccionada = new Scanner(System.in);
        	                int tipoEntidadJur = tipoEntidadJurSeleccionada.nextInt();
        	                TipoEntidadJuridica tipoEntidadJuridica = null;
        	                switch (tipoEntidadJur) {
        	                	case 1: tipoEntidadJuridica = TipoEntidadJuridica.EMPRESA;
        	                	break;
        	                	case 2: tipoEntidadJuridica = TipoEntidadJuridica.OSC;
        	                	break;
        	                }
        	                EntidadJuridica entidadJuridica = new EntidadJuridica(razonSocialOrganizacion, nombreOrganizacion, cuitOrganizacion, direccionOrganizacion, personalOrganizacion, actividadOrganizacion, tipoEntidadJuridica);
        	                System.out.println("Entidad jurídica creada exitosamente");
    	                }
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