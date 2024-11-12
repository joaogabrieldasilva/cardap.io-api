CREATE TYPE PAYMENT_METHOD AS ENUM ('Cash', 'Credit Card', 'Debit Card', 'Pix');

ALTER TABLE orders
    ADD COLUMN payment_method PAYMENT_METHOD NOT NULL DEFAULT 'Cash';