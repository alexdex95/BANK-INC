DROP TABLE IF EXISTS Estados;
CREATE TABLE Estados (
idEstado INT auto_increment PRIMARY KEY,
descripcion varchar(50) NOT NULL,
funcion varchar(15) NOT NULL,
PRIMARY KEY (idEstado)
);

DROP TABLE IF EXISTS Productos;
CREATE TABLE Productos (
idProducto INT auto_increment PRIMARY KEY,
numeroProducto varchar(6) NOT NULL, 
descripcion varchar(50) NOT NULL,
PRIMARY KEY (idProducto)
);

DROP TABLE IF EXISTS Tarjetas;
CREATE TABLE Tarjetas (  
idTarjeta NUMERIC(16) NOT NULL PRIMARY KEY,
nombreTitular varchar(100) NOT NULL, 
fechaVencimiento DATETIME NOT NULL,
fechaCreacion DATETIME NOT NULL,
saldo NUMERIC(20) NOT NULL,
productoID INT DEFAULT NULL,
estadoID  INT DEFAULT NULL,
CONSTRAINT fkproductoTarjeta FOREIGN KEY (productoID) REFERENCES Productos (idProducto),
CONSTRAINT fkEstadoTarjeta FOREIGN KEY (estadoID)   REFERENCES Estados (idEstado)
);

DROP TABLE IF EXISTS Transacciones;
CREATE TABLE Transacciones (  
idTransaccion INT auto_increment PRIMARY KEY,
fechaMovimiento DATETIME NOT NULL,
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
fechaRecarga DATETIME NOT NULL,
valor NUMERIC(20) NOT NULL,
tarjetaID NUMERIC(16) DEFAULT NULL,
CONSTRAINT fkTarjetaRecargas FOREIGN KEY  (tarjetaID)  REFERENCES Tarjetas (idTarjeta)
);