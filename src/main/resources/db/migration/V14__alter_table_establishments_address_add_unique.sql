ALTER TABLE establishments_addresses
    ADD CONSTRAINT uc_establishments_addresses_establishment_id UNIQUE (establishment_id);