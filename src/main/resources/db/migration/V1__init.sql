CREATE TABLE IF NOT EXISTS rutas
(
    id serial,
    ruta varchar(10) not null,
    tiempo varchar(30) null ,
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS chofer
(
    id serial,
    chofers varchar(10) not null ,
    cedula varchar (16) null ,
    licence numeric (16) null ,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS buses
(
    id serial,
    marcas varchar (16) not null,
    placas varchar (16) null ,
    pasageros numeric (16) not null ,
    id__chofer int,
    foreign key (id__chofer) references Chofer(id),
    PRIMARY KEY (id)
    );
CREATE  TABLE IF NOT EXISTS salid
(
    id serial ,
    salid numeric(10)not null ,
    horasal varchar(10)null,
    PRIMARY KEY (id),
    bus__id int,
    foreign key (bus__id) references buses(id),
    ruta__id int,
    foreign key (ruta__id) references Rutas(id)
    );