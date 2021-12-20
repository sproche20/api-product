CREATE TABLE IF NOT EXISTS usuario
(
    id serial,
    username varchar(45) not null,
    password varchar(45) not null ,
    PRIMARY KEY (id),
    UNIQUE (username)
    );
