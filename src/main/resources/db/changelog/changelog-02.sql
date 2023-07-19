DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    last_name VARCHAR,
    age INTEGER,
    email VARCHAR
);