drop database if exists agenda;
create database agenda;
use agenda;

create table personas(
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    telefono VARCHAR(11) NOT NULL,
    cumpleanos VARCHAR(50)
);

create table empresas(
    cial VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    telefono VARCHAR(11) NOT NULL,
    web VARCHAR(50)
);

/*no estoy segura de esto de abajo*/

create table actividades_personas(
    dni VARCHAR(9) NOT NULL,
    hora VARCHAR(5),
    lugar VARCHAR(50) NOT NULL,
    actividad VARCHAR(200) NOT NULL,
    PRIMARY KEY (dni),
    FOREIGN KEY (dni) REFERENCES personas(dni)
);

create table actividades_empresas(
    cial VARCHAR(10) NOT NULL,
    hora VARCHAR(5),
    lugar VARCHAR(50) NOT NULL,
    actividad VARCHAR(200) NOT NULL,
    PRIMARY KEY (cial),
    FOREIGN KEY (cial) REFERENCES empresas(cial)
);

/*

se debe de crear una tabla de actividades relacionada con las empresas y/o usuarios de la agenda.

....

Volver a poner las clases como antes: contacto(id, tipo, nombre, tlfn) persona(cumpleaños) empresa(web)

los traits sera lo de "actividades", q se implementará en persona y empresa. 

la bbdd sera persona, empresa y actividades, donde tendra de attrib (id, actividad), donde id sera el 
id de la persona o de la empresa (creo q la pk sera compuesta por esas dos)


SEGUIR LA ESTRUCTURA DEL ARCHIVO ejemplo-php-poo-mvcArchivo DE LA PLATAFORMA.


*/