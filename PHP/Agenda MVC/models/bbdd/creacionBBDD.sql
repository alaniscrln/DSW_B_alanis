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