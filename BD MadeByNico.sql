drop SCHEMA if exists ProyectoWeb;
CREATE SCHEMA ProyectoWeb;

CREATE USER 'usuario_Admin'@'%' IDENTIFIED BY 'MadeByNico';

GRANT ALL PRIVILEGES ON ProyectoWeb.* to 'usuario_Admin'@'%';
flush privileges;


Create table ProyectoWeb.producto(
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre varchar(50),
  descripccion varchar(255),
  precio decimal (10,2),
  ruta_imagen text,
  tamanio decimal(10,2),
  color varchar(90)
);
CREATE TABLE ProyectoWeb.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(200) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  activo boolean,
 PRIMARY KEY (`id_usuario`)
 )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO ProyectoWeb.usuario (username,password,nombre, apellidos, correo,activo) VALUES 
('kevin','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Kevin', 'Garro Rodriguez','kev@gmail.com',true),
('juan','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Juan',  'Contreras Mora','jsanchez@gmail.com',true),
('isma','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Ismael', 'Mena Loria', 'ileon@gmail.com',true);



create table ProyectoWeb.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (`id_rol`),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into ProyectoWeb.rol ( nombre, id_usuario) values
 ('ROLE_ADMIN',1), ('ROLE_USER',1),
 ('ROLE_ADMIN',2), ('ROLE_USER',2),
 ('ROLE_ADMIN',3), ('ROLE_USER',3);




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

create table ProyectoWeb.item_carrito (
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    foreign key fk_item_carrito_usuario (id_usuario) references usuario(id_usuario),
    foreign key fk_item_carrito_producto (id_producto) references producto(id)
);

INSERT INTO ProyectoWeb.item_carrito (id_usuario, id_producto, cantidad)
VALUES 
	(1, 1, 5),
    (1, 2, 1),
    (1, 5, 2),
    (1, 6, 2),
    (2, 3, 5),
    (2, 7, 8),
    (3, 1, 10);
