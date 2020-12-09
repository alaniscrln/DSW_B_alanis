drop database if exists agenda;
create database agenda;
use agenda;

create table direcciones(
    dni varchar(9) primary key,
    Nombre  varchar(100),
    Apellidos varchar(100)
);