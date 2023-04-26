-- Criar a base de dados
CREATE DATABASE demo;

-- Usar a base de dados
\c demo;

-- Criar a tabela persons
CREATE TABLE persons (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         address VARCHAR(100),
                         gender CHAR(1)
);

