CREATE TABLE POI (
   id BIGINT AUTO_INCREMENT NOT NULL,
   latitud DECIMAL NOT NULL,
   longitud DECIMAL NOT NULL,
   nombre VARCHAR(100) NOT NULL,
   descripcion VARCHAR(255) NULL default NULL,
   categoria VARCHAR(100) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO POI(latitud, longitud, nombre, descripcion, categoria)
VALUES(-34.58791299400182,-58.423084840222,'Rapa nui','Una rica heladeria','heladeria');
INSERT INTO POI(latitud, longitud, nombre, descripcion, categoria)
VALUES(-34.58958675108932,-58.42795175118532,'Freddo','Otra heladeria','heladeria');
INSERT INTO POI(latitud, longitud, nombre, descripcion, categoria)
VALUES(-34.58428917744298, -58.43766774433044,'Buenos aires verde','Un restaurant verde','restaurant');
