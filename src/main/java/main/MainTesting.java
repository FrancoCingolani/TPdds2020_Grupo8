package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import constantes.*;
import enumeradores.*;
import mensajes.*;
import scheduler.*;

public class MainTesting {
	// Lo uso solo para testear el validador por fuera de toda la otra lógica
	public static void main(String[] args) throws InterruptedException, IOException{
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.OFF);
		
		Usuario usuario = new Usuario("franco", "lalapapa!", ConstantesTipoDeUsuario.ADMIN);
		List<Usuario> revisores = Arrays.asList(usuario);
		
      //  Presupuesto presupuestoElegido = presupuesto1;
        
        Item item1 = new Item("Algo muy barato", 1, 1, null);	
		Item item2 = new Item("Otra cosa barata", 2, 1, null);	
		List<Item> items = Arrays.asList(item1, item2);
		
		Proveedor proveedor88 = new Proveedor("asdf 123");
		Presupuesto presupuesto1 = new Presupuesto(proveedor88,"detalle",items,null);
		Presupuesto presupuesto2 = new Presupuesto(proveedor88,"detalle",items,null);
		
		List<Presupuesto> presupuestos = Arrays.asList(presupuesto1);
        
        Compra compra = new Compra(1, presupuestos, null, revisores, items, presupuesto2);
        
        
        // Magia - el scheduler
		ValidadorTransparenciaScheduler.crearSchedulerValidadorTransparencia(compra);
		
    	List<Mensaje> todosLosMensajes = usuario.getMensajes();
    	
    	for (Mensaje msj : todosLosMensajes) {	
    		
			System.out.println("Asunto: " + msj.getAsuntoMensaje() + " - Texto: " + msj.getTextoMensaje());	
		}	

        
	} //CIERRE FUNCION MAIN
} //CIERRE CLASE MAIN
