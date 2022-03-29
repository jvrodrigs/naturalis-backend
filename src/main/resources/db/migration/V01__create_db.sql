CREATE TABLE cliente (
     id SERIAL PRIMARY KEY,
     nome VARCHAR(50) NOT NULL,
     telefone VARCHAR(50) NOT NULL,
     logradouro VARCHAR(30),
     numero VARCHAR(30),
     complemento VARCHAR(30),
     bairro VARCHAR(30),
     cep VARCHAR(30),
     cidade VARCHAR(30),
     estado VARCHAR(30),
     ativo BOOLEAN NOT NULL
);

CREATE TABLE status(
    id SERIAL  PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);


CREATE TABLE substancias (
     id SERIAL PRIMARY KEY,
     descricao VARCHAR(200) NOT NULL,
     potencia VARCHAR(50) NOT NULL,
     nfe VARCHAR(50),
     laboratorio VARCHAR(50) NOT NULL,
     lote_origem VARCHAR(50) NOT NULL,
     lote_interno VARCHAR(50),
     data_fabricacao DATE NOT NULL,
     data_validade DATE NOT NULL
);

CREATE TABLE produto (
     id SERIAL PRIMARY KEY,
     codigo_referencia VARCHAR(50) NOT NULL,
     nome VARCHAR(50) NOT NULL,
     descricao VARCHAR(100),
     fabricante VARCHAR(50) NOT NULL,
     criado_em DATE NOT NULL
);

CREATE TABLE funcionario (
     id SERIAL PRIMARY KEY,
     nome VARCHAR(50) NOT NULL,
     username VARCHAR(50) NOT NULL,
     cpf VARCHAR(50) NOT NULL,
     email VARCHAR(50) NOT NULL,
     senha VARCHAR(150) NOT NULL
);

CREATE TABLE permissao (
   id SERIAL PRIMARY KEY,
   descricao VARCHAR(50) NOT NULL
);

CREATE TABLE cargo (
   id SERIAL PRIMARY KEY,
   descricao VARCHAR(50) NOT NULL
);

CREATE TABLE funcionario_perm (
  funcionario_id INT NOT NULL,
  permissao_id INT NOT NULL,
  PRIMARY KEY (funcionario_id, permissao_id),
  FOREIGN KEY (funcionario_id) REFERENCES  funcionario(id),
  FOREIGN KEY (permissao_id) REFERENCES permissao(id)
);

CREATE TABLE funcionario_cargo(
  funcionario_id INT NOT NULL,
  cargo_id INT NOT NULL,
  PRIMARY KEY (funcionario_id, cargo_id),
  FOREIGN KEY (funcionario_id) REFERENCES  funcionario(id),
  FOREIGN KEY (cargo_id) REFERENCES cargo(id)
);

CREATE TABLE ordem_servico(
  id SERIAL PRIMARY KEY,
  cliente_id int NOT NULL,
  produto_id int NOT NULL,
  autor_id int NOT NULL,
  status_id int NOT NULL,
  descricao VARCHAR(150),
  valor_total VARCHAR(50) NOT NULL,
  responsavel_id int NOT NULL,
  criado_em DATE NOT NULL,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id),
  FOREIGN KEY (produto_id) REFERENCES produto(id),
  FOREIGN KEY (autor_id) REFERENCES funcionario(id),
  FOREIGN KEY (status_id) REFERENCES status(id),
  FOREIGN KEY (responsavel_id) REFERENCES funcionario(id)
);

CREATE TABLE substancia_prod (
 substancia_id INT NOT NULL,
 produto_id INT NOT NULL,
 PRIMARY KEY (substancia_id, produto_id),
 FOREIGN KEY (substancia_id) REFERENCES  substancias(id),
 FOREIGN KEY (produto_id) REFERENCES produto(id)
);