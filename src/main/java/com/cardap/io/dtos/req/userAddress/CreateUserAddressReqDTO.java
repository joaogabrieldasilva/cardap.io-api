package com.cardap.io.dtos.req.userAddress;

import com.cardap.io.validation.annotation.OptionalString;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CreateUserAddressReqDTO(

        @NotBlank(message = "Name cannot be blank")
        @Size(min = 4, message = "Name must be at least 4 characters long")
        String name,
        @NotBlank(message = "Street cannot be blank")
        String street,
        @NotBlank(message = "State cannot be blank")
        String state,
        @NotBlank(message = "Country cannot be blank")
        String country,
        @NotBlank(message = "Country cannot be blank")
        @Size(min = 4,message = "Zipcode must be at least 4 characters long")
        String zipCode,

        @NotNull(message = "Number cannot be null")
        @Positive(message = "Number must be a valid number")
        int number,

        @Valid
        @OptionalString(min = 1, message = "Complement should be valid")
        Optional<String> complement,

        @Valid
        @OptionalString(min = 1, message = "Reference should be valid")
        Optional<String> reference) {
}
