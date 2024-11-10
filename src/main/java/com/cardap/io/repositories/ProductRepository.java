package com.cardap.io.repositories;

import com.cardap.io.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Collection<Product> findProductByEstablishmentId(Long establishmentId);
}
