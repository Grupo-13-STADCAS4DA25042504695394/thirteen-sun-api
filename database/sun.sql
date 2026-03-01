CREATE TABLE lead (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    valor_medio_mes NUMERIC(10,2),
    cep VARCHAR(10),
    email VARCHAR(150) NOT NULL,
    telefone VARCHAR(20),
    CONSTRAINT unique_lead_email UNIQUE (email)
);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    telefone VARCHAR(20),
    CONSTRAINT unique_customer_email UNIQUE (email)
);


