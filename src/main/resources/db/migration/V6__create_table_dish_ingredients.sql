CREATE TABLE ingredients(
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(50) NOT NULL,
    dish_id INT NOT NULL,
    CONSTRAINT fk_dish_ingredients
        FOREIGN KEY (dish_id)
            REFERENCES dishes(id)
)