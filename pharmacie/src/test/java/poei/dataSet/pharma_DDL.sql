-- -----------------------------------------------------
----------------- Database pharma ----------------------
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Suppression Database pharma
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `pharma` ;


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

USE `pharma` ;

-- -----------------------------------------------------
-- Table `pharma`.`Utilisateur`
-- -----------------------------------------------------
DROP table utilisateur;

create table utilisateur (
id_utilisateur serial,
nom varchar,
prenom varchar,
adresse varchar,
email varchar,
mot_de_passe varchar,
primary key (id_utilisateur));
