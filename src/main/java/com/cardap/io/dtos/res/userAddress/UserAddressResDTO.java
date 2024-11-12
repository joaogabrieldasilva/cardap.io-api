package com.cardap.io.dtos.res.userAddress;

import java.util.Optional;

public record UserAddressResDTO(
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
