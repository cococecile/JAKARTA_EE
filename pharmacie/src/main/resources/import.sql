
/** CREATION DU JEU DE DONNEES POUR TEST**/

INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom)	VALUES 	(1,'21 rue de Java, 59000 Lille','toto@gmail.com','toto', 'DUPONT', 'Toto' );
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom)	VALUES 	(2,'22 rue de Java, 59000 Lille','titi@gmail.com','titi', 'DUPONT', 'Titi');
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom)	VALUES 	(3,'23 rue de Java, 59000 Lille','tete@gmail.com', 'tete','DUPONT', 'Tete');
INSERT INTO utilisateur (id, adresse, email, mot_de_passe, nom, prenom) VALUES (4, '8 version java, 59000 lille','user@gmail.com','user','USER', 'User');


INSERT INTO public.article(id, description, designation, quantite)VALUES (01, 'Aspirine', 'Antalgique et anti_inflamatoire', 10);
INSERT INTO public.article(id, description, designation, quantite)VALUES (02, 'Paracetamol',' Antalgique anti-douleur', 10);
INSERT INTO public.article(id, description, designation, quantite)VALUES (03,' Ibuprofène', 'Anti-inflamatoire', 10);