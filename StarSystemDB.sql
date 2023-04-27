DROP DATABASE IF EXISTS StarSystemDB;
CREATE DATABASE StarSystemDB;
USE StarSystemDB;

DROP TABLE IF EXISTS StarSystem;
DROP TABLE IF EXISTS Planet;
DROP TABLE IF EXISTS Moon;

CREATE TABLE StarSystem(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50))
;

CREATE TABLE Planet(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
starsystem_ID INT,
name VARCHAR(50),
FOREIGN KEY(starsystem_ID) REFERENCES StarSystem(id))
;

CREATE TABLE Moon(
id INT PRIMARY KEY AUTO_INCREMENT,
planet_ID INT,
name VARCHAR(50),
FOREIGN KEY(planet_ID) REFERENCES Planet(id))
;

INSERT INTO StarSystem(name) 
VALUES
('Solar System'), 
('Canis Majoris');

INSERT INTO Planet(starsystem_ID, name) 
VALUES
(1,'Mercury'),
(1,'Venus'),
(1,'Earth'),
(1,'Mars'),
(1,'Jupiter'),
(1,'Saturn'),
(1,'Uranus'),
(1,'Neptune'),
(2, 'Sirius A'),
(2, 'Sirius B');

INSERT INTO Moon(planet_ID, name) 
VALUES 
(3, 'Luna'),
(4, 'Phobos'),
(4, 'Deimos'),
(5, 'Ganymede'),
(5, 'Callisto'),
(5, 'Io'),
(5, 'Europa'),
(5, 'Amalthea'),
(5, 'Himalia'),
(6, 'Mimas'),
(6, 'Enceladus'),
(6, 'Tethys'),
(6, 'Dione'),
(6, 'Rhea'),
(6, 'Titan'),
(6, 'Iapetus'),
(7, 'Titania'),
(7, 'Oberon'),
(7, 'Umbriel'),
(7, 'Ariel'),
(7, 'Miranda'),
(8, 'Triton'),
(8, 'Proteus'),
(8, 'Nereid');




