DROP TABLE IF EXISTS CAT;
CREATE TABLE CAT
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(30),
    type       VARCHAR(30),
    color      VARCHAR(30),
    height     DOUBLE PRECISION,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

DROP TABLE IF EXISTS DOG;
CREATE TABLE DOG
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(30),
    type       VARCHAR(30),
    color      VARCHAR(30),
    height     DOUBLE PRECISION,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
)
