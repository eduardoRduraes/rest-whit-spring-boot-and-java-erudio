CREATE TABLE persons (
                         id SERIAL PRIMARY KEY,
                         first_name VARCHAR(250) NOT NULL,
                         last_name VARCHAR(250) NOT NULL,
                         address VARCHAR(100) NOT NULL ,
                         gender VARCHAR(6) NOT NULL
);

