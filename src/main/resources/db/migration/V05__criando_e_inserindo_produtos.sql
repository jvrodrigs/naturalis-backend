CREATE TABLE produto (
      id SERIAL PRIMARY KEY,
      codigo_referencia VARCHAR(50) NOT NULL,
      nome VARCHAR(50) NOT NULL,
      descricao VARCHAR(100),
      fabricante VARCHAR(50) NOT NULL
);


INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (1, 'CR-001', 'Produto 1', 'Este é o produto 1', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (2, 'CR-002', 'Produto 2', 'Este é o produto 2', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (3, 'CR-003', 'Produto 3', 'Este é o produto 3', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (4, 'CR-004', 'Produto 4', 'Este é o produto 4', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (5, 'CR-005', 'Produto 5', 'Este é o produto 5', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (6, 'CR-006', 'Produto 6', 'Este é o produto 6', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (7, 'CR-007', 'Produto 7', 'Este é o produto 7', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (8, 'CR-008', 'Produto 8', 'Este é o produto 8', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (9, 'CR-009', 'Produto 9', 'Este é o produto 9', 'Farmácia Naturalis');
INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (10, 'CR-010', 'Produto 10', 'Este é o produto 10', 'Farmácia Naturalis');

