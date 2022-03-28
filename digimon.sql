DROP DATABASE IF EXISTS digimon;
CREATE DATABASE digimon character set Latin1 collate latin1_general_ci;
USE digimon;

CREATE TABLE jugador(
    nick varchar(30) PRIMARY KEY,
    contraseña varchar(20) not null,
    p_ganadas int DEFAULT 0,
    p_jugadas int DEFAULT 0
);

CREATE TABLE digimon (
    nomDig varchar (30) PRIMARY KEY,
    ataque int not null,
    defensa int not null,
    tipo ENUM ('vacuna','virus', 'animal', 'planta', 'elemental') not null,
    imagen varchar(50),
    imagen_g varchar(50),
    imagen_p varchar(50),
    nivel int not null,
    nomDigiEv varchar (30),
    ADD CONSTRAINT fk_tiene_jug FOREIGN KEY (nick) REFERENCES jugador (nick) ON DELETE NO ACTION ON UPDATE CASCADE,
    ADD CONSTRAINT fk_tiene_digimon FOREIGN KEY (nomDig) REFERENCES digimon(nomDig) ON DELETE NO ACTION ON UPDATE CASCADE;
);

CREATE TABLE tiene (
    nick varchar (30),
    nomDig varchar (30),
    esta_equipo ENUM ('si','no') DEFAULT 'no' ,  
    PRIMARY KEY (nick, nomDig)
);





