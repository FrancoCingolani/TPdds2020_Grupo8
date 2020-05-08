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
		Usuario usuario = new Usuario("franco", "123456789", ConstantesTipoDeUsuario.ADMIN);
		//usuario.iniciarSesion("franco", "diseno2020!");
		
		// Creación Entidad Jurídica
		EntidadJuridica entidad = new EntidadJuridica("pepe SA", "pepe pateatraseros", "20375512840", "calle falsa 123", 60, Actividad.AGROPECUARIO, TipoEntidadJuridica.EMPRESA);
		
		// Creación items
		Item item1 = new Item("Algo muy barato", 1, 1);
		Item item2 = new Item("Otra cosa barata", 2, 1);
		List<Item> items = Arrays.asList(item1, item2);
		
		Item item3 = new Item("Algo caro", 12890000, 1);
		List<Item> items2 = Arrays.asList(item3);
		
		// Alta proveedor
		Proveedor proveedor = new ProveedorFisico("calle falsa 1234", "Ricardo", "Fort", "12345678", "20123456781");
		
		// Alta medio de pago
		Atm guita = new Atm(3);
		
		// Creación documento comercial
		DocumentoComercial doc = new DocumentoComercial ("1425","ticket");
		List<DocumentoComercial> docs = Arrays.asList(doc);
		
		// Creación operaciones de egreso
		OperacionEgreso operacion = new OperacionEgreso(proveedor, new Date(), guita, items, docs);
		OperacionEgreso operacion2 = new OperacionEgreso(proveedor, new Date(), guita, items2, docs);
		
		// Asociación de operacion de egreso a la entidad
		entidad.agregarOperacionEgreso(operacion);		
		
		// Prueba de categoría
		System.out.println("Prueba sobre Entidad Juridica");
		System.out.println(entidad.getDescripcionCategoria());
		entidad.setPersonal(5); // Disminuyo la cantidad de personal para que recategorice la empresa
		CategorizadorEntidad.categorizar(entidad); // recategorización por cambio de personal
		System.out.println(entidad.getDescripcionCategoria()); // Prueba de categoría
		entidad.agregarOperacionEgreso(operacion2); // Agrego otro item para que suban las ventas y recategorice la empresa	
		CategorizadorEntidad.categorizar(entidad); // recategorización por incremento de ventas
		System.out.println(entidad.getDescripcionCategoria()); // Prueba de categoría
		System.out.println();
		
		// Creación Entidad base
		EntidadBase entidadBase = new EntidadBase("minerita", "minera los hijos de cuca", 18, "donovan y camino general chamizo, gerli", Actividad.INDUSTRIA_Y_MINERIA);
		Item item4 = new Item ("Alto muuuuuuuuuuy caro", 1190330000, 4);
		List<Item> items4 = Arrays.asList(item4);
		OperacionEgreso operacion3 = new OperacionEgreso(proveedor, new Date(), guita, items4, docs);
		System.out.println("Prueba sobre Entidad Base");
		System.out.println(entidadBase.getDescripcionCategoria());
		EntidadJuridica nuevaEntidadAPartirDeBase = new EntidadJuridica(entidadBase, "minera los honestos srl", TipoEntidadJuridica.EMPRESA, "20153456781"); // Reconvierto base a jurídica
		System.out.println(nuevaEntidadAPartirDeBase.getDescripcionCategoria()); // al crearse se recategorizó, tiene que haber cambiado
		nuevaEntidadAPartirDeBase.setPersonal(62); // Aumento la cantidad de personal para que recategorice la empresa
		CategorizadorEntidad.categorizar(nuevaEntidadAPartirDeBase); // recategorización por cambio de personal
		System.out.println(nuevaEntidadAPartirDeBase.getDescripcionCategoria()); // Prueba de categoría
		nuevaEntidadAPartirDeBase.agregarOperacionEgreso(operacion3); // Agrego otro item para que suban las ventas y recategorice la empresa	
		CategorizadorEntidad.categorizar(nuevaEntidadAPartirDeBase); // recategorización por incremento de ventas
		System.out.println(nuevaEntidadAPartirDeBase.getDescripcionCategoria()); // Prueba de categoría
		
	}

}
