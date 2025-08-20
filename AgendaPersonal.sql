drop database if exists agenda_personal;
create database agenda_personal;
use agenda_personal;
 
create table Contactos(
	codigo_contactos integer auto_increment,
    nombre varchar (64),
    apellido varchar (64),
    telefono varchar (16),
    correo varchar (128),
    constraint pk_contacto primary key (codigo_contactos)
);
 
 
insert into Contactos (nombre, apellido, telefono, correo)
values
('Carlos', 'Ramírez', '5551-2345', 'carlos.ramirez@example.com'),
('Ana', 'González', '5551-6789', 'ana.gonzalez@example.com'),
('Luis', 'Mendoza', '5552-9876', 'luis.mendoza@example.com');
 
select * from Contactos;