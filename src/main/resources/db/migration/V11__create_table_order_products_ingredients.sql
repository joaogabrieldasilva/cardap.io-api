CREATE TABLE order_products_ingredients (
    order_product_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    PRIMARY KEY (order_product_id, ingredient_id),
    FOREIGN KEY (order_product_id) REFERENCES order_products(id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredients(id)
);