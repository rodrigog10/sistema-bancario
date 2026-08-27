CREATE TABLE cliente (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         idade INT NOT NULL,
                         cpf VARCHAR(14) UNIQUE NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         senha INT NOT NULL
);

CREATE TABLE conta_bradesco (
                                id SERIAL PRIMARY KEY,
                                saldo_app NUMERIC(10,2) DEFAULT 0.00,
                                cliente_id INT UNIQUE REFERENCES cliente(id) ON DELETE CASCADE
);

CREATE TABLE cofre_bradesco (
                                id SERIAL PRIMARY KEY,
                                nome_cofre VARCHAR(50) NOT NULL,
                                objetivo_cofre VARCHAR(100),
                                saldo_cofre NUMERIC(10,2) DEFAULT 0.00,
                                conta_id INT REFERENCES conta_bradesco(id) ON DELETE CASCADE
);