CREATE TABLE establishments(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(30),
    responsible_id INTEGER NOT NULL
);