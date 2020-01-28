CREATE TABLE `sysonetest`.`variante` ( `id` INT NOT NULL AUTO_INCREMENT , `nombre` VARCHAR(255) NOT NULL , `precio` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = MyISAM;
CREATE TABLE `sysonetest`.`opcion` ( `id` INT NOT NULL AUTO_INCREMENT , `nombreOpcion` VARCHAR(255) NOT NULL , `codigoOpcion` VARCHAR(5) NOT NULL , `precio` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = MyISAM;

CREATE TABLE `sysonetest`.`variante_opciones` ( `id` INT NOT NULL AUTO_INCREMENT , `idOpcion` INT NOT NULL , `idVariante` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = MyISAM;


CREATE TABLE `sysonetest`.`auto` ( `id` INT NOT NULL AUTO_INCREMENT , `codigoAuto` INT , `idOpcion` INT  , `idVariante` INT  , PRIMARY KEY (`id`)) ENGINE = MyISAM;
ALTER TABLE auto ADD CONSTRAINT FK_opcion FOREIGN KEY (idOpcion) REFERENCES opcion(id)
ALTER TABLE auto ADD CONSTRAINT FK_variante FOREIGN KEY (IdVariante) REFERENCES variante(id)

INSERT INTO `variante` (`nombre`, `precio`) VALUES ( 'Básico Sedán', 230000),( 'Básico Familiar', 245000),('Básico Coupé',270000)

INSERT INTO `opciones`(`nombreOpcion`, `codigoOpcion`, `precio`) VALUES ('Techo Corredizo','TC',12000),('Aire acondicionado','AA',20000),('Sistemas de frenos ABS','ABS',14000),('Airbag','AB',7000),('Llantas de aleación','LL',12000)

INSERT INTO `auto`( `codigoAuto`, `idOpcion`, `idVariante`) VALUES (1,1,1),(1,2,1), (1,5,1),(2,3,1)