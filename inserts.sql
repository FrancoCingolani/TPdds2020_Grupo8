INSERT INTO atm (id_medio_de_pago, linkPagos) VALUES (1,1111), (2, 2222), (3, 3333);
INSERT INTO categorias (id_categoria, tipo) VALUES (1,'tipo1'), (2, 'tipo2'), (3, 'tipo3');
INSERT INTO clasificaciones (id_clasificaciones,descripcion,clasificacionPadre, id_criterio) VALUES (1,'descripcion´1', 1, 1), (2,'descripcion 2', 2, 2), (3,'descripcion3', 3, 3);
INSERT INTO compras (id_compra, cantPresuReq, id_presupuesto) VALUES (1,1,1), (2, 2, 2), (3, 3, 3);
INSERT INTO compras_usuarios (Compra_id_compra, revisores_nombre, revisores_id_usuario) VALUES (1,'nombre 1', 1), (2,'nombre 2', 2), (3,'nombre 3', 3);
INSERT INTO criterio (id_criterio, descripcion) VALUES (1,'descripcion 1'), (2, 'descripcion 2'), (3, 'descripcion 3');
INSERT INTO dineroencuenta (id_medio_de_pago, saldo) VALUES (1,1111), (2, 2222), (3, 3333);
INSERT INTO documentocomerciales (id_documento_comercial, numero_identificacion, tipo) VALUES (1, 'numero 1',1), (2, 'numero 2',2), (3, 'numero 3',3);
INSERT INTO entidadesjuridicas (descripcion,nombreFicticio,CUIT, codigoInscripcionIGJ, razonSocial,id_entidad_base, id_entidad_juridica, perteneceA_id_entidad_juridica) VALUES ('descripcion 1','nombreFicticio 1', 'CUIT 1', 1, 'razonSocial 1',1, 1, null),('descripcion 2','nombreFicticio 2', 'CUIT 2', 2, 'razonSocial 2',2, 2, null), ('descripcion 3','nombreFicticio 3', 'CUIT 3', 3, 'razonSocial 3',3, 3, 1);
INSERT INTO items (id_item,cantidad, descripcion, numeroPresupuesto, valor, id_clasificacion, id_compra, id_moneda) VALUES (1, 11, 'descripcion 1', 1, 1111, 1, 1, null), (2, 22, 'descripcion 2', 2, 2222, 2, 2, null), (3, 33, 'descripcion 3', 3, 3333, 3, 3, null);

INSERT INTO mensajes (tipo,id_mensaje, asuntoMensaje, leido, textoMensaje) VALUES ('tipo1',1, 'asunto 1', 1, 'textoMensaje 1'), ('tipo2',2, 'asunto 2', 1, 'textoMensaje 2'), ('tipo3',3, 'asunto 3', 0, 'textoMensaje 3');
INSERT INTO operacionesegreso (id_operacion_egreso, fecha,fueVinculado, valorTotal, id_moneda, id_medio_de_pago, id_operacion_ingreso, id_organizacion, id_proveedor, id_operacion_egreso_entidad) VALUES (1, 03/12/2020,0, 1111, null, 1, 1, 1, 1, 1), (2, 03/12/2020,0, 11121, null, 2, 2, 2, 2, 2);
INSERT INTO operacionesegreso_documentoscomerciales (OperacionEgreso_id_operacion_egreso,documentosComerciales_id_documento_comercial) VALUES (1,1), (2, 2), (3, 3);
INSERT INTO operacionesegreso_items (OperacionEgreso_id_operacion_egreso,items_id_item) VALUES (1,1), (2, 2), (3, 3);
INSERT INTO operacionesingreso (id_operacion_ingreso, descripcion,fechaIngreso,valorTotal, id_moneda, id_organizacion, id_subsidio, id_operacion_ingreso_entidad) VALUES (1, 'desc 1',05/11/2012,11111, null, 1, 1, 1), (2, 'desc 2',05/11/2012,222222, null, 2, 2, 2);
INSERT INTO operacioningreso (id_operacion_ingreso, descripcion,fechaIngreso,valorTotal, id_moneda, id_organizacion, id_subsidio, id_operacion_ingreso_entidad) VALUES(1, 'desc 1',05/11/2012,11111, null, 1, 1, 1), (2, 'desc 2',05/11/2012,222222, null, 2, 2, 2);
INSERT INTO organizaciones (id_organizacion,actividad,direccionPostal,periodoVinculacion, personal, tipo, ventasAnuales, categoria_id_categoria, id_ciudad_id_ciudad) VALUES (1,1,'1direccionPostal',1, 1, 1, 11111, 1, null),(2,2,'2direccionPostal',2, 2, 2, 2222, 2, null);
INSERT INTO presupuestos (id_presupuesto, detalle, numeroPresupuesto, valorTotal, id_moneda, id_proveedor) VALUES (1, 'detalle 1', 1, 1111, null, 1), (2, 'detalle 2', 2, 2222, null, 1);
INSERT INTO presupuestos_documentos (Presupuesto_id_presupuesto) VALUES (1,1), (2, 2);
INSERT INTO presupuestos_items (Presupuesto_id_presupuesto, items_id_item) VALUES (1,1), (2, 2);
INSERT INTO proveedores (tipo, id_proveedor, direccionPostal, cuit, razonSocial, apellido, cuil, dni, nombre, id_ciudad) VALUES ('tipo', 1, 'direccionPostal', 'cuit', 'razonSocial', 'apellido', null, null, 'nombre', null);
INSERT INTO proyectos (id_proyecto, descripcion, montoAsignado, nombre, id_usuario) VALUES (1, 'descripcion 1', 1111, 'nombre 1', 1), (2, 'descripcion 2', 2222, 'nombre 2', 2), (3, 'descripcion 3', 3333, 'nombre 3', 3);
INSERT INTO tarjetadecredito (id_medio_de_pago, codigoSeguridad, duenioNombre, duenioNroIdentifiacion, duenoTipoIDentificacion,fechaExperacion, numero) VALUES (1, 'codigoSeguridad', 'duenioNombre', 'duenioNroIdentifiacion', 'duenoTipoIDentificacion',null, 'numero');
INSERT INTO tarjetadedebito (id_medio_de_pago, codigoSeguridad, duenioNombre, duenioNroIdentifiacion, duenoTipoIDentificacion,fechaExperacion, numero) VALUES (1, 'codigoSeguridad', 'duenioNombre', 'duenioNroIdentifiacion', 'duenoTipoIDentificacion',null, 'numero');
INSERT INTO ticket (id_medio_de_pago, codigoBarras, numeroParaCajero) VALUES (1,1111,'111'), (2, 2222,'2222'), (3, 3333,'333333');
INSERT INTO usuarios (nombre, cantidadIntentos, contrasenia, intentosMaximos, tipo, id_usuario) VALUES ('ignacio', null, 'iGnac10ss', 3, 1, 1), ('franco', null, 'Franc0ssss', 3, 1, 1), ('jesica', null, 'J3s1casss', 3, 1, 1), ('josefina', null, 'J0sef1nass', 3, 1, 1), ;

