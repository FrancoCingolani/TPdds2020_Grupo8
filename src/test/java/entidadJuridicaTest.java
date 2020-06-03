import enumeradores.Actividad;
import enumeradores.TipoEntidadJuridica;
import main.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class entidadJuridicaTest {

    EntidadJuridica entidad;

    Item item1;
    Item item2;
    Item item3;

    List<Item> items;
    List<Item> items2;

    Proveedor proveedor;

    Atm guita;

    // Creación documento comercial
    DocumentoComercial doc = new DocumentoComercial ("1425","ticket");
    List<DocumentoComercial> docs = Arrays.asList(doc);

    // Creación operaciones de egreso
    OperacionEgreso operacion;
    OperacionEgreso operacion2;

    @BeforeClass
    public void beforeEntidadJuridicaTest(){

        entidad = new EntidadJuridica("pepe SA", "pepe pateatraseros", "20375512840", "calle falsa 123", 60, Actividad.AGROPECUARIO, TipoEntidadJuridica.EMPRESA);

        item1 = new Item("Algo muy barato", 1, 1);
        item2 = new Item("Otra cosa barata", 2, 1);
        items = Arrays.asList(item1, item2);

        item3 = new Item("Algo caro", 12890000, 1);
        items2 = Arrays.asList(item3);

        proveedor = new ProveedorFisico("calle falsa 1234", "Ricardo", "Fort", "12345678", "20123456781");
        guita = new Atm(3);

        operacion = new OperacionEgreso(proveedor, new Date(), guita, items, docs);
        operacion2 = new OperacionEgreso(proveedor, new Date(), guita, items2, docs);

        // Asociación de operacion de egreso a la entidad
        entidad.agregarOperacion(operacion);
    }


    @Test
    public void pruebaDeCategoría(){
        System.out.println("Prueba sobre Entidad Juridica");
        System.out.println(entidad.getDescripcionCategoria());
        entidad.setPersonal(5); // Disminuyo la cantidad de personal para que recategorice la empresa
        CategorizadorEntidad.categorizar(entidad); // recategorización por cambio de personal
        System.out.println(entidad.getDescripcionCategoria()); // Prueba de categoría
        entidad.agregarOperacion(operacion2); // Agrego otro item para que suban las ventas y recategorice la empresa
        CategorizadorEntidad.categorizar(entidad); // recategorización por incremento de ventas
        System.out.println(entidad.getDescripcionCategoria()); // Prueba de categoría
        System.out.println();
    }

}
