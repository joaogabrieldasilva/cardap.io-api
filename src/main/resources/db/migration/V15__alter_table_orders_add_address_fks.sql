ALTER TABLE establishments
    DROP COLUMN address;

ALTER TABLE orders
    ADD COLUMN shipping_address_id INTEGER;

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_shipping_address
        FOREIGN KEY (shipping_address_id)
            REFERENCES users_addresses (id);

ALTER TABLE orders
    ADD COLUMN pick_up_address_id INTEGER;

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_pick_up_address
        FOREIGN KEY (pick_up_address_id)
            REFERENCES establishments_addresses (id);

ALTER TABLE orders
    ADD CHECK ( shipping_address_id IS NOT NULL OR pick_up_address_id IS NOT NULL );