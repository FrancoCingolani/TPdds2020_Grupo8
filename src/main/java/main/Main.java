package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
    	    System.out.println("3.Agregar compra");
    	    System.out.println("4. Salir");
    	    
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

    		      	case 3:
    		      		System.out.println("Ingrese la cantidad de presupuestos necesarios ");
    	                Scanner cantElegida = new Scanner(System.in);
    	                int cantPresu = cantElegida.nextInt ();
    	                List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
    	                Presupuesto presupuestoElegido = null;

    	                if(cantPresu>0) {
    	                	for(int i=0; i< cantPresu; i++) {
    	                		System.out.println("Ingrese el detalle del presupuesto:");
    	        	            Scanner descElegido = new Scanner(System.in);
    	        	            String unDetalle = descElegido.nextLine ();
    	        	            System.out.println("Ingrese la cantidad de tipos de items:");
	        	                Scanner cantElegidaItems = new Scanner(System.in);
	        	                int cantItems = cantElegidaItems.nextInt ();
	        	                List<Item> unosItems = new ArrayList<Item>();
	        	                while(cantItems>0) {
	        	                	System.out.println("Informacion del item...");
	        	                	System.out.println("Ingrese la descripcion del item:");
	    	        	            Scanner descripcionElegido = new Scanner(System.in);
	    	        	            String laDescripcion = descripcionElegido.nextLine ();
	    	        	            System.out.println("Ingrese el valor:");
    	        	                Scanner precio = new Scanner(System.in);
    	        	                int elValor = precio.nextInt ();
    	        	                System.out.println("Ingrese la cantidad de este producto:");
    	        	                Scanner amount = new Scanner(System.in);
    	        	                int laCantidad = amount.nextInt ();
	        	                	Item unItem = new Item (laDescripcion, elValor, laCantidad);
	        	                	unosItems.add(unItem);
	        	                	cantItems --;
	        	                }    
	        	                System.out.println("Ingrese la cantidad de documentos:");
	        	                Scanner cantElegidaDocs = new Scanner(System.in);
	        	                int cantDocEle = cantElegidaDocs.nextInt ();
	        	                List<DocumentoComercial> unosDocumentos = new ArrayList<DocumentoComercial>();
	        	                while(cantDocEle>0) {
	        	                	System.out.println("Informacion del documento...");
	        	                	System.out.println("Ingrese el numero del documento:");
	    	        	            Scanner numeroChosen = new Scanner(System.in);
	    	        	            String unNDoc = numeroChosen.nextLine ();
	    	        	            System.out.println("Ingrese el tipo del documento:");
	    	        	            Scanner tipoElegido = new Scanner(System.in);
	    	        	            String unTipo = tipoElegido.nextLine ();
	        	                	DocumentoComercial unDocumento = new DocumentoComercial( unNDoc, unTipo);
	        	                	unosDocumentos.add(unDocumento);
	        	                	cantDocEle --;
	        	                }
    	        	            
    	                		 System.out.println("Elegir el tipo de proveedor:");
    	                	     System.out.println("1. Fisico");
    	                	     System.out.println("2. Juridica");
    	        	             Scanner tipoProveSeleccionada = new Scanner(System.in);
    	        	                int tipoProveedor = tipoProveSeleccionada.nextInt();
    	        	                if (tipoProveedor == 1) {
    	        	                
	    	        	                System.out.println("Ingrese el nombre del proveedor:");
	    	        	                Scanner nombreElegido = new Scanner(System.in);
	    	        	                String unNombre = nombreElegido.nextLine ();
	    	        	                System.out.println("Ingrese el apellido del proveedor:");
	    	        	                Scanner apellidoElegido = new Scanner(System.in);
	    	        	                String unApellido = apellidoElegido.nextLine ();
	    	        	                System.out.println("Ingrese la direccion del proveedor:");
	    	        	                Scanner direccionElegido = new Scanner(System.in);
	    	        	                String unDireccionPostal = direccionElegido.nextLine ();
	    	        	                System.out.println("Ingrese el DNI del proveedor:");
	    	        	                Scanner dniElegido = new Scanner(System.in);
	    	        	                String unDni = dniElegido.nextLine ();
	    	        	                System.out.println("Ingrese el CUIL del proveedor:");
	    	        	                Scanner cuilElegido = new Scanner(System.in);
	    	        	                String unCuil = cuilElegido.nextLine ();
	    	        	                ProveedorFisico unProveedor = new ProveedorFisico(unDireccionPostal, unNombre,  unApellido, unDni, unCuil);
	    	        	                Presupuesto unPresupuesto = new Presupuesto(unProveedor, unDetalle, unosItems, unosDocumentos);
	    	        	                presupuestos.add(unPresupuesto);
	    	        	                System.out.println("¿Es el presupuesto que se ha elegido al final? (Y/N)"); //Muy groncho, pero efectivo
	    	        	                Scanner alfinal = new Scanner(System.in);
	    	        	                String fueELegido = alfinal.nextLine ();
	    	        	                if(fueELegido == "Y") {
	    	        	                	presupuestoElegido = unPresupuesto;
	    	        	                }
	    	        	             }else if(tipoProveedor == 2) {
    	        	                
    	        	                	System.out.println("Ingrese la razon social del proveedor:");
	    	        	                Scanner razonElegido = new Scanner(System.in);
	    	        	                String unRazonSocial = razonElegido.nextLine ();
    	        	                	System.out.println("Ingrese la direccion del proveedor:");
	    	        	                Scanner direccioNElegido = new Scanner(System.in);
	    	        	                String unaDireccionPostal = direccioNElegido.nextLine ();
	    	        	                System.out.println("Ingrese el CUIT del proveedor:");
	    	        	                Scanner cuitElegido = new Scanner(System.in);
	    	        	                String unCuit = cuitElegido.nextLine ();
    	        	                	ProveedorJuridico otroProveedor = new ProveedorJuridico(unaDireccionPostal, unRazonSocial, unCuit);
    	        	                	Presupuesto otroPresupuesto = new Presupuesto(otroProveedor, unDetalle, unosItems, unosDocumentos);
    	        	                	presupuestos.add(otroPresupuesto);
    	        	                	System.out.println("¿Es el presupuesto que se ha elegido al final?  (Y/N)");//Muy groncho, pero efectivo
	    	        	                Scanner ufinal = new Scanner(System.in);
	    	        	                String fuELegido = ufinal.nextLine ();
	    	        	                if(fuELegido == "Y") {
	    	        	                	presupuestoElegido = otroPresupuesto;
	    	        	                }
    	        	                }
    	        	               	                		
    	                	}
    	                	
    	                }

    	                //Ahora las operaciones egreso, por fin
    	                System.out.println("Ingrese la cantidad de operaciones Egreso: ");
    	                Scanner cantaElegida = new Scanner(System.in);
    	                int cantOE = cantaElegida.nextInt ();
    	                List<OperacionEgreso> operacionesEgreso = new ArrayList<OperacionEgreso>();
    	                if(cantOE>0) {
    	                	for(int i=0; i< cantOE; i++) {
    	                		 System.out.println("Ingrese la cantidad de tipos de items:");
 	        	                Scanner amountElegidaItems = new Scanner(System.in);
 	        	                int cantItems = amountElegidaItems.nextInt ();
 	        	                List<Item> variosItems = new ArrayList<Item>();;
 	        	                
 	        	                while(cantItems>0) {
 	        	                	System.out.println("Informacion del item...");
 	        	                	System.out.println("Ingrese la descripcion del item:");
 	    	        	            Scanner descripcioNElegido = new Scanner(System.in);
 	    	        	            String laDescripcion = descripcioNElegido.nextLine ();
 	    	        	            System.out.println("Ingrese el valor:");
     	        	                Scanner price = new Scanner(System.in);
     	        	                int elValor = price.nextInt ();
     	        	                System.out.println("Ingrese la cantidad de este producto:");
     	        	                Scanner cantiddd = new Scanner(System.in);
     	        	                int laCantidad = cantiddd.nextInt ();
 	        	                	Item unItem = new Item (laDescripcion, elValor, laCantidad);
 	        	                	variosItems.add(unItem);
 	        	                	cantItems --;
 	        	                }//FIN ITEMS
 	        	               System.out.println("Ingrese la cantidad de documentos:");
	        	                Scanner cantDocumen = new Scanner(System.in);
	        	                int cantDocEle = cantDocumen.nextInt ();
	        	                List<DocumentoComercial> losDocumentosComerciales = new ArrayList<DocumentoComercial>();
	        	                while(cantDocEle>0) {
	        	                	System.out.println("Informacion del documento...");
	        	                	System.out.println("Ingrese el numero del documento:");
	    	        	            Scanner numeroChosen = new Scanner(System.in);
	    	        	            String unNDoc = numeroChosen.nextLine ();
	    	        	            System.out.println("Ingrese el tipo del documento:");
	    	        	            Scanner tipoElegido = new Scanner(System.in);
	    	        	            String unTipo = tipoElegido.nextLine ();
	        	                	DocumentoComercial unDocumento = new DocumentoComercial( unNDoc, unTipo);
	        	                	losDocumentosComerciales.add(unDocumento);
	        	                	cantDocEle --;
	        	                }//FIN DOCS

	        	                 System.out.println("Elegir el medio de pago:");
	   	                	     System.out.println("1. Tarjeta de credito");
	   	                	     System.out.println("2. Tarjeta de debito");
	   	                	     System.out.println("3. Ticket");	
	   	                	     System.out.println("4. Atm");
	   	                	     System.out.println("5. Dinero en cuenta");
	   	                	     Scanner medioPagoSeleccionada = new Scanner(System.in);
	   	                	     int MPSeleccionado = medioPagoSeleccionada.nextInt();
	   	                	     
	   	                	     MedioDePago elMedioDePago = null;

	   	                	     if(MPSeleccionado == 1) {
	   	                   	    	System.out.println("Ingrese el numero de la tarjeta:");
    	        	                Scanner numTar = new Scanner(System.in);
    	        	                String numeroTarjeta = numTar.nextLine ();
    	        	                System.out.println("Ingrese el codigo de seguridad:");
    	        	                Scanner codSg = new Scanner(System.in);
    	        	                String codigoSeguridad = codSg.nextLine ();
    	        	                System.out.println("Ingrese el anio, luego el mes y finalmente la fecha de vencimiento de la tarjeta:");
    	        	                Scanner anito = new Scanner(System.in);
    	        	                int anio = anito.nextInt();
    	        	                Scanner mesito = new Scanner(System.in);
    	        	                int mes = mesito.nextInt();
    	        	                Scanner dia = new Scanner(System.in);
    	        	                int fecha = dia.nextInt();
    	        	                Date fechaExpiracion = new Date(anio, mes,fecha);
    	        	                System.out.println("Ingrese el nombre del duenio:");
    	        	                Scanner xx = new Scanner(System.in);
    	        	                String duenioNombre = xx.nextLine ();
    	        	                System.out.println("Ingrese el numero de identificacion del duenio:");
    	        	                Scanner xxx = new Scanner(System.in);
    	        	                String duenioNroIdentificacion = xxx.nextLine ();
    	        	                System.out.println("Ingrese el tipo de esta identificacion:");
    	        	                Scanner xxxx = new Scanner(System.in);
    	        	                String duenoTipoIdentificacion = xxxx.nextLine ();
	   	                	    	elMedioDePago = new TarjetaDeCredito( numeroTarjeta, codigoSeguridad, fechaExpiracion, duenioNombre, duenioNroIdentificacion,  duenoTipoIdentificacion);
	   	                	     }
		   	                	  if(MPSeleccionado == 2) {
		   	                   	    System.out.println("Ingrese el numero de la tarjeta:");
	  	        	                Scanner numTar = new Scanner(System.in);
	  	        	                String elNumero = numTar.nextLine ();
	  	        	                System.out.println("Ingrese el codigo de seguridad:");
	  	        	                Scanner y = new Scanner(System.in);
	  	        	                String elCodigoSeguridad = y.nextLine ();
	  	        	                System.out.println("Ingrese el anio, luego el mes y finalmente la fecha de vencimiento de la tarjeta:");
	  	        	                Scanner anito = new Scanner(System.in);
	  	        	                int anio = anito.nextInt();
	  	        	                Scanner mesito = new Scanner(System.in);
	  	        	                int mes = mesito.nextInt();
	  	        	                Scanner dia = new Scanner(System.in);
	  	        	                int fecha = dia.nextInt();
	  	        	                Date laFechaExpiracion = new Date(anio, mes,fecha);
	  	        	                System.out.println("Ingrese el nombre del duenio:");
	  	        	                Scanner xx = new Scanner(System.in);
	  	        	                String elDuenioNombre = xx.nextLine ();
	  	        	                System.out.println("Ingrese el numero de identificacion del duenio:");
	  	        	                Scanner xxx = new Scanner(System.in);
	  	        	                String elDuenioNroIdentificacion = xxx.nextLine ();
	  	        	                System.out.println("Ingrese el tipo de esta identificacion:");
	  	        	                Scanner xxxx = new Scanner(System.in);
	  	        	                String elDuenoTipoIdentificacion = xxxx.nextLine ();
		   	                	    elMedioDePago = new TarjetaDeDebito(elNumero,  elCodigoSeguridad, laFechaExpiracion, elDuenioNombre,  elDuenioNroIdentificacion, elDuenoTipoIdentificacion);
		   	                	     }
		   	                	  if(MPSeleccionado ==3) {
		   	                		System.out.println("Ingrese el numero para el Cajero:");
	  	        	                Scanner cajeroNUM = new Scanner(System.in);
	  	        	                String numeroParaCajero = cajeroNUM.nextLine ();
	  	        	                System.out.println("Ingrese el codigo de barras:");
	  	        	                Scanner y = new Scanner(System.in);
	  	        	                long codigoBarras = y.nextLong ();
		   	                	  	elMedioDePago = new Ticket( numeroParaCajero, codigoBarras);
		   	                	  }
		   	                	  if(MPSeleccionado ==4) {
		   	                		System.out.println("Ingrese el numero de link pagos:");
	  	        	                Scanner nLP = new Scanner(System.in);
	  	        	                int linkPagos = nLP.nextInt ();
		   	                	  	elMedioDePago = new Atm(linkPagos);
		   	                	  }
		   	                	  if(MPSeleccionado ==5) {
		   	                		System.out.println("Ingrese el saldo actual:");
	  	        	                Scanner jj = new Scanner(System.in);
	  	        	                double saldo = jj.nextDouble ();
		   	                	  	elMedioDePago = new DineroEnCuenta(saldo);
		   	                	  }
	   	                	     
		        	             System.out.println("Elegir el tipo de proveedor:");
	   	                	     System.out.println("1. Fisico");
	   	                	     System.out.println("2. Juridica");
	   	        	             Scanner tipoProveSeleccionada = new Scanner(System.in);
   	        	                int tipoProveedor = tipoProveSeleccionada.nextInt();

   	        	                if (tipoProveedor ==1) {
   	        	                        System.out.println("Ingrese el nombre del proveedor:");
	    	        	                Scanner nombreElegido = new Scanner(System.in);
	    	        	                String unNombre = nombreElegido.nextLine ();
	    	        	                System.out.println("Ingrese el apellido del proveedor:");
	    	        	                Scanner apellidoElegido = new Scanner(System.in);
	    	        	                String unApellido = apellidoElegido.nextLine ();
	    	        	                System.out.println("Ingrese la direccion del proveedor:");
	    	        	                Scanner direccionElegido = new Scanner(System.in);
	    	        	                String unDireccionPostal = direccionElegido.nextLine ();
	    	        	                System.out.println("Ingrese el DNI del proveedor:");
	    	        	                Scanner dniElegido = new Scanner(System.in);
	    	        	                String unDni = dniElegido.nextLine ();
	    	        	                System.out.println("Ingrese el CUIL del proveedor:");
	    	        	                Scanner cuilElegido = new Scanner(System.in);
	    	        	                String unCuil = cuilElegido.nextLine ();
	    	        	                ProveedorFisico unProveedor = new ProveedorFisico(unDireccionPostal, unNombre,  unApellido, unDni, unCuil);
	    	        	                OperacionEgreso opEgre= new  OperacionEgreso( unProveedor, new Date(), elMedioDePago, variosItems, losDocumentosComerciales);
	    	        	                operacionesEgreso.add(opEgre);
   	        	                } else if (tipoProveedor == 2) {
   	        	                
   	        	                	System.out.println("Ingrese la razon social del proveedor:");
	    	        	                Scanner razonElegido = new Scanner(System.in);
	    	        	                String unRazonSocial = razonElegido.nextLine ();
   	        	                	System.out.println("Ingrese la direccion del proveedor:");
	    	        	                Scanner direccioNElegido = new Scanner(System.in);
	    	        	                String unaDireccionPostal = direccioNElegido.nextLine ();
	    	        	                System.out.println("Ingrese el CUIT del proveedor:");
	    	        	                Scanner cuitElegido = new Scanner(System.in);
	    	        	                String unCuit = cuitElegido.nextLine ();
	    	        	                ProveedorJuridico otroProveedor = new ProveedorJuridico(unaDireccionPostal, unRazonSocial, unCuit);
	    	        	                OperacionEgreso opEgrezo= new  OperacionEgreso( otroProveedor, new Date(), elMedioDePago, variosItems, losDocumentosComerciales);
	    	        	                operacionesEgreso.add(opEgrezo);
   	        	                }

    	                	}//FIN DE CARGA DE OPERACIONES EGRESO
	    	                 System.out.println("Ingrese la cantidad de tipos de items:");
		        	         Scanner amountElegidaItems = new Scanner(System.in);
		                     int cantItems = amountElegidaItems.nextInt ();
		                     List<Item> itemsCompra = new ArrayList<Item>();

		        	         while(cantItems>0) {
		        	        	 	System.out.println("Informacion del item...");
		        	               	System.out.println("Ingrese la descripcion del item:");
		    	        	        Scanner descripcioNElegido = new Scanner(System.in);
		    	        	        String laDescripcion = descripcioNElegido.nextLine ();
		    	        	        System.out.println("Ingrese el valor:");
	  	        	                Scanner price = new Scanner(System.in);
	  	        	                int elValor = price.nextInt ();
	  	        	                System.out.println("Ingrese la cantidad de este producto:");
	  	        	                Scanner cantiddd = new Scanner(System.in);
	  	        	                int laCantidad = cantiddd.nextInt ();
		        	                Item unItem = new Item (laDescripcion, elValor, laCantidad);
		        	                itemsCompra.add(unItem);
		        	                cantItems --;
		        	         }

		        	         System.out.println("Ingrese la cantidad de revisores:");
		        	         Scanner rr = new Scanner(System.in);
	       	                 int cantRevi = rr.nextInt ();
	       	                 List<Usuario> revisores = new ArrayList<Usuario>();

		        	         while(cantRevi>0) {
		        	        	 System.out.println("Ingrese nombre de usuario: ");
		     	                Scanner userC = new Scanner(System.in);
		     	                String user = userC.nextLine ();
		     	                System.out.println("Ingresar password: ");
		     	                Scanner contraE = new Scanner(System.in);
		     	                String contrasenia = contraE.nextLine ();
		     	                Usuario usuarioCreadow = new Usuario(user, contrasenia, ConstantesTipoDeUsuario.ADMIN);
		     	                revisores.add(usuarioCreadow);
		     	                cantRevi--;
		        	         }

	       	           //creacion de la compra
	    	           Compra laCompra = new Compra (cantPresu, presupuestos, operacionesEgreso, revisores, itemsCompra, presupuestoElegido);
	    	           // Creación del validador de compra
	    	           ValidadorDeTransparencia validador = new ValidadorDeTransparencia(laCompra);
	    	           List<Boolean> resultadoValidacion = validador.resultadosValidadorCompra();
	    	           System.out.println("Resultado de la validacion de la compra (el mensaje fue enviado a los revisores)");
	    	           System.out.println("Cumple con cantidad de presupuestos requeridos: " + String.valueOf(resultadoValidacion.get(0)).replaceAll("true", "OK").replaceAll("false", "ERROR"));
	    	           System.out.println("Cumple con haber sido realizada en base a algun presupuesto: " + String.valueOf(resultadoValidacion.get(1)).replaceAll("true", "OK").replaceAll("false", "ERROR"));
	    	           System.out.println("Cumple con haberse realizado en base al presupuesto de menor valor:" + String.valueOf(resultadoValidacion.get(2)).replaceAll("true", "OK").replaceAll("false", "ERROR"));
	    		      }
    		      } //CIERRE SWITCH OPCIONES DEL MENÚ PRINCIPAL
    	    } catch (InputMismatchException e) {
    	        System.out.println("Debes insertar un número");
    	        sn.next();
    	    }
    	} //CIERRE WHILE(!SALIR)
	} //CIERRE FUNCION MAIN
} //CIERRE CLASE MAIN

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