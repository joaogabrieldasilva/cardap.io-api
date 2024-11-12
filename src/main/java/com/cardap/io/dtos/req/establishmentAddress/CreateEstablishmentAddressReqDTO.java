package com.cardap.io.dtos.req.establishmentAddress;

import java.util.Optional;

public record CreateEstablishmentAddressReqDTO(
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

