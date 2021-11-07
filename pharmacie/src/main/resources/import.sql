
/** CREATION DU JEU DE DONNEES POUR TEST**/

ALTER SEQUENCE utilisateur_id_seq RESTART WITH 1;
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom)	VALUES 	((select nextval('utilisateur_id_seq')),'21 rue de Java, 59000 Lille','toto@gmail.com','toto', 'DUPONT', 'Toto' );
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom)	VALUES 	((select nextval('utilisateur_id_seq')),'22 rue de Java, 59000 Lille','titi@gmail.com','titi', 'DUPONT', 'Titi');
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom)	VALUES 	((select nextval('utilisateur_id_seq')),'23 rue de Java, 59000 Lille','tete@gmail.com', 'tete','DUPONT', 'Tete');
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom) VALUES ((select nextval('utilisateur_id_seq')), '8 version java, 59000 lille','user@gmail.com','user','USER', 'User');

ALTER SEQUENCE article_id_seq RESTART WITH 1;
INSERT INTO public.article(id, description, designation, quantite)VALUES ((select nextval('article_id_seq')), 'Antalgique et anti_inflamatoire', 'Aspirine', 10);
INSERT INTO public.article(id, description, designation, quantite)VALUES ((select nextval('article_id_seq')),' Antalgique anti-douleur','Paracetamol', 10);
INSERT INTO public.article(id, description, designation, quantite)VALUES ((select nextval('article_id_seq')), 'Anti-inflamatoire',' Ibuprofène', 10);
