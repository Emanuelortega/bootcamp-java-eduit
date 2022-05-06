/* CREAR UNA TABLE DESDE SQL*/
/* CREAR TABLAS*/
CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	username VARCHAR (50) NOT NULL,
	PASSWORD VARCHAR (100) NOT NULL
);

/* INSERT DE DATOS EN UNA TABLA*/

INSERT INTO users(username, PASSWORD)VALUES('eduit', 'eduit');

/* VER LOS REGISTRO DE LA TABLA */

SELECT * FROM users;

/*VER LOS REGISTROS, PERO NO TODOS */
SELECT username FROM users;

INSERT INTO users(username, PASSWORD)VALUES('root', '1234');
INSERT INTO users(username, PASSWORD)VALUES('admin', '12345');
INSERT INTO users(username, PASSWORD)VALUES('guess', 'guess');

SELECT * FROM users;

/*FILTRAR DATOS DE UNA TABLA USANDO WHERE*/

SELECT * FROM users WHERE username= 'guess';

/**/

CREATE TABLE articulos (

	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	titulo VARCHAR (100) NOT NULL,
	codigo VARCHAR (10) NOT NULL, /* unico*/
	fecha_creacion DATE NOT NULL,
	precio FLOAT NOT NULL,
	stock INT NOT NULL,
	marca_id INT NOT NULL,
	categoria_id INT NOT NULL 
)

/*TABLAS MAESTROS*/

	CREATE TABLE categorias(
	
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	descripcion VARCHAR (100) NOT NULL,
	habilitada INT NOT NULL
	);

	CREATE TABLE marcas(
	
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	descripcion VARCHAR (100)NOT NULL,
	habilitada INT NOT NULL
	
	);

/*INSERTAR REGISTROS EN MARCAS*/

INSERT INTO marcas(descripcion, habilitada) VALUES ('nike', 1);
INSERT INTO marcas(descripcion, habilitada) VALUES ('adidas', 1);

	SELECT * FROM marcas;
	
	
	/*INSERT INTO ARTICULOS*/
	
	INSERT INTO articulos(TITULO,CODIGO,PRECIO,FECHA_CREACION,MARCA_ID,CATEGORIA_ID,STOCK)
	VALUES('ZAPATILLA NIKE', '0000000001',15000,CURDATE(), 1,1,10);
	
	SELECT * FROM  articulos;
	
	
	
	INSERT INTO categorias (descripcion, habilitada)VALUES('libros', 1);
	SELECT * FROM categorias
	
	
	
	/*CREAR UNA CLAVE FORANEA VIA SCRIP*/
	
	ALTER TABLE articulos 
	ADD CONSTRAINT FK_articulos_categorias
	 FOREIGN KEY (categoria_id)
		REFERENCES categorias(id);

/*modificar datos de una tabla */
/*ANTES DE EJECUTAR UN UPDATE, PRIMERO PONGAN "EL WHERE"Y DESPUES HAGAN UN SELECT */
SELECT * FROM articulos WHERE id = 1;

UPDATE articulos 
SET titulo= 'ZAPATILLAS'
WHERE ID =1;

/* modificar mas de un campo a la vez */

UPDATE articulos 
SET titulo= 'ZAPATILLAS', stock=5, categoria_id=1
WHERE ID =1;

SELECT * FROM articulos; 

/*eliminar un registro de una tabla*/

DELETE FROM categorias WHERE id = 3;/*revisar valor*/

/*resumen
creacion de tablas:
CREATE TABLE <NOMBRE>

INSERT DE DATOS:
INSERT INTO <TABLA>(CAMPOS...)VALUES(...)

ACTUALIZACION DE REGISTROS 
UPDATE TABLA SET CAMPO1= VALOR1,CAMPOn=VALORn... WHERE <CAMPO>=<VALOR>

ELIMINAR REGISTROS
DELETE FROM TABLA WHERE CAMPO=VALOR

CONSTRAIN 
FK=CLAVE FORANEA

CARDINALIDAD

*/

/* CREAR TABLA NEWSLATTERS*/
CREATE TABLE newslatters(

id INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
email VARCHAR (100) NOT NULL, 
fecha_registro DATE NOT NULL
);
