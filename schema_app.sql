CREATE DATABASE IF NOT EXISTS prog2_app;

USE prog2_app;

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE categorias (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE transacciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255),
    monto DECIMAL(10,2) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    usuario_id INT NOT NULL,
    categoria_id INT NOT NULL,

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);