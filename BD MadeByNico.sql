drop SCHEMA if exists ProyectoWeb;
CREATE SCHEMA ProyectoWeb;

CREATE USER 'usuario_Admin'@'%' IDENTIFIED BY 'MadeByNico';
drop user 'usuario_Admin'@'%';
GRANT ALL PRIVILEGES ON ProyectoWeb.* to 'usuario_Admin'@'%';
flush privileges;

Create table ProyectoWeb.usuarios(
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255),
  apellido VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255)
);
Create table ProyectoWeb.producto(
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(50),
  descripccion varchar(255),
  precio decimal (10,2),
  ruta_imagen text,
  tamanio decimal(10,2),
  color varchar(90)
);

INSERT INTO ProyectoWeb.producto (nombre, descripccion, precio, ruta_imagen, tamanio, color)
VALUES
    ('Gato', 'Diseño de gato hecho a mano', 4000, 'https://i.imgur.com/S7m9rBl.png', 13.0, 'Negro, blanco y rosado'),
    ('Nezuko', 'Diseño de nezuko kamado de demon slayer hecho a mano', 5500, 'https://i.imgur.com/PMuTTrC.png', 17.0, 'Negro, rosado, rojo y verde'),
    ('Perry el ornitorrinco', 'Diseño de perry el ornitorrinco de phineas y ferb', 5000, 'https://i.imgur.com/ifzKKiK.png', 19.5, 'Cafe, naranja y celeste'),
    ('Pochita', 'Diseño de pochita del anime Chainsaw Man', 3500, 'https://i.imgur.com/gjnqwIo.png', 13.4, 'Negro y naranja'),
    ('Chimuelo', 'Diseño de Chimuelo el dragon de "Como entrenar a tu dragon"', 3700, 'https://i.imgur.com/swF154j.png', 17.2, 'Negro'),
    ('Spiderman', 'Diseño del super heroe  aracnido Spiderman', 4200, 'https://i.imgur.com/s2W56LR.png', 20.1, 'Rojo, azul, negro y blanco'),
    ('Ballena', 'Diseño de una ballena hecho a mano', 2700, 'https://i.imgur.com/RwOcr3I.png', 13.4, 'Celeste con blanco'),
    ('Vaca colorida', 'Diseño de una vaca con colores inusuales', 6000, 'https://i.imgur.com/5zXjtSh.png', 25.7, 'Blanco, morado claro y oscuro'),
    ('Panda', 'Diseño de un panda hecho a mano', '5800', 'https://i.imgur.com/jW8DtoH.png', 19.2, 'Blanco y negro'),
    ('Stich', 'Diseño del personaje Stich de "Lilo y Stich"', '5000', 'https://i.imgur.com/6L1nEVd.png', 16.5, 'Azul claro y oscuro, negro y rosado');
    
    
INSERT INTO ProyectoWeb.usuarios (nombre, apellido, email, password)
VALUES ('John', 'Doe', 'JhonDemon@Gmail.com', '12345'),
('Jane', 'Smith', 'jane.smith@example.com', 'qwerty'),
('Michael', 'Johnson', 'michael.johnson@example.com', 'abc123');

