CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    firstname  VARCHAR(124) NOT NULL,
    lastname   VARCHAR(124) NOT NULL,
    username   VARCHAR(124) NOT NULL UNIQUE ,
    birth_date DATE         NOT NULL CHECK ( birth_date<now() )
);