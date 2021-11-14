/* TABLE CATEGORIA */
DROP TABLE IF EXISTS Categoria;

CREATE TABLE IF NOT EXISTS Categoria (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100)
);

INSERT INTO Categoria(NOME) VALUES ('Saladas');
INSERT INTO Categoria(NOME) VALUES ('Sopas');
INSERT INTO Categoria(NOME) VALUES ('Massas');
INSERT INTO Categoria(NOME) VALUES ('Carnes');
INSERT INTO Categoria(NOME) VALUES ('Sobremesas');

/* TABLE TAGS */
DROP TABLE IF EXISTS Tag;

CREATE TABLE IF NOT EXISTS Tag (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100)
);

INSERT INTO Tag(NOME) VALUES ('Rápidas');
INSERT INTO Tag(NOME) VALUES ('Light');
INSERT INTO Tag(NOME) VALUES ('Vegetariana');
INSERT INTO Tag(NOME) VALUES ('Vegana');
INSERT INTO Tag(NOME) VALUES ('Sem forno');

/* TABLE RECEITA */
DROP TABLE IF EXISTS Receita;

CREATE TABLE IF NOT EXISTS Receita (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100),
    LINK_IMG TEXT,
    TEMPO TIME,
    QT_PORCAO TINYINT,
    ID_CATEGORIA INT,
    INGREDIENTES TEXT,
    MODO_PREPARO TEXT,
    CONSTRAINT FK_CATEGORIA
      FOREIGN KEY(ID_CATEGORIA) 
	  REFERENCES Categoria(ID)
);

/* TABLE TAG_RECEITA */
DROP TABLE IF EXISTS Tag_Receita;

CREATE TABLE IF NOT EXISTS Tag_Receita (
    ID_RECEITA PRIMARY KEY,
    ID_TAG PRIMARY KEY,
    CONSTRAINT FK_RECEITA
      FOREIGN KEY(ID_RECEITA) 
	  REFERENCES Receita(ID),
   CONSTRAINT FK_TAG
      FOREIGN KEY(ID_TAG) 
	  REFERENCES Tag(ID),
);

