DROP TABLE IF EXISTS CAT;
CREATE TABLE CAT
(
    id         VARCHAR(16) PRIMARY KEY,
    name       VARCHAR(30),
    type       VARCHAR(30),
    color      VARCHAR(30),
    height     DOUBLE PRECISION,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    is_deleted BOOLEAN
);

DROP TABLE IF EXISTS DOG;
CREATE TABLE DOG
(
    id         VARCHAR(16) PRIMARY KEY,
    name       VARCHAR(30),
    type       VARCHAR(30),
    color      VARCHAR(30),
    height     DOUBLE PRECISION,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    is_deleted BOOLEAN
)
