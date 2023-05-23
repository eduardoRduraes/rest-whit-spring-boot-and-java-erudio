CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) DEFAULT NULL,
    full_name VARCHAR(255) DEFAULT NULL,
    password VARCHAR(255) DEFAULT NULL,
    account_non_expired BOOLEAN,
    account_non_locked BOOLEAN,
    credentials_non_expired BOOLEAN,
    enabled BOOLEAN,
    CONSTRAINT uk_user_name UNIQUE (user_name)
);