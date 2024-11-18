package com.cardap.io.dtos.req.orderProduct;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Collection;

public record CreateOrderProductReqDTO(

        @Positive(message = "Product id must be a valid number")
        @NotNull(message = "Product id cannot be null")
        Long productId,

        Collection<@Positive(message = "Ingredients ids must include only valid numbers")
        @NotNull(message = "Product ids cannot be null")Long> ingredientIds,

        @Positive(message = "Product quantity must be a positive number")
        @NotNull(message = "Product quantity cannot include null values")
        int quantity) {
}
