CREATE TABLE substancia_prod (
  substancia_id INT NOT NULL,
  produto_id INT NOT NULL,
  PRIMARY KEY (substancia_id, produto_id),
  FOREIGN KEY (substancia_id) REFERENCES  substancias(id),
  FOREIGN KEY (produto_id) REFERENCES produto(id)
);

INSERT INTO produto (id, codigo_referencia, nome, descricao, fabricante) values (11, 'CR-011', 'xarope para gripe', 'agite antes de usar', 'Farmácia Naturalis');

INSERT INTO substancia_prod (substancia_id, produto_id) values (1,11);
INSERT INTO substancia_prod (substancia_id, produto_id) values (2,11);
INSERT INTO substancia_prod (substancia_id, produto_id) values (3,11);