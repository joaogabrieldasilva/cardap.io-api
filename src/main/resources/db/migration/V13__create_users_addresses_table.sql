CREATE TABLE users_addresses
(
    id         SERIAL PRIMARY KEY NOT NULL,
    user_id    INTEGER            NOT NULL,
    name       VARCHAR(100)       NOT NULL,
    street     VARCHAR(255)       NOT NULL,
    state      VARCHAR(50)        NOT NULL,
    country    VARCHAR(50)        NOT NULL,
    zip_code   VARCHAR(10)        NOT NULL,
    number     INTEGER            NOT NULL,
    complement VARCHAR(100),
    reference  VARCHAR(100),

    CONSTRAINT fk_users_addresses_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
);

CREATE TABLE establishments_addresses
(
    id               SERIAL PRIMARY KEY NOT NULL,
    establishment_id INTEGER            NOT NULL,
    name             VARCHAR(100)       NOT NULL,
    street           VARCHAR(255)       NOT NULL,
    state            VARCHAR(50)        NOT NULL,
    country          VARCHAR(50)        NOT NULL,
    zip_code         VARCHAR(10)        NOT NULL,
    number           INTEGER            NOT NULL,
    complement       VARCHAR(100),
    reference        VARCHAR(100),

    CONSTRAINT fk_establishments_addresses_establishment
        FOREIGN KEY (establishment_id)
            REFERENCES establishments(id)
)