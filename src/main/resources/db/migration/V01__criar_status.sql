CREATE TABLE status(
    id SERIAL  PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

INSERT INTO status (id, nome) values (1, 'EM SEPARAÇÃO');
INSERT INTO status (id, nome) values (2, 'ESPERANDO ENTREGADOR');
INSERT INTO status (id, nome) values (3, 'EM ROTA');
INSERT INTO status (id, nome) values (4, 'ENTREGUE');
INSERT INTO status (id, nome) values (5, 'CANCELADO');