ALTER TABLE orders
    ADD COLUMN user_id INT;

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_user
    FOREIGN KEY (user_id)
    REFERENCES users(id);

DROP TABLE order_items CASCADE;

ALTER TABLE order_product
    RENAME TO order_products;

ALTER TABLE order_products
    ADD COLUMN quantity INT NOT NULL;
ALTER TABLE order_products
    ADD COLUMN order_id INT NOT NULL;
ALTER TABLE order_products
    ADD COLUMN product_id INT NOT NULL;
ALTER TABLE order_products
    DROP COLUMN order_item_id;


ALTER TABLE order_products
    ADD FOREIGN KEY (order_id)
    REFERENCES orders(id);

ALTER TABLE order_products
    ADD FOREIGN KEY (product_id)
        REFERENCES products(id);
