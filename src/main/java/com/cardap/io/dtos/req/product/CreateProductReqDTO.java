package com.cardap.io.dtos.req.product;

import com.cardap.io.dtos.req.ingredient.CreateDishIngredientReqDTO;

import java.util.Collection;

public record CreateProductReqDTO(Long establishmentId, String name, String description, Double price, Collection<CreateDishIngredientReqDTO> ingredients) {
}
