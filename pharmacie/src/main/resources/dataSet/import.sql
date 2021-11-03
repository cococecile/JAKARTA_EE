-- -----------------------------------------------------
----------------- Database pharma ----------------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Suppression Database pharma
-- -----------------------------------------------------
DROP DATABASE IF EXISTS pharma ;


-- -----------------------------------------------------
-- Création Database pharma
-- -----------------------------------------------------
CREATE DATABASE pharma
    WITH 
    OWNER = "user"
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;



-- -----------------------------------------------------
-- Table `pharma`.`Utilisateur`
-- -----------------------------------------------------
DROP table if exists utilisateur;

create table utilisateur (
id serial,
nom varchar,
prenom varchar,
adresse varchar,
email varchar,
mot_de_passe varchar,
primary key (id));




/** CREATION DU JEU DE DONNEES POUR TEST**/

INSERT INTO public.utilisateur(	id, nom, prenom, adresse, email, mot_de_passe)
	VALUES 
	(1, 'DUPONT', 'Toto', '21 rue de Java, 59000 Lille', 'toto@gmail.com', 'toto'),
	(2, 'DUPONT', 'Titi', '22 rue de Java, 59000 Lille', 'titi@gmail.com', 'titi'),
	(3, 'DUPONT', 'Tete', '23 rue de Java, 59000 Lille', 'tete@gmail.com', 'tete');