package com.cardap.io.dtos.req.ingredient;

import jakarta.validation.constraints.Size;

public record CreateProductIngredientReqDTO(
        @Size(min = 4, message = "Ingredient name must be at least 4 characters long")
        String name
) {
}
