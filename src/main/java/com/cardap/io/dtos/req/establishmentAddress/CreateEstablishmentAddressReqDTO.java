package com.cardap.io.dtos.req.establishmentAddress;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CreateEstablishmentAddressReqDTO(
        @Size(min = 4, message = "Name must be at least 4 characters long")
        String name,
        @Size(min = 4, message = "Street must be at least 4 characters long")
        String street,
        @Size(min = 4, message = "State must be at least 4 characters long")
        String state,
        @Size(min = 4, message = "Country must be at least 4 characters long")
        String country,
        @Size(min = 4, message = "Zipcode must be at least 4 characters long")
        String zipCode,

        @Min(value = 1, message = "Number must be greater than 0")
        @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Number must be a valid integer")
        int number,

        Optional<String> complement,
        Optional<String> reference
) {
}

