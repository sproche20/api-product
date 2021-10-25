CREATE TABLE  IF NOT EXISTS Product
(
    id serial ,
    description VARCHAR (45) NOT NULL,
    details VARCHAR (45) NULL ,
    PRIMARY KEY (id)
);