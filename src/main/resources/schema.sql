create table if not exists usuarios(
                         id int not null AUTO_INCREMENT,
                         email varchar(45) not null unique,
                         senha varchar(64) not null,
                         adm tinyint(1),
                         PRIMARY KEY ( ID )
);