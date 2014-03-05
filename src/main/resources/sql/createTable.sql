/**
 * Création de la table Personne.
 */
create table personne(
	idPersonne INTEGER NOT NULL,
	nom VARCHAR(255) NOT NULL,
	dateNaissance date NOT NULL,
	PRIMARY KEY(idPersonne)
);

/**
 * Création de la table Amis.
 */
create table amis(
    id INTEGER NOT NULL AUTO_INCREMENT,
    idPersonne INTEGER NOT NULL,
	idFriend INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY(idPersonne) REFERENCES personne(idPersonne)
);

/**
 * Permet de créer la table pour la première stratégie
 */
create table personne_premiere_strategie(
	idPersonne INTEGER NOT NULL AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	dateNaissance date NOT NULL,
	personneType VARCHAR(255) not null,
	PRIMARY KEY(idPersonne)
);


/**
 * Permet de créer la table homme pour la seconde stratégie
 */
create table homme_seconde_strategie(
	idPersonne INTEGER NOT NULL AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	dateNaissance date NOT NULL,
	PRIMARY KEY(idPersonne)
);

/**
 * Permet de créer la table femme pour la seconde stratégie
 */
create table femme_seconde_strategie(
	idPersonne INTEGER NOT NULL AUTO_INCREMENT,
	nom VARCHAR(255) NOT NULL,
	dateNaissance date NOT NULL,
	PRIMARY KEY(idPersonne)
);

/**
 * Permet de créer la table homme pour la troisieme stratégie
 */
create table homme_troisieme_strategie(
	idPersonne INTEGER NOT NULL,
	PRIMARY KEY(idPersonne)
);

/**
 * Permet de créer la table femme pour la troisieme stratégie
 */
create table femme_troisieme_strategie(
	idPersonne INTEGER NOT NULL,
	PRIMARY KEY(idPersonne)
);

/**
 * Permet de créer la table pour la troisieme stratégie
 */
create table personne_troisieme_strategie(
	idPersonne INTEGER NOT NULL,
	nom VARCHAR(255) NOT NULL,
	dateNaissance date NOT NULL,
	personneType VARCHAR(255) not null,
	PRIMARY KEY(idPersonne)
);