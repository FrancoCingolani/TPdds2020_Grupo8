package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import constantes.*;
import enumeradores.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		// Prueba creación de usuario e inicio de sesión
		Usuario usuario = new Usuario("franco", "diseno2020!", 'A');
		usuario.iniciarSesion("franco", "diseno2020!");
		
		// Creación Entidad Jurídica
		EntidadJuridica entidad = new EntidadJuridica("pepe SA", "pepe pateatraseros", 20375512840L, "calle falsa 123", 60, Actividad.AGROPECUARIO, TipoEntidadJuridica.EMPRESA);
		
		// Creación items
		Item item1 = new Item("Algo muy barato", 1);
		Item item2 = new Item("Otra cosa barata", 2);
		List<Item> items = Arrays.asList(item1, item2);
		
		Item item3 = new Item("Algo caro", 12890000);
		List<Item> items2 = Arrays.asList(item3);
		
		// Alta proveedor
		Proveedor proveedor = new Proveedor("jose", "Perez", "jose SA", 123456);
		
		// Alta medio de pago
		Atm guita = new Atm();
		
		// Creación documento comercial
		DocumentoComercial doc = new DocumentoComercial("ticket");
		
		// Creación operaciones de egreso
		OperacionEgreso operacion = new OperacionEgreso(proveedor, new Date(), guita, items, doc);
		OperacionEgreso operacion2 = new OperacionEgreso(proveedor, new Date(), guita, items2, doc);
		
		// Asociación de operacion de egreso a la entidad
		entidad.agregarOperacionEgreso(operacion);		
		
		// Prueba de categoría
		System.out.println(entidad.getDescripcionCategoria());
		entidad.setPersonal(5); // Disminuyo la cantidad de personal para que recategorice la empresa
		entidad.categorizar(); // recategorización por cambio de personal
		System.out.println(entidad.getDescripcionCategoria()); // Prueba de categoría
		entidad.agregarOperacionEgreso(operacion2); // Agrego otro item para que suban las ventas y recategorice la empresa	
		entidad.categorizar(); // recategorización por incremento de ventas
		System.out.println(entidad.getDescripcionCategoria()); // Prueba de categoría
	}

}
