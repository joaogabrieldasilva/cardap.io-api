package com.cardap.io.repositories;

import com.cardap.io.models.EstablishmentAddress;
import com.cardap.io.models.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstablishmentAddressRepository extends JpaRepository<EstablishmentAddress, Long> {

  Optional<EstablishmentAddress> findByEstablishmentId(Long establishmentId);
}
