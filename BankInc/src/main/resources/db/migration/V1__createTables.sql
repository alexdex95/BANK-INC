DROP TABLE IF EXISTS Estados;
CREATE TABLE Estados (
idEstado INT auto_increment PRIMARY KEY,
descripcion varchar(50) NOT NULL,
funcion varchar(15) NOT NULL,
PRIMARY KEY (idEstado)
);

DROP TABLE IF EXISTS Ciudades;
CREATE TABLE Ciudades (
idCiudad INT auto_increment PRIMARY KEY,
nombre varchar(50) NOT NULL,
PRIMARY KEY (idCiudad)
);

DROP TABLE IF EXISTS Productos;
CREATE TABLE Productos (
idProducto INT auto_increment PRIMARY KEY,
numeroProducto varchar(6) NOT NULL, 
descripcion varchar(50) NOT NULL,
PRIMARY KEY (idProducto)
);

DROP TABLE IF EXISTS Clientes;
CREATE TABLE Clientes (
idCliente INT auto_increment PRIMARY KEY,
nombres VARCHAR(100) NOT NULL,
apellidos VARCHAR(100) NOT NULL,
tipoDocumento VARCHAR(2) NOT NULL,
numeroDocumento NUMERIC(20) NOT NULL,
edad INT NOT NULL,
ciudadId INT DEFAULT NULL,
CONSTRAINT fkCiudad FOREIGN KEY (ciudadId) REFERENCES Ciudades (idCiudad)
);

DROP TABLE IF EXISTS Tarjetas;
CREATE TABLE Tarjetas (  
idTarjeta NUMERIC(16) NOT NULL PRIMARY KEY, 
fechaVencimiento DATE NOT NULL,
fechaCreacion DATE NOT NULL,
saldo NUMERIC(20) NOT NULL,
productoID INT DEFAULT NULL,
clienteID INT DEFAULT NULL,
estadoID  INT DEFAULT NULL,
CONSTRAINT fkproductoTarjeta FOREIGN KEY (productoID) REFERENCES Productos (idProducto),
CONSTRAINT fkClienteTarjeta FOREIGN KEY (clienteID)  REFERENCES Clientes  (idCliente),
CONSTRAINT fkEstadoTarjeta FOREIGN KEY (estadoID)   REFERENCES Estados (idEstado)
);

DROP TABLE IF EXISTS Transacciones;
CREATE TABLE Transacciones (  
idTransaccion INT auto_increment PRIMARY KEY,
fechaMovimiento DATE NOT NULL,
valor NUMERIC(20) NOT NULL,
productoID INT DEFAULT NULL,
tarjetaID NUMERIC(16) DEFAULT NULL,
estadoID  INT DEFAULT NULL,
CONSTRAINT fkProductoTransaccion FOREIGN KEY (productoID) REFERENCES Productos(idProducto),
CONSTRAINT fkTarjetaTransaccion FOREIGN KEY  (tarjetaID)  REFERENCES Tarjetas (idTarjeta),
CONSTRAINT fkEstadoTransaccion FOREIGN KEY (estadoID)   REFERENCES Estados (idEstado)
);

DROP TABLE IF EXISTS Recargas;
CREATE TABLE Recargas (  
idRecarga INT auto_increment PRIMARY KEY,
fechaRecarga DATE NOT NULL,
valor NUMERIC(20) NOT NULL,
tarjetaID NUMERIC(16) DEFAULT NULL,
CONSTRAINT fkTarjetaRecargas FOREIGN KEY  (tarjetaID)  REFERENCES Tarjetas (idTarjeta)
);