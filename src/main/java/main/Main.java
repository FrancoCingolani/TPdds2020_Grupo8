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
		
		Criterio criterioClientes = new Criterio ("clientes");
		Clasificacion clasificacionClienteA = new Clasificacion ("cliente A", criterioClientes, null);
		Clasificacion clasificacionClienteB = new Clasificacion ("cliente B", criterioClientes, null);
		Criterio criterioUbicacion = new Criterio ("ubicación");
		Clasificacion clasificacionUbicacionCaba = new Clasificacion ("CABA", criterioUbicacion, null);
		Clasificacion clasificacionUbicacionCorrientes = new Clasificacion ("Corrientes", criterioUbicacion, null);
        
        Scanner sn = new Scanner(System.in);
    	boolean salir = false;
    	int opcion;
    	while (!salir) {
    		
    	    System.out.println("1. Crear usuario");
    	    System.out.println("2. Crear organización");
    	    System.out.println("3. Agregar compra");
    	    System.out.println("4. Validar compra");
    	    System.out.println("5. Salir");
    	    
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
    	                break;
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
    	                break;
    		      	case 3:
    		      		System.out.println("Ingrese la cantidad de presupuestos necesarios ");
    	                Scanner cantElegida = new Scanner(System.in);
    	                int cantPresu = cantElegida.nextInt ();
    	                List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
    	                Presupuesto presupuestoElegido = null;
    	                

    	                if(cantPresu>0) {
    	                	for(int i=0; i< cantPresu; i++) {
    	                		Clasificacion clasificacion = clasificacionClienteA;
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
    	        	                System.out.println("Elija el criterio:");
    	        	                System.out.println("1. Clientes");
       	                	     	System.out.println("2. Ubicación");
	       	                	    Scanner criterioElegido = new Scanner(System.in);
	 	        	                int criterio = criterioElegido.nextInt ();
       	                	     	if(criterio == 1) {
	       	                	     	System.out.println("Elija la clasificación:");
		 	        	                System.out.println("1. Cliente A");
	    	                	     	System.out.println("2. Cliente B");
	    	                	     	Scanner clasif = new Scanner(System.in);
	    	        	                int clasificacionElegida = clasif.nextInt ();
	    	        	                if(clasificacionElegida == 1) {
	    	        	                	clasificacion = clasificacionClienteA;
	    	        	                }else if(clasificacionElegida == 2){
	    	        	                	clasificacion = clasificacionClienteB;
	    	        	                }
       	                	     	}
       	                	     if(criterio == 2) {
	       	                	    	System.out.println("Elija la clasificación:");
	    	        	                System.out.println("1. CABA");
	       	                	     	System.out.println("2. Corrientes");
	    	                	     	Scanner clasif = new Scanner(System.in);
	    	        	                int clasificacionElegida = clasif.nextInt ();
	    	        	                if(clasificacionElegida == 1) {
	    	        	                	clasificacion = clasificacionUbicacionCaba;
	    	        	                }else if(clasificacionElegida == 2){
	    	        	                	clasificacion = clasificacionUbicacionCorrientes;
	    	        	                }
    	                	     	}	       	                	    	                	                	     		
									Item unItem = new Item (laDescripcion, elValor, laCantidad, clasificacion);
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
    	                	List<Item> itemsCompra = new ArrayList<Item>();
    	                	for(int i=0; i< cantOE; i++) {
    	                		 System.out.println("Ingrese la cantidad de tipos de items:");
 	        	                Scanner amountElegidaItems = new Scanner(System.in);
 	        	                int cantItems = amountElegidaItems.nextInt ();
 	        	                List<Item> variosItems = new ArrayList<Item>();;
 	        	                
 	        	                while(cantItems>0) {
 	        	                	Clasificacion clasificacion0 = clasificacionClienteA;
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
     	        	               System.out.println("Elija el criterio:");
     	        	               System.out.println("1. Clientes");
      	                	     	System.out.println("2. Ubicación");
	       	                	    Scanner criterioElegido0 = new Scanner(System.in);
	 	        	                int criterio0 = criterioElegido0.nextInt ();
      	                	     	if(criterio0 == 1) {
	       	                	     	System.out.println("Elija la clasificación:");
		 	        	                System.out.println("1. Cliente A");
	    	                	     	System.out.println("2. Cliente B");
	    	                	     	Scanner clasif0 = new Scanner(System.in);
	    	        	                int clasificacionElegida0 = clasif0.nextInt ();
	    	        	                if(clasificacionElegida0 == 1) {
	    	        	                	clasificacion0 = clasificacionClienteA;
	    	        	                }else if(clasificacionElegida0 == 2){
	    	        	                	clasificacion0 = clasificacionClienteB;
	    	        	                }
      	                	     	}
      	                	     if(criterio0 == 2) {
	       	                	    	System.out.println("Elija la clasificación:");
	    	        	                System.out.println("1. CABA");
	       	                	     	System.out.println("2. Corrientes");
	    	                	     	Scanner clasif0 = new Scanner(System.in);
	    	        	                int clasificacionElegida0 = clasif0.nextInt ();
	    	        	                if(clasificacionElegida0 == 1) {
	    	        	                	clasificacion0 = clasificacionUbicacionCaba;
	    	        	                }else if(clasificacionElegida0 == 2){
	    	        	                	clasificacion0 = clasificacionUbicacionCorrientes;
	    	        	                }
   	                	     	}
 	        	                	Item unItem = new Item (laDescripcion, elValor, laCantidad, clasificacion0);
 	        	                	variosItems.add(unItem);
 	        	                	itemsCompra.add(unItem);
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
	    	           System.out.println("La compra ha sido cargada..");
	    	          
	    		      }

    	                break;
    		      	case 4:
    		     
    		      		Proveedor proveedor88 = new Proveedor("asdf 123");
     	               Item item111 = new Item("Tuercas", 10, 10, clasificacionClienteA);
     	               Item item11B = new Item("Tuercas Baratas", 5, 10, clasificacionClienteA);
     	               Item item11C = new Item("Tuercas Caras", 20, 10, clasificacionClienteA);
     	               Item item222 = new Item("Tornillo", 5, 5,clasificacionClienteA);
     	               Item item22B = new Item("Tornillo Barato", 1, 5,clasificacionClienteA);
     	               Item item22C = new Item("Tornillo Caro", 10, 5,clasificacionClienteA);
     	               Item item333 = new Item("Clavos",2,20,clasificacionClienteA); 
     	               Item item33B = new Item("Clavos Baratos",1,20,clasificacionClienteA);
     	               Item item33C = new Item("Clavos Caros",4,20,clasificacionClienteA);
     	                List<Item> itemsss = Arrays.asList(item111, item222,item333);
     	                List<Item> itemsssBaratos = Arrays.asList(item11B, item22B,item33B);
     	                List<Item> itemsssCAROS = Arrays.asList(item11C, item22C,item33C);
     	                DocumentoComercial documentoComercialll = new DocumentoComercial("1","tipo");
     	                 List<DocumentoComercial> docsComerciales = new ArrayList<DocumentoComercial>();
     	                 docsComerciales.add(documentoComercialll);
     	                 DineroEnCuenta monedero = new DineroEnCuenta(1000000);
     	                OperacionEgreso operacionEgreso = new OperacionEgreso(proveedor88, new Date(),monedero,itemsss,docsComerciales);
     	               OperacionEgreso operacionEgresoBarata = new OperacionEgreso(proveedor88, new Date(),monedero,itemsssBaratos,docsComerciales);
     	              OperacionEgreso operacionEgresoCara = new OperacionEgreso(proveedor88, new Date(),monedero,itemsssCAROS,docsComerciales);
     	               List<OperacionEgreso> operacionesEgre = Arrays.asList(operacionEgreso);
     	              List<OperacionEgreso> operacionesEgreBarata = Arrays.asList(operacionEgresoBarata);
     	             List<OperacionEgreso> operacionesEgreCara = Arrays.asList(operacionEgresoCara);
     	                Presupuesto presupuesto1 = new Presupuesto(proveedor88,"detalle",itemsss,docsComerciales);
     	                Presupuesto presupuestoBarato = new Presupuesto(proveedor88, "detalle", itemsssBaratos, docsComerciales);
     	                Presupuesto presupuestoCaro = new Presupuesto(proveedor88, "detalle", itemsssCAROS, docsComerciales);
     	                List<Presupuesto> soloUnPresu = new ArrayList<Presupuesto>();
     	                soloUnPresu.add(presupuesto1);
     	            //   List<Presupuesto> dosPresu = Arrays.asList(presupuestoBarato, presupuestoCaro);
     	                List<Presupuesto> dosPresu = new ArrayList<Presupuesto>();
     	                dosPresu.add(presupuestoBarato);
     	               dosPresu.add(presupuestoCaro);
     	              List<Presupuesto> otrosDosPresu = Arrays.asList(presupuesto1, presupuestoCaro);
     	                List<Usuario> revisores = new ArrayList<Usuario>();
     	                Usuario usuarioTOP = new Usuario("franco", "lalapapa!", ConstantesTipoDeUsuario.ADMIN);
     	                revisores.add(usuarioTOP);
     	                Compra compraFaltaPresu = new Compra(2,soloUnPresu, operacionesEgre, revisores,itemsss,presupuesto1);
     	                Compra compraQEligioOtro = new Compra(2,otrosDosPresu, operacionesEgreBarata, revisores,itemsssBaratos,presupuestoBarato);
     	               Compra compraCARA = new Compra(2,dosPresu, operacionesEgreCara, revisores,itemsssCAROS,presupuestoCaro);
     	              Compra compraOK = new Compra(2,dosPresu, operacionesEgreBarata, revisores,itemsssBaratos,presupuestoBarato);
     	                
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     	                
     	                //OPCIONES EN PANTALLA
    		      		System.out.println("Ya hay compras cargadas, elige la que quieres validar: ");
    		      		System.out.println("1. Si tiene todos los presupuestos requeridos");
    		    	    System.out.println("2. Si fue realizado en base de un presupuesto");
    		    	    System.out.println("3. Si se eligio el mas barato");
    		    	    System.out.println("4. Si esta todo OK");
    	                Scanner compraElegida = new Scanner(System.in);
    	                int opcionCompra = compraElegida.nextInt();
    	                if(opcionCompra == 1) {
    	                	System.out.println("En este caso se le pedian 2 presupuestos y solo pidieron uno..");
    	                	ValidadorDeTransparencia validador1 = new ValidadorDeTransparencia(compraFaltaPresu);
    	                	validador1.validarCompra();
    	                 	             
    	                } else if(opcionCompra == 2) {
    	                	System.out.println("En este caso se compro de un presupuesto que no fue el elegido..");
    	                	ValidadorDeTransparencia validador1 = new ValidadorDeTransparencia(compraQEligioOtro);
    	                	validador1.validarCompra();
    	                }else if (opcionCompra == 3) {
    	                	System.out.println("En este caso se eligio el presupuesto mas caro..");
    	                	ValidadorDeTransparencia validador1 = new ValidadorDeTransparencia(compraCARA);
    	                	validador1.validarCompra();
    	                }else if (opcionCompra ==4) {
    	                	System.out.println("En este caso, la compra cumple con todas las condiciones..");
    	                	ValidadorDeTransparencia validador1 = new ValidadorDeTransparencia(compraOK);
    	                	validador1.validarCompra();
    	                }//fin opciones validaciones
    	                 //Muy groncho, pero todos tienen el mismo revisor, asi que ya fue...
    	                System.out.println("El resultado fue..");
    	                List<Mensaje>mensajes = usuarioTOP.getMensajes();
    	                for(Mensaje mensaje : mensajes) {
    	                	System.out.println(mensaje.getTextoMensaje());
    	                }
    	                
    	               
    		      		
    		      } //CIERRE SWITCH OPCIONES DEL MENÚ PRINCIPAL
    	    } catch (InputMismatchException e) {
    	        System.out.println("Debes insertar un número");
    	        sn.next();
    	    }
    	} //CIERRE WHILE(!SALIR)
	} //CIERRE FUNCION MAIN
	
	
	
//FUNCIONES PARA QUE NO SEA TAN GRONCHO EL MAIN
public Usuario crearUsuario() {
		System.out.println("Ingrese nombre de usuario: ");
	    Scanner usuarioElegido = new Scanner(System.in);
	    String usuario = usuarioElegido.nextLine ();
	    System.out.println("Ingresar password: ");
	    Scanner passwordElegida = new Scanner(System.in);
	    String password = passwordElegida.nextLine ();
	    Usuario usuarioCreado = new Usuario(usuario, password, ConstantesTipoDeUsuario.ADMIN);
	    return usuarioCreado;
	}

public void crearOrganizacion() {
	System.out.println("Elige el tipo de Organización: ");
		System.out.println("1. Entidad base");
    System.out.println("2. Entidad jurídica");
    Scanner tipoOrganizacionElegido = new Scanner(System.in);
    int opcionOrganizacion = tipoOrganizacionElegido.nextInt();
    
    if(opcionOrganizacion == 1) {     	
        EntidadBase entidadBase = this.crearEntidadBase();
    }else if(opcionOrganizacion == 2) {    	
        EntidadJuridica entidadJuridica = this.crearEntidadJuridica();
    }
 
}

public Actividad elegirActividad() {
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
     return actividadOrganizacion;
}

public EntidadBase crearEntidadBase() {
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
    
    Actividad actividadOrganizacion = this.elegirActividad();
   
    EntidadBase entidadBase = new EntidadBase(nombreOrganizacion, descripcionOrganizacion, personalOrganizacion, direccionOrganizacion, actividadOrganizacion);
    System.out.println("Entidad base creada exitosamente");
    
	return entidadBase;
}

public EntidadJuridica crearEntidadJuridica() {
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
    
    Actividad actividadOrganizacion = this.elegirActividad();
    
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
    return entidadJuridica;
	
}

public Item crearItem() {
	Criterio criterioClientes = new Criterio ("clientes");
	Clasificacion clasificacionClienteA = new Clasificacion ("cliente A", criterioClientes, null);
	Clasificacion clasificacionClienteB = new Clasificacion ("cliente B", criterioClientes, null);
	Criterio criterioUbicacion = new Criterio ("ubicación");
	Clasificacion clasificacionUbicacionCaba = new Clasificacion ("CABA", criterioUbicacion, null);
	Clasificacion clasificacionUbicacionCorrientes = new Clasificacion ("Corrientes", criterioUbicacion, null);
	
	Clasificacion clasificacion0 = clasificacionClienteA;
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
    System.out.println("Elija el criterio:");
    System.out.println("1. Clientes");
   	System.out.println("2. Ubicación");
	    Scanner criterioElegido0 = new Scanner(System.in);
     int criterio0 = criterioElegido0.nextInt ();
   	if(criterio0 == 1) {
	     	System.out.println("Elija la clasificación:");
         System.out.println("1. Cliente A");
     	System.out.println("2. Cliente B");
     	Scanner clasif0 = new Scanner(System.in);
        int clasificacionElegida0 = clasif0.nextInt ();
        if(clasificacionElegida0 == 1) {
        	clasificacion0 = clasificacionClienteA;
        }else if(clasificacionElegida0 == 2){
        	clasificacion0 = clasificacionClienteB;
        }
   	}
   if(criterio0 == 2) {
	    	System.out.println("Elija la clasificación:");
        System.out.println("1. CABA");
	     	System.out.println("2. Corrientes");
     	Scanner clasif0 = new Scanner(System.in);
        int clasificacionElegida0 = clasif0.nextInt ();
        if(clasificacionElegida0 == 1) {
        	clasificacion0 = clasificacionUbicacionCaba;
        }else if(clasificacionElegida0 == 2){
        	clasificacion0 = clasificacionUbicacionCorrientes;
        }
	}
 	Item unItem = new Item (laDescripcion, elValor, laCantidad, clasificacion0);
 	return unItem;
}

public Presupuesto crearPresupuesto() { // no pregunta si es o no el presupuesto elegido
	
	System.out.println("Ingrese el detalle del presupuesto:");
    Scanner descElegido = new Scanner(System.in);
    String unDetalle = descElegido.nextLine ();
    System.out.println("Ingrese la cantidad de tipos de items:");
    Scanner cantElegidaItems = new Scanner(System.in);
    int cantItems = cantElegidaItems.nextInt ();
    List<Item> unosItems = new ArrayList<Item>();
    while(cantItems>0) {
    	       	                	    	                	                	     		
		Item unItem = this.crearItem();
    	unosItems.add(unItem);
    	cantItems --;
    }    
    System.out.println("Ingrese la cantidad de documentos:");
    Scanner cantElegidaDocs = new Scanner(System.in);
    int cantDocEle = cantElegidaDocs.nextInt ();
    List<DocumentoComercial> unosDocumentos = new ArrayList<DocumentoComercial>();
    while(cantDocEle>0) {
    	
    	DocumentoComercial unDocumento = this.crearDocumento();
    	unosDocumentos.add(unDocumento);
    	cantDocEle --;
    }
    
	
     Proveedor elProveedor = this.crearProveedor();
       
        Presupuesto unPresupuesto = new Presupuesto(elProveedor, unDetalle, unosItems, unosDocumentos);
        return unPresupuesto;
}

public DocumentoComercial crearDocumento() {
	System.out.println("Informacion del documento...");
	System.out.println("Ingrese el numero del documento:");
    Scanner numeroChosen = new Scanner(System.in);
    String unNDoc = numeroChosen.nextLine ();
    System.out.println("Ingrese el tipo del documento:");
    Scanner tipoElegido = new Scanner(System.in);
    String unTipo = tipoElegido.nextLine ();
	DocumentoComercial unDocumento = new DocumentoComercial( unNDoc, unTipo);
	return unDocumento;
}

public Proveedor crearProveedor() {
	System.out.println("Elegir el tipo de proveedor:");
    System.out.println("1. Fisico");
    System.out.println("2. Juridica");
    Scanner tipoProveSeleccionada = new Scanner(System.in);
    Proveedor elProveedor = null;
       int tipoProveedor = tipoProveSeleccionada.nextInt();
       if (tipoProveedor == 1) {
                   
           elProveedor = this.crearProveedorFisico();
           
        }else if(tipoProveedor == 2) {
       
       	elProveedor = this.crearProveedorJuridico();
       	
       }
       return elProveedor;
}

public ProveedorJuridico crearProveedorJuridico() {
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
	return otroProveedor;	
}

public ProveedorFisico crearProveedorFisico() {
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
    return unProveedor;
}

public MedioDePago crearMedioDePago() {
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
	    	 
  	    	elMedioDePago = this.crearTarjetaCredito();
	     } if(MPSeleccionado == 2) {
	    	 
	    	 elMedioDePago = this.crearTarjetaDebito();
      	 }if(MPSeleccionado ==3) {
   		
   	  	elMedioDePago = this.crearTicket();
   	    }if(MPSeleccionado ==4) {
   		
   	  	elMedioDePago = this.crearAtm();
   	   }if(MPSeleccionado ==5) {
   		
   	  	elMedioDePago = this.crearDineroEnCuenta();
   	  }
   	   return elMedioDePago;
}

public TarjetaDeCredito crearTarjetaCredito() {
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
    TarjetaDeCredito tarjeta = new TarjetaDeCredito( numeroTarjeta, codigoSeguridad, fechaExpiracion, duenioNombre, duenioNroIdentificacion,  duenoTipoIdentificacion);
    return tarjeta;	
}
public TarjetaDeDebito crearTarjetaDebito() {
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
	 TarjetaDeDebito  tarjetaD = new TarjetaDeDebito(elNumero,  elCodigoSeguridad, laFechaExpiracion, elDuenioNombre,  elDuenioNroIdentificacion, elDuenoTipoIdentificacion);
	return tarjetaD;     
	
}
public Atm crearAtm() {
	System.out.println("Ingrese el numero de link pagos:");
    Scanner nLP = new Scanner(System.in);
    int linkPagos = nLP.nextInt ();
	Atm atm = new Atm(linkPagos);
	return atm;
}
public DineroEnCuenta crearDineroEnCuenta(){
	System.out.println("Ingrese el saldo actual:");
    Scanner jj = new Scanner(System.in);
    double saldo = jj.nextDouble ();
	DineroEnCuenta dinero = new DineroEnCuenta(saldo);
	return dinero;
}

public Ticket crearTicket() {
	System.out.println("Ingrese el numero para el Cajero:");
    Scanner cajeroNUM = new Scanner(System.in);
    String numeroParaCajero = cajeroNUM.nextLine ();
    System.out.println("Ingrese el codigo de barras:");
    Scanner y = new Scanner(System.in);
    long codigoBarras = y.nextLong ();
	Ticket ticket = new Ticket( numeroParaCajero, codigoBarras);
	return ticket;
}

public Compra crearCompra() {

		System.out.println("Ingrese la cantidad de presupuestos necesarios ");
    Scanner cantElegida = new Scanner(System.in);
    int cantPresu = cantElegida.nextInt ();
    List<Presupuesto> presupuestos = new ArrayList<Presupuesto>();
    Presupuesto presupuestoElegido = null;
    

    if(cantPresu>0) {
    	for(int i=0; i< cantPresu; i++) {
    	Presupuesto unPresu=this.crearPresupuesto();	
    	presupuestos.add(unPresu);
    	System.out.println("¿Es el presupuesto que se ha elegido al final?  (Y/N)");//Muy groncho, pero efectivo
        Scanner ufinal = new Scanner(System.in);
        String fuELegido = ufinal.nextLine ();
        	if(fuELegido == "Y") {
        	presupuestoElegido = unPresu;
        	}
    	}
    	
    }

    //Ahora las operaciones egreso, por fin
    System.out.println("Ingrese la cantidad de operaciones Egreso: ");
    Scanner cantaElegida = new Scanner(System.in);
    int cantOE = cantaElegida.nextInt ();
    List<OperacionEgreso> operacionesEgreso = new ArrayList<OperacionEgreso>();
    Compra laCompra= null;
    if(cantOE>0) {
    	List<Item> itemsCompra = new ArrayList<Item>();
    	for(int i=0; i< cantOE; i++) {
    		 System.out.println("Ingrese la cantidad de tipos de items:");
             Scanner amountElegidaItems = new Scanner(System.in);
             int cantItems = amountElegidaItems.nextInt ();
             List<Item> variosItems = new ArrayList<Item>();;
             
             while(cantItems>0) {
             	
             	Item unItem = this.crearItem();
             	variosItems.add(unItem);
             	itemsCompra.add(unItem);
             	cantItems --;
             }//FIN ITEMS
            System.out.println("Ingrese la cantidad de documentos:");
            Scanner cantDocumen = new Scanner(System.in);
            int cantDocEle = cantDocumen.nextInt ();
            List<DocumentoComercial> losDocumentosComerciales = new ArrayList<DocumentoComercial>();
            while(cantDocEle>0) {
            	
            	DocumentoComercial unDocumento = this.crearDocumento();
            	losDocumentosComerciales.add(unDocumento);
            	cantDocEle --;
            }//FIN DOCS

       	     MedioDePago elMedioDePago = this.crearMedioDePago();
       	  Proveedor unProveedor = this.crearProveedor();
          OperacionEgreso opEgre= new  OperacionEgreso( unProveedor, new Date(), elMedioDePago, variosItems, losDocumentosComerciales);
          operacionesEgreso.add(opEgre);
          

    	}//FIN DE CARGA DE OPERACIONES EGRESO
    	
         System.out.println("Ingrese la cantidad de revisores:");
         Scanner rr = new Scanner(System.in);
            int cantRevi = rr.nextInt ();
            List<Usuario> revisores = new ArrayList<Usuario>();

         while(cantRevi>0) {
        	 
             Usuario usuarioCreadow = this.crearUsuario();
             revisores.add(usuarioCreadow);
             cantRevi--;
         }

      //creacion de la compra
         laCompra = new Compra (cantPresu, presupuestos, operacionesEgreso, revisores, itemsCompra, presupuestoElegido);
         System.out.println("La compra ha sido cargada..");
         
   }
    return laCompra;
}

} //CIERRE CLASE MAIN






/* System.out.println("Ingrese la cantidad de tipos de items:");
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
}*/
// ESTOS se rellena a medida que se va llenando cada operacion egreso, si no buscar itemscompra en el codigo para entender

