create table usuarios(
	id int PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(255),
	senha VARCHAR(255)
);
create table animais(
	id int PRIMARY KEY AUTO_INCREMENT,
	especie VARCHAR(255),
	codigo_identificacao VARCHAR(255),
	peso DECIMAL(10,2),
	idade INT,
	id_usuario INT,
	FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);


CREATE TABLE imagens (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_animal INT,
    nome VARCHAR(255),
    metadados Varchar(255),
    data_captura DATE,
    extensao VARCHAR(10),
    informacoes_adicionais_animal varchar(255),
    local_captura varchar(255),
    mapa_de_calor varchar(255),
    FOREIGN KEY (id_animal) REFERENCES animais(id)
);

create table analises (
	id int PRIMARY KEY AUTO_INCREMENT,
	data_analise date,
    resultados_analise Varchar(255),
	id_imagem INT,
	FOREIGN KEY (id_imagem) REFERENCES imagens(id)
);