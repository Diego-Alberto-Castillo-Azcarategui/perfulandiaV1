
DROP TABLE IF EXISTS detalles_venta CASCADE;
DROP TABLE IF EXISTS inventario CASCADE;
DROP TABLE IF EXISTS productos CASCADE;
DROP TABLE IF EXISTS usuarios CASCADE;


CREATE TABLE usuarios (
                          id SERIAL PRIMARY KEY,
                          nombre VARCHAR(100),
                          apellido VARCHAR(100),
                          email VARCHAR(100),
                          telefono VARCHAR(20)
);

CREATE TABLE productos (
                           id SERIAL PRIMARY KEY,
                           nombre VARCHAR(255),
                           descripcion TEXT,
                           precio NUMERIC(10,2),
                           categoria VARCHAR(100)
);

CREATE TABLE inventario (
                            id VARCHAR(10) PRIMARY KEY,
                            stock INTEGER NOT NULL,
                            producto_id INTEGER NOT NULL,
                            FOREIGN KEY (producto_id) REFERENCES productos(id)
);

CREATE TABLE detalles_venta (
                                id SERIAL PRIMARY KEY,
                                cantidad INTEGER NOT NULL,
                                producto_id INTEGER NOT NULL,
                                FOREIGN KEY (producto_id) REFERENCES productos(id)
);

