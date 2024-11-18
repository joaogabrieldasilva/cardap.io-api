package com.cardap.io.dtos.req.ingredient;

import jakarta.validation.constraints.*;

public record AddIngredientProductReqDTO(
        @Size(min = 4, message = "Ingredient name must be at least 4 characters long")
        @NotNull(message = "Ingredient cannot be null")
        String name,

        @Min(value = 1, message = "Product id must be a valid id")
        @NotNull(message = "Product id must be a valid id")
        @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Product id must be a valid integer")
        Long productId
) {
}
