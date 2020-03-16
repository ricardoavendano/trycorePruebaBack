/*-------------------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
  idusuario VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  PRIMARY KEY (idusuario));
 
INSERT INTO usuario (idusuario, password) VALUES 
('usuario1', 'dXN1YXJpbzE='),
('usuario2', 'dXN1YXJpbzI=');

 /*-------------------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS persona;
CREATE TABLE persona (
  idpersona INT NOT NULL,
  idplanetaPK INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  height VARCHAR(100) NULL,
  mass VARCHAR(100) NULL,
  haircolor VARCHAR(100) NULL,
  skincolor VARCHAR(100) NULL,
  eyecolor VARCHAR(100) NULL,
  birthyear VARCHAR(100) NULL,
  gender VARCHAR(100) NULL,
  PRIMARY KEY (idpersona));
 
 
ALTER TABLE persona 
ADD CONSTRAINT idplanetaPK
    FOREIGN KEY (idplanetaPK)
    REFERENCES planeta (idplaneta);
 
/*-------------------------------------------------------------------------------------------*/

DROP TABLE IF EXISTS planeta;
CREATE TABLE planeta (
  idplaneta INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  rotationperiod VARCHAR(45) NULL,
  orbitalperiod VARCHAR(45) NULL,
  diameter VARCHAR(45) NULL,
  climate VARCHAR(45) NULL,
  gravity VARCHAR(45) NULL,
  terrain VARCHAR(45) NULL,
  surfacewater VARCHAR(45) NULL,
  population VARCHAR(45) NULL,
  PRIMARY KEY (idplaneta));
 
/*-------------------------------------------------------------------------------------------*/
 
 DROP TABLE IF EXISTS controladorplaneta;
CREATE TABLE controladorplaneta (
  idplaneta INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  contador INT NOT NULL,
  PRIMARY KEY (idplaneta));
 
/*-------------------------------------------------------------------------------------------*/
 
  DROP TABLE IF EXISTS controladorpersona;
CREATE TABLE controladorpersona (
  idpersona INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  contador INT NOT NULL,
  PRIMARY KEY (idpersona));
 
/*-------------------------------------------------------------------------------------------*/