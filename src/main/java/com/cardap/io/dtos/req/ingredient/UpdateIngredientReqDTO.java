package com.cardap.io.dtos.req.ingredient;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateIngredientReqDTO(
        @Size(min = 4, message = "Ingredient name must be at least 4 characters long")
        @NotNull(message = "Ingredient name cannot be null")
        String name
) {
}
