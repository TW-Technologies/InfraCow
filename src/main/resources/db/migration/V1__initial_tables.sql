create table animal(
	id int PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255),
	especie VARCHAR(255),
	peso DECIMAL(10,2)
	idade int,
	fk_id_usuario int,
	foreign key (fk_id_usuario) references usuario(id)
);

create table usuario(
	id int PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	senha VARCHAR(255)
);

CREATE TABLE Imagem (
    id INT PRIMARY KEY,
    id_animal INT,
    nome VARCHAR(255),
    metadados Varchar(255),
    resultados_analise Varchar(255),
    data_captura DATE,
    extensao VARCHAR(10),
    informacoes_adicionais_animal varchar(255),
    local_captura varchar(255),
    mapa_de_calor varchar(255),
    FOREIGN KEY (id_animal) REFERENCES Animal(id) -- Supondo que exista uma tabela 'Animal'
);