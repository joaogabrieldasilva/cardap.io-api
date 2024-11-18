package com.cardap.io.dtos.req.product;

import com.cardap.io.dtos.req.ingredient.CreateProductIngredientReqDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.Collection;

public record CreateProductReqDTO(
        @Min(value = 1, message = "Establishment id must be a valid id")
        @NotNull(message = "Establishment id must be a valid id")
        @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Establishment id must be a valid integer")
        Long establishmentId,

        @Size(min = 4, message = "Product name must be at least 4 characters long")
        String name,
        @NotBlank(message = "Product description cannot be blank")
        String description,

        @DecimalMin(value = "0.0", message = "Product price must be a valid price")
        @NotNull(message = "Ingredient price cannot be null")
        Double price,

        @Valid
        Collection<CreateProductIngredientReqDTO> ingredients) {
}

