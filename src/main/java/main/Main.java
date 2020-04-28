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
		
		/*Usuario usuario = new Usuario("franco", "diseno2020!", 'A');
		int a = ConstantesCategorizacion.PERSONAL_CONSTRUCCION_PEQUEÑA;
		System.out.println(a);
		usuario.iniciarSesion("franco", "diseno2020!");*/
		EntidadJuridica entidad = new EntidadJuridica("pepe SA", "pepe pateatraseros", 20375512840L, "calle falsa 123", 60, Actividad.AGROPECUARIO, TipoEntidadJuridica.EMPRESA);
		
		Item item1 = new Item("Algo muy barato", 1);
		Item item2 = new Item("Otra cosa barata", 2);
		List<Item> items = Arrays.asList(item1, item2);
		
		Item item3 = new Item("Algo caro", 12890000);
		List<Item> items2 = Arrays.asList(item3);
		
		Proveedor proveedor = new Proveedor("jose", "Perez", "jose SA", 123456);
		
		Atm guita = new Atm();
		
		DocumentoComercial doc = new DocumentoComercial("ticket");
		
		OperacionEgreso operacion = new OperacionEgreso(proveedor, new Date(), guita, items, doc);
		OperacionEgreso operacion2 = new OperacionEgreso(proveedor, new Date(), guita, items2, doc);
		
		entidad.agregarOperacionEgreso(operacion);		
		
		System.out.println(entidad.getDescripcionCategoria());
		entidad.setPersonal(5); // Disminuyo la cantidad de personal para que recategorice la empresa
		entidad.categorizar();
		System.out.println(entidad.getDescripcionCategoria());
		entidad.agregarOperacionEgreso(operacion2); // Agrego otro item para que suban las ventas y recategorice la empresa	
		entidad.categorizar();
		System.out.println(entidad.getDescripcionCategoria());
	}

}
