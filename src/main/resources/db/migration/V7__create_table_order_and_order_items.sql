ALTER TABLE dishes
RENAME TO products;

ALTER TABLE products
ADD COLUMN type VARCHAR(30) NOT NULL DEFAULT 'dish';

CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    establishment_id INT NOT NULL,
    CONSTRAINT fk_orders_establishments
        FOREIGN KEY(establishment_id)
        REFERENCES establishments(id)
);


CREATE TABLE order_items(
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    quantity INT NOT NULL,
    CONSTRAINT fk_order_items_orders
        FOREIGN KEY(order_id)
        REFERENCES orders(id)
);

CREATE TABLE order_product(
    id SERIAL PRIMARY KEY,
    order_item_id INT NOT NULL,
    order_product_id INT NOT NULL,
    CONSTRAINT fk_order_products_order_items
        FOREIGN KEY(order_item_id)
        REFERENCES order_items(id),
    CONSTRAINT fk_order_products_products
        FOREIGN KEY(order_product_id)
        REFERENCES products(id)
);
