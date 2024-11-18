package com.cardap.io.services;

import com.cardap.io.dtos.req.ingredient.AddIngredientProductReqDTO;
import com.cardap.io.dtos.req.ingredient.UpdateIngredientReqDTO;
import com.cardap.io.dtos.res.ingredient.IngredientResDTO;

public interface IngredientService {

  IngredientResDTO createProductIngredient(AddIngredientProductReqDTO dto);

  void updateProductIngredient(Long ingredientId, UpdateIngredientReqDTO dto);
}
