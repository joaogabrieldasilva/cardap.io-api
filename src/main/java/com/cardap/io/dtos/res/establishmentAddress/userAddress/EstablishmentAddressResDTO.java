package com.cardap.io.dtos.res.establishmentAddress.userAddress;

import java.util.Optional;

public record EstablishmentAddressResDTO(
        Long id,
        String name,
        String street,
        String state,
        String country,
        String zipCode,
        int number,
        Optional<String> complement,
        Optional<String> reference
) {
}
