drop SCHEMA if exists ProyectoWeb;
CREATE SCHEMA ProyectoWeb;

CREATE USER 'usuario_Admin'@'%' IDENTIFIED BY 'MadeByNico';

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
  color varchar(25)
);



