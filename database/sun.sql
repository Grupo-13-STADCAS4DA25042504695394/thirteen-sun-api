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

CREATE TABLE customer_lead (
    customer_id INTEGER NOT NULL,
    lead_id INTEGER NOT NULL,
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (customer_id, lead_id),

    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id)
        REFERENCES customer(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_lead
        FOREIGN KEY (lead_id)
        REFERENCES lead(id)
        ON DELETE CASCADE
);

