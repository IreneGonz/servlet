create table IF NOT EXISTS EQUIPO(
    id identity primary key,
    nombre varchar(25),
    
);
create table IF NOT EXISTS JUGADOR(
    id identity primary key,
	nombre varchar(25),
	apellido varchar(25),
    codEquipo int,
    foreign key (codEquipo) references EQUIPO(id) ON DELETE CASCADE,
);