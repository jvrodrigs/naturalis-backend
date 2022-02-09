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

INSERT INTO substancias (descricao, potencia, nfe, laboratorio, lote_origem, lote_interno, data_fabricacao, data_validade) values ('ACONITUM NAP.', 'FC999', '103.294', 'HN CRISTIANO', '0267812-0002', null, '2021-09-06', '2026-09-06');
INSERT INTO substancias (descricao, potencia, nfe, laboratorio, lote_origem, lote_interno, data_fabricacao, data_validade) values ('AGRIAO NASTURTIUM OFF.', 'TM', null, 'SCHRAIBER', '85018', null, '2020-05-06', '2025-05-06');
INSERT INTO substancias (descricao, potencia, nfe, laboratorio, lote_origem, lote_interno, data_fabricacao, data_validade) values ('ALFAFA', 'TM', '192363', 'SCHRAIBER', '80770', null, '2020-09-04', '2025-08-04');
