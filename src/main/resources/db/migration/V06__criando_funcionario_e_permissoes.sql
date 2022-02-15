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

INSERT INTO funcionario (id, nome, username, cpf, email, senha) values (1, 'João Vitor', 'jvrodrigs', '07064193330', 'jvrodrigs@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO funcionario (id, nome, username, cpf, email, senha) values (2, 'admin', 'admin', '07064193330', 'admin@naturalis.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO funcionario (id, nome, username, cpf, email, senha) values (3, 'Goreti Juvenal', 'goretijuvli', '07062193330', 'goretijuv@naturalis.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');


INSERT INTO permissao (id, descricao) values (1, 'ROLE_CADASTRAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (2, 'ROLE_PESQUISAR_CLIENTE');
INSERT INTO permissao (id, descricao) values (3, 'ROLE_REMOVER_CLIENTE');

INSERT INTO permissao (id, descricao) values (4, 'ROLE_CADASTRAR_PRODUTO');
INSERT INTO permissao (id, descricao) values (5, 'ROLE_REMOVER_PRODUTO');
INSERT INTO permissao (id, descricao) values (6, 'ROLE_PESQUISAR_PRODUTO');

INSERT INTO permissao (id, descricao) values (7, 'ROLE_CADASTRAR_SUBSTANCIAS');
INSERT INTO permissao (id, descricao) values (8, 'ROLE_REMOVER_SUBSTANCIAS');
INSERT INTO permissao (id, descricao) values (9, 'ROLE_PESQUISAR_SUBSTANCIAS');

INSERT INTO permissao (id, descricao) values (10, 'ROLE_CADASTRAR_ORDEM');
INSERT INTO permissao (id, descricao) values (11, 'ROLE_REMOVER_ORDEM');
INSERT INTO permissao (id, descricao) values (12, 'ROLE_PESQUISAR_ORDEM');

INSERT INTO permissao (id, descricao) values (13, 'ROLE_CADASTRAR_FUNCIONARIO');
INSERT INTO permissao (id, descricao) values (14, 'ROLE_PESQUISAR_FUNCIONARIO');
INSERT INTO permissao (id, descricao) values (15, 'ROLE_REMOVER_FUNCIONARIO');

INSERT INTO cargo (id, descricao) values (1, 'ADMINISTRADOR');
INSERT INTO cargo (id, descricao) values (2, 'ATENDENTE');
INSERT INTO cargo (id, descricao) values (3, 'ENTREGADOR');
INSERT INTO cargo (id, descricao) values (4, 'FARMACÊUTIO/ÁREA DA SAÚDE');


-- admin perm
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 1);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 2);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 3);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 4);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 5);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 6);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 7);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 8);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 9);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 10);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 11);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 12);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 13);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 14);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (1, 15);

INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 1);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 2);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 3);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 4);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 5);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 6);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 7);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 8);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 9);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 10);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 11);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 12);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 13);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 14);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (2, 15);

-- admin carg
INSERT INTO funcionario_cargo (funcionario_id, cargo_id) values (1, 1);
INSERT INTO funcionario_cargo (funcionario_id, cargo_id) values (2, 2);

-- farm perm
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 2);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 4);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 5);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 6);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 7);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 9);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 10);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 11);
INSERT INTO funcionario_perm (funcionario_id, permissao_id) values (3, 12);

-- farm carg
INSERT INTO funcionario_cargo (funcionario_id, cargo_id) values (3, 4);


-- Ordem de Serviço
INSERT INTO ordem_servico (id, cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (1, 1, 1, 1, 1, 'descricao 1', '1000', 1, '2022-01-01');
INSERT INTO ordem_servico (id, cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (2, 2, 2, 1, 1,'descricao 2', '3000', 1, '2021-01-01');