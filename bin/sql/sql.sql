drop database site_cfa;
CREATE database site_cfa;
use site_cfa;

CREATE TABLE CLASSE(
   idclasse int(3) not null auto_increment,
   nom VARCHAR(50) NOT NULL,
   nb_eleve SMALLINT,
   salle INT,
   diplome VARCHAR(50),
   PRIMARY KEY(idclasse)
);

CREATE TABLE PROFESSEUR(
   idprofesseur int(3) not null auto_increment,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   email VARCHAR(50) NOT NULL,
   specialite VARCHAR(50) NOT NULL,
   mdp VARCHAR(50) NOT NULL,
   PRIMARY KEY(idprofesseur)
);

CREATE TABLE ADMINISTRATION(
   idadmin int(3) not null auto_increment,
   nom VARCHAR(50),
   prenom VARCHAR(50),
   email VARCHAR(50) NOT NULL,
   mdp VARCHAR(50) NOT NULL,
   role VARCHAR(50) NOT NULL,
   PRIMARY KEY(idadmin)
);

CREATE TABLE ETUDIANT(
   idetudiant int(3) auto_increment not null,
   nom VARCHAR(50) NOT NULL,
   prenom VARCHAR(50) NOT NULL,
   date_naissance DATE,
   statut VARCHAR(50) NOT NULL,
   moyenne DECIMAL(2,2),
   email VARCHAR(50) NOT NULL,
   mdp VARCHAR(50) NOT NULL,
   idclasse int(3) not null,
   PRIMARY KEY(idetudiant),
   FOREIGN KEY(idclasse) REFERENCES CLASSE(idclasse)
);

CREATE TABLE intervenir(
   idclasse int(3) not null,
   idprofesseur int(3) not null,
   horaire DATETIME,
   matiere VARCHAR(50) NOT NULL,
   coeff INT NOT NULL,
   nb_heures INT,
   PRIMARY KEY(idclasse, idprofesseur),
   FOREIGN KEY(idclasse) REFERENCES CLASSE(idclasse),
   FOREIGN KEY(idprofesseur) REFERENCES PROFESSEUR(idprofesseur)
);

-- CLASSE
insert into classe values ( null, "promotion 250", 40, 211, "bts sio option slam"); 
insert into classe values ( null, "promotion 250", 25, 218, "bts comptabilité"); 

--PROFESSEUR
insert into professeur values (null, "Benahmed", "Okacha", "o.benahmed@gmail.com", "Informatique", 123);
insert into professeur values (null, "Marchand", "Arnaud", "a.marchandd@gmail.com", "Anglais", 456);
insert into professeur values (null, "Guillaume", "Noël", "n.guillaume@gmail.com", "Mathèmatiques", 789);


-- ADMINISTRATION
insert into administration values (null, "Coste", "Mounira", "m.coste@gmail.com", 147, "admin");
insert into administration values (null, "Sert", "Selin", "s.sert@gmail.com", 258, "admin");
insert into administration values (null, "Test", "Le", "l.test@gmail.com", 098, "user");

-- ETUDIANT
insert into etudiant values (null, "Mendy", "David", 2003/20/12, "Alternant", 17, "d.mendy@gmail.com", 369, 1);
insert into etudiant values (null, "Deng", "Marie", 2003/30/06, "Alternant", 16, "m.deng@gmail.com", 753, 1);
insert into etudiant values (null, "Chardon", "Julia", 1995/05/02, "Initial", 15, "j.chardon@gmail.com", 951, 2);

-- INTERVENIR

insert into intervenir values (1,1, null, "Modelisation", 5, 3);
insert into intervenir values (2,2, null, "Anglais comptabilite", 2, 2);
insert into intervenir values (1,3, null, "Algebre", 3, 4);
