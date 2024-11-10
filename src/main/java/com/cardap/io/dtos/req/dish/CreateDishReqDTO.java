package com.cardap.io.dtos.req.dish;

import com.cardap.io.dtos.req.ingredient.CreateDishIngredientReqDTO;

import java.util.Collection;

public record CreateDishReqDTO(Long establishmentId, String name, String description, Double price, Collection<CreateDishIngredientReqDTO> ingredients) {
}
