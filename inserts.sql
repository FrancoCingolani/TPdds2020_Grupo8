INSERT INTO usuarios (nombre, cantidadIntentos, contrasenia, intentosMaximos, tipo, id_usuario) VALUES ('ignacio', 0, 'iGnac10ss', 3, 1, 1), ('franco', 0, 'Franc0ssss', 3, 1, 2), ('jesica', 0, 'J3s1casss', 3, 1, 3), ('josefina', 0, 'J0sef1nass', 3, 1, 4);
INSERT INTO currencyml VALUES (1, 2, "Peso argentino", "ARS"), (2, 2, "Dolar Estadounidense", "USD");
INSERT INTO cityml VALUES (1, 1, 1, 1000, 2000, "Buenos Aires", "Argentina", "Buenos Aires");
INSERT INTO organizaciones VALUES (1,1,'1direccionPostal', "organizacion1", 30, 20, 1, 40000, 1, 1);
INSERT INTO proyectos VALUES (1, 1, "descripcion 1", 10000, "proyecto 1", 1, 1);
INSERT INTO atm (id_medio_de_pago, linkPagos) VALUES (1,1111), (2, 2222), (3, 3333);
INSERT INTO categorias (id_categoria, tipo) VALUES (1,'tipo1'), (2, 'tipo2'), (3, 'tipo3');
INSERT INTO criterios VALUES (1, "Criterio1"), (2, "Criterio2");
INSERT INTO clasificaciones VALUES (1,'descripcionŽ1', 1, 1), (2,'descripcion 2', 2, 2), (3,'descripcion3', 3, 2);
INSERT INTO proveedores (tipo, id_proveedor, direccionPostal, apellido, cuil, dni, nombre, id_ciudad) VALUES ('fisico', 1, 'direccionPostal', 'Cingolani', '20123456', '123456', 'Franco', 1);
INSERT INTO compras VALUES (1, 1, NULL);
INSERT INTO presupuestos VALUES (1, "presupuesto 1", 1, 10000, 1, 1, 1);
INSERT INTO compras_usuarios (Compra_id_compra, revisores_id_usuario) VALUES (1, 1);
INSERT INTO dineroencuenta (id_medio_de_pago, saldo) VALUES (1,1000), (2, 2000), (3, 1500);
INSERT INTO documentoscomerciales (id_documento_comercial, numero_identificacion, tipo) VALUES (1, '123456',1), (2, '456789',2);
INSERT INTO entidadesjuridicas VALUES ('descripcion 1','20123456', 10 , 'razonSocial 1',1, 1, NULL);
INSERT INTO items VALUES (1, 10, 'Computadoras', 1, 100000, 1, 1, 1);
INSERT INTO mensajes VALUES ('tipo1',1, 'Mensaje importante al grupo 8', 1, 'Vamos a promocionar DDS',1);
INSERT INTO tarjetadecredito VALUES (1, 'password', 'Franco', '20123456', 'DNI',NULL, '456789123');
INSERT INTO tarjetadedebito  VALUES (2, 'password', 'Ignacio', '852741963', 'DNI',NULL, '987654321');
INSERT INTO ticket VALUES (3,1000,'8512');
INSERT INTO presupuestos_documentoscomerciales VALUES (1,1);
INSERT INTO presupuestos_items VALUES (1,1);
INSERT INTO operacionesingreso VALUES (1, 'opIngreso 1', "2020-11-05" ,120000, 1, 1, 1, null);
INSERT INTO operacionesegreso VALUES (1, "2020-11-18", 0, 80000, 1, 1, 1, 1, 1, 1, null);
INSERT INTO operacionesegreso_documentoscomerciales VALUES (1,1);
INSERT INTO operacionesegreso_items VALUES (1,1);