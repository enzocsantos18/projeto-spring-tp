/* DROPS SEQUENCIAIS */
DROP TABLE IF EXISTS Tag_Receita;
DROP TABLE IF EXISTS Receita;
DROP TABLE IF EXISTS Categoria;

/* TABLE CATEGORIA */
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
CREATE TABLE IF NOT EXISTS Receita (
    ID SERIAL PRIMARY KEY,
    NOME VARCHAR(100),
    LINK_IMG TEXT,
    TEMPO TIME,
    QT_PORCAO INT,
    ID_CATEGORIA INT,
    INGREDIENTES TEXT,
    MODO_PREPARO TEXT,
    CONSTRAINT FK_CATEGORIA
      FOREIGN KEY(ID_CATEGORIA) 
	  REFERENCES Categoria(ID)
);

INSERT INTO Receita(NOME, LINK_IMG, TEMPO, QT_PORCAO, ID_CATEGORIA, INGREDIENTES, MODO_PREPARO) VALUES 
   ('Torta Holandesa', 
    'https://s2.glbimg.com/rxm3dIbR2Xs-L7ZF1f58jC7UXu4=/0x0:1280x800/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_1f540e0b94d8437dbbc39d567a1dee68/internal_photos/bs/2021/y/0/6d1XBjQVK7smLQJVkq5A/torta-holandesa-como-fazer.jpg', 
    '00:45:00', 
    8, 
    5, 
    'Para Base: 1. Bolacha; 2. Manteiga;

    Para o recheio: 1. 250 gramas de margarina; 2. 180 gramas de açúcar refinado; 3. 600 mililitros de creme de leite sem soro; 4. 80 mililitros de leite condensado;',
   'Para o creme: 1. Bata na batedeira a margarina e o açúcar até obter um creme próximo ao branco; 2. Acrescente o leite condensado e continue batendo; 3. Em seguida, adicione o creme de leite e mexa bem;');
INSERT INTO Receita(NOME, LINK_IMG, TEMPO, QT_PORCAO, ID_CATEGORIA, INGREDIENTES, MODO_PREPARO) VALUES 
   ('Macarrão ao alho e o oleo', 
    'https://img.itdg.com.br/tdg/images/recipes/000/057/710/324571/324571_original.jpg?mode=crop&width=710&height=400', 
    '00:15:00', 
    1, 
    3, 
    '1. 5 dentes de alho amassados
     2. 5 colheres de sopa de óleo
     3. 1 colher de sopa de manteiga
     4. Sal a gosto',
     '1. Amasse bem o alho juntamente com o sal, formando uma pasta;
     2. Em uma frigideira, coloque o alho amassado e o óleo;
     3. Frite em fogo médio sem deixar o alho queimar, só dourar;
     4. Acrescente a manteiga e deixe ferver um pouco, só para incorporar bem o sabor, mexendo sempre;
     5. Coloque sobre o macarrão imediatamente;');

/* TABLE TAG_RECEITA */
CREATE TABLE IF NOT EXISTS Tag_Receita (
    ID_RECEITA INT,
    ID_TAG INT,
    PRIMARY KEY (ID_RECEITA, ID_TAG),
    CONSTRAINT FK_RECEITA
      FOREIGN KEY(ID_RECEITA) 
	  REFERENCES Receita(ID),
   CONSTRAINT FK_TAG
      FOREIGN KEY(ID_TAG) 
	  REFERENCES Tag(ID)
);


INSERT INTO Tag_Receita(ID_RECEITA, ID_TAG) VALUES (1,1); 
INSERT INTO Tag_Receita(ID_RECEITA, ID_TAG) VALUES (1,3);
INSERT INTO Tag_Receita(ID_RECEITA, ID_TAG) VALUES (2,1);
INSERT INTO Tag_Receita(ID_RECEITA, ID_TAG) VALUES (2,5);