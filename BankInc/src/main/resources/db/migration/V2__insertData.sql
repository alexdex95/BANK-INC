INSERT INTO Estados (descripcion,funcion) VALUES('Activo',   'Tarjetas');
INSERT INTO Estados (descripcion,funcion) VALUES('Inactivo', 'Tarjetas');
INSERT INTO Estados (descripcion,funcion) VALUES('Bloqueado','Tarjetas');
INSERT INTO Estados (descripcion,funcion) VALUES('Anulada',   'Transacciones');

INSERT INTO Ciudades (nombre) VALUES('Bogota');
INSERT INTO Ciudades (nombre) VALUES('Cali');
INSERT INTO Ciudades (nombre) VALUES('Medellin');
INSERT INTO Ciudades (nombre) VALUES('Cartagena');

INSERT INTO Productos (numeroProducto,descripcion) VALUES('000001','Debito');
INSERT INTO Productos (numeroProducto,descripcion) VALUES('000002','Credito');

INSERT INTO Clientes (nombres,apellidos,tipoDocumento,numeroDocumento,edad,ciudadId) VALUES('Jefferson Alexander','Moreno Barrera','CC',1018481186,27,1);

INSERT INTO Tarjetas (idTarjeta,fechaVencimiento,fechaCreacion,saldo,productoID,clienteID,estadoID) VALUES(0000011234567890,'2021-06-15','2021-06-15',10000,1,1,1);

INSERT INTO Transacciones (fechaMovimiento,valor,productoID,tarjetaID,estadoID) VALUES('2021-06-15',10000,1,0000011234567890,1);

INSERT INTO Recargas (fechaRecarga,valor,tarjetaID) VALUES('2021-06-15',10000,0000011234567890);