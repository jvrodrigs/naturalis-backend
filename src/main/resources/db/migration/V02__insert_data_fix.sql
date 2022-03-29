INSERT INTO status (id, nome) values (1, 'EM SEPARAÇÃO');
INSERT INTO status (id, nome) values (2, 'ESPERANDO ENTREGADOR');
INSERT INTO status (id, nome) values (3, 'EM ROTA');
INSERT INTO status (id, nome) values (4, 'ENTREGUE');
INSERT INTO status (id, nome) values (5, 'CANCELADO');

INSERT INTO substancias (descricao, potencia, nfe, laboratorio, lote_origem, lote_interno, data_fabricacao, data_validade) values ('ACONITUM NAP.', 'FC999', '103.294', 'HN CRISTIANO', '0267812-0002', null, '2021-09-06', '2026-09-06');
INSERT INTO substancias (descricao, potencia, nfe, laboratorio, lote_origem, lote_interno, data_fabricacao, data_validade) values ('AGRIAO NASTURTIUM OFF.', 'TM', null, 'SCHRAIBER', '85018', null, '2020-05-06', '2025-05-06');
INSERT INTO substancias (descricao, potencia, nfe, laboratorio, lote_origem, lote_interno, data_fabricacao, data_validade) values ('ALFAFA', 'TM', '192363', 'SCHRAIBER', '80770', null, '2020-09-04', '2025-08-04');

INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João Silva', '21231231' ,'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Silva', '8231838' ,'Rua do Café', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Humberto', '8321831' ,'Rua do Leite', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Igor Leite', '3123' ,'Rua do Doido', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Gilson Bezerra', '3213' ,'Rua do Acerola', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Hugo Almeida', '31231231' ,'Rua do Limão', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Gilberto', '231312312' ,'Rua do Melancia', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Linderson', '3123123' ,'Rua do Abacate', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Jotave Lima', '312312' ,'Rua do Goiaba', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Juvenas A', '3213213' ,'Rua do Melão', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO cliente (nome, telefone,logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Mariazinha', '312312' ,'Rua da Uva', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);

INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-001', 'Produto 1', 'Este é o produto 1', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-002', 'Produto 2', 'Este é o produto 2', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-003', 'Produto 3', 'Este é o produto 3', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em ) values ( 'CR-004', 'Produto 4', 'Este é o produto 4', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-005', 'Produto 5', 'Este é o produto 5', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-006', 'Produto 6', 'Este é o produto 6', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-007', 'Produto 7', 'Este é o produto 7', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-008', 'Produto 8', 'Este é o produto 8', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-009', 'Produto 9', 'Este é o produto 9', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto ( codigo_referencia, nome, descricao, fabricante, criado_em) values ( 'CR-010', 'Produto 10', 'Este é o produto 10', 'Farmácia Naturalis','2022-01-01');
INSERT INTO produto (codigo_referencia, nome, descricao, fabricante, criado_em) values ('CR-011', 'xarope para gripe', 'agite antes de usar', 'Farmácia Naturalis','2022-01-01');


INSERT INTO funcionario (id, nome, username, cpf, email, senha) values (1, 'João Vitor', 'jvrodrigs', '07064193330', 'jvrodrigs@gmail.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
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
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (1, 1, 1, 1, 'descricao 1', '1000', 1, '2022-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (2, 2, 1, 1,'descricao 2', '3000', 1, '2021-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (4, 2, 1, 1,'descricao 2', '3000', 1, '2022-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (5, 2, 3, 1,'descricao 2', '4000', 1, '2022-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (6, 2, 1, 1,'descricao 2', '5000', 1, '2022-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (7, 2, 3, 1,'descricao 2', '3000', 1, '2022-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (1, 2, 3, 1,'descricao 2', '3000', 1, '2021-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (8, 2, 1, 1,'descricao 2', '3000', 1, '2021-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (10, 2, 3, 1,'descricao 2', '3000', 1, '2021-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (5, 2, 2, 1,'descricao 2', '3000', 1, '2021-01-01');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (4, 2, 3, 4,'NOVA ORDEM DE SERVIÇO', '6000', 1, '2022-03-16');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (5, 2, 3, 4,'NOVA ORDEM DE SERVIÇO', '7000', 1, '2022-03-16');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (6, 2, 3, 3,'NOVA ORDEM DE SERVIÇO', '8000', 1, '2022-03-16');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (7, 2, 3, 5,'NOVA ORDEM DE SERVIÇO', '10000', 1, '2022-03-16');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (1, 2, 3, 4,'NOVA ORDEM DE SERVIÇO', '88000', 1, '2021-03-20');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (8, 2, 1, 5,'NOVA ORDEM DE SERVIÇO', '22000', 1, '2021-03-18');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (10, 2, 1, 4,'NOVA ORDEM DE SERVIÇO', '44000', 1, '2021-03-19');
INSERT INTO ordem_servico (cliente_id, produto_id, autor_id, status_id, descricao, valor_total, responsavel_id, criado_em) values (5, 2, 1, 3,'NOVA ORDEM DE SERVIÇO', '9000', 1, '2021-03-16');

INSERT INTO substancia_prod (substancia_id, produto_id) values (1,11);
INSERT INTO substancia_prod (substancia_id, produto_id) values (2,11);
INSERT INTO substancia_prod (substancia_id, produto_id) values (3,11);