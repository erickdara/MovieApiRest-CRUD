-- DROP TABLE IF EXISTS PELICULAS;
-- CREATE TABLE PELICULAS (
--                            id integer not null,
--                            pelicula varchar(100),
--                            genero varchar(100),
--                            puntaje integer,
--                            estudio varchar(100),
--                            anio varchar(100))
--     AS SELECT * FROM CSVREAD('src/main/resources/movies.csv');


DROP TABLE IF EXISTS PELICULAS;
CREATE TABLE PELICULAS AS SELECT * FROM CSVREAD('src/main/resources/movies.csv');


