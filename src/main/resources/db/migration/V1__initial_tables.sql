create table animal(
	id int PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255),
	especie VARCHAR(255),
	idade int,
	peso DECIMAL(10,2)
);

create table usuario(
	id int PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255)
);

CREATE TABLE Imagem (
    id INT PRIMARY KEY,
    id_animal INT,
    metadados TEXT,
    resultados_analise TEXT,
    data_captura DATE,
    extensao VARCHAR(10),
    nome VARCHAR(255),    
    FOREIGN KEY (id_animal) REFERENCES Animal(id) -- Supondo que exista uma tabela 'Animal'
);