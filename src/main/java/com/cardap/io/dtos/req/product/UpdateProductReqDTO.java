package com.cardap.io.dtos.req.product;

import com.cardap.io.validation.annotation.OptionalString;
import com.cardap.io.validation.annotation.OptionalDouble;
import jakarta.validation.Valid;

import java.util.Optional;

public record UpdateProductReqDTO(
        @Valid
        @OptionalString(min = 4, message = "Name must be at least 4 characters long")
        Optional<String> name,

        @Valid
        @OptionalString(min = 4, message = "Description must be at least 4 characters long")
        Optional<String> description,

        @Valid
        @OptionalDouble(min = 0.0, message = "Price must be a positive number")
        Optional<Double> price
) {
}