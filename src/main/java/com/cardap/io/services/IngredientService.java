package com.cardap.io.services;

import com.cardap.io.dtos.req.ingredient.AddIngredientDishReqDTO;
import com.cardap.io.dtos.req.ingredient.CreateDishIngredientReqDTO;
import com.cardap.io.dtos.req.ingredient.UpdateIngredientReqDTO;
import com.cardap.io.dtos.res.ingredient.IngredientResDTO;

public interface IngredientService {

  IngredientResDTO createDishIngredient(AddIngredientDishReqDTO dto);

  void updateDishIngredient(Long ingredientId, UpdateIngredientReqDTO dto);
}
