import enumeradores.Actividad;
import enumeradores.TipoEntidadJuridica;
import main.*;
import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class entidadBaseTest {

    EntidadBase entidadBase;
    Item item;
    List<Item> items;
    OperacionEgreso operacion;
    Proveedor proveedor;
    Atm guita;
    List<DocumentoComercial> docsComerciales;
    DocumentoComercial docComercial;

    @BeforeClass
    public void beforeEntidadBaseTest(){
        entidadBase = new EntidadBase("minerita", "minera los hijos de cuca", 18, "donovan y camino general chamizo, gerli", Actividad.INDUSTRIA_Y_MINERIA);
        item = new Item ("Alto muuuuuuuuuuy caro", 1190330000, 4);
        proveedor = new Proveedor("asdf 1234");
        guita = new Atm(3);
        items = Arrays.asList(item);
        docComercial = new DocumentoComercial("12","tipo");
        docsComerciales.add(docComercial);
        operacion = new OperacionEgreso(proveedor, new Date(), guita, items, docsComerciales);
    }

    public void reconviertoBaseAJurídica(){
        System.out.println(entidadBase.getDescripcionCategoria());
        EntidadJuridica nuevaEntidadAPartirDeBase = new EntidadJuridica(entidadBase, "minera los honestos srl", TipoEntidadJuridica.EMPRESA, "20153456781"); // Reconvierto base a jurídica
        System.out.println(nuevaEntidadAPartirDeBase.getDescripcionCategoria()); // al crearse se recategorizó, tiene que haber cambiado
        nuevaEntidadAPartirDeBase.setPersonal(62); // Aumento la cantidad de personal para que recategorice la empresa
        CategorizadorEntidad.categorizar(nuevaEntidadAPartirDeBase); // recategorización por cambio de personal
        System.out.println(nuevaEntidadAPartirDeBase.getDescripcionCategoria()); // Prueba de categoría
        nuevaEntidadAPartirDeBase.agregarOperacion(operacion); // Agrego otro item para que suban las ventas y recategorice la empresa
        CategorizadorEntidad.categorizar(nuevaEntidadAPartirDeBase); // recategorización por incremento de ventas
        System.out.println(nuevaEntidadAPartirDeBase.getDescripcionCategoria()); // Prueba de categoría
    }





}
