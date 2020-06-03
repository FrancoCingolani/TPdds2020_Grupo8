import constantes.ConstantesTipoDeUsuario;
import main.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class validadorDeTransparenciaTest {

    Compra compra;
    ValidadorDeTransparencia validador;
    List<Presupuesto> presupuestos;
    List<OperacionEgreso> operacionesEgre;
    List<Usuario> revisores;
    Usuario usuario;
    Item item1;
    Item item2;
    List<Item> items;
    Presupuesto presupuestoElegido;
    Presupuesto presupuesto1;
    Presupuesto presupuesto2;
    OperacionEgreso operacionEgreso;
    Proveedor proveedor;
    MedioDePago medioDePago;
    DocumentoComercial documentoComercial;
    List<DocumentoComercial> docsComerciales;

    public void beforeValidadorDeTransparencia() throws IOException {

        proveedor = new Proveedor("asdf 123");
        item1 = new Item("Algo muy barato", 1, 1);
        item2 = new Item("Otra cosa barata", 2, 1);
        items = Arrays.asList(item1, item2);
        documentoComercial = new DocumentoComercial("1","tipo");
        docsComerciales.add(documentoComercial);
        operacionEgreso = new OperacionEgreso(proveedor, new Date(),medioDePago,items,docsComerciales);
        operacionesEgre.add(operacionEgreso);
        presupuestos.add(presupuesto1);
        compra = new Compra(2,presupuestos,operacionesEgre,revisores,items,presupuestoElegido);
        revisores.add(usuario);
        presupuestoElegido = presupuesto1;
        usuario = new Usuario("franco", "lalapapa!", ConstantesTipoDeUsuario.ADMIN);
        validador = new ValidadorDeTransparencia(compra);

    }

}
