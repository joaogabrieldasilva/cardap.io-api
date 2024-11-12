package com.cardap.io.dtos.req.userAddress;

import java.util.Optional;

public record CreateUserAddressReqDTO(
        String name,
        String street,
        String state,
        String country,
        String zipCode,
        int number,
        Optional<String> complement,
        Optional<String> reference) {
}
