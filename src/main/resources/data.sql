INSERT INTO usuarios (nombre, apellido, email, telefono) VALUES
    ('Juan', 'Perez', 'juanperez@gmail.com', '999769992'),
    ('Rodrigo', 'Rojas', 'r.rojas@gmail.com', '956434211'),
    ('Brayan', 'Maldonado', 'mb1877@gmail.com', '998552313'),
    ('Jorge', 'Valdes', 'j.valdes.j@gmail.com', '908671020'),
    ('Ramiro', 'Prato', 'prato.ramiro@gmail.com', '912993461');


INSERT INTO productos (nombre, descripcion, precio, categoria) VALUES
    ('Perfume vainilla', 'Perfume con un delicioso olor a vainilla', '30.000', 'Perfumes'),
    ('Perfume Ben 10', 'Perfume con olor a limon', '10.000', 'Perfumes'),
    ('Essence Mystique', 'Perfume floral con notas de jazmín y vainilla', '59.900', 'Perfumes'),
    ('Ocean Breeze', 'Fragancia fresca con notas cítricas y acuáticas', '49.750', 'Perfumes'),
    ('Noir Élégance', 'Perfume oriental con notas de ámbar y madera de sándalo, para la noche', '68.400', 'Perfumes');


INSERT INTO inventario (id, stock, producto_id) VALUES
    ('INV001', 50, 1),
    ('INV002', 30, 2);

