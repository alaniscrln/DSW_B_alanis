drop database if exists agenda;
create database agenda;
use agenda;

create table contactos(
    id VARCHAR(20) NOT NULL PRIMARY KEY,
    tipo VARCHAR(8) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    telefono VARCHAR(11) NOT NULL
);

create table actividades(
    id VARCHAR(20) NOT NULL,
    idContacto VARCHAR(20) NOT NULL,
    hora VARCHAR(5),
    fecha VARCHAR(5),
    lugar VARCHAR(50) NOT NULL,
    actividad VARCHAR(200) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idContacto) REFERENCES contactos(id)
);

create table empresas(
    id VARCHAR(20) NOT NULL,
    web VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (id) REFERENCES contactos(id)
);

create table personas(
    id VARCHAR(20) NOT NULL,
    cumpleanos VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (id) REFERENCES contactos(id)
);
