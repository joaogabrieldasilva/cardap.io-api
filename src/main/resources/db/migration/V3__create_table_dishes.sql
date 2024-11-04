CREATE TABLE dishes(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    establishment_id INT,
    CONSTRAINT fk_establishment FOREIGN KEY (establishment_id)
                   REFERENCES establishments(id)
);