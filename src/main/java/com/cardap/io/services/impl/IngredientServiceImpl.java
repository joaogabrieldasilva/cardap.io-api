package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.ingredient.AddIngredientDishReqDTO;
import com.cardap.io.dtos.req.ingredient.UpdateIngredientReqDTO;
import com.cardap.io.dtos.res.ingredient.IngredientResDTO;
import com.cardap.io.exceptions.DishNotFoundException;
import com.cardap.io.exceptions.IngredientNotFoundException;
import com.cardap.io.models.Dish;
import com.cardap.io.models.Ingredient;
import com.cardap.io.repositories.DishRepository;
import com.cardap.io.repositories.IngredientRepository;
import com.cardap.io.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {

  private IngredientRepository ingredientRepository;

  private DishRepository dishRepository;

  @Override
  public IngredientResDTO createDishIngredient(AddIngredientDishReqDTO dto) {

    Dish dish = dishRepository.findById(dto.dishId()).orElseThrow(DishNotFoundException::new);

    Ingredient ingredient = Ingredient.builder()
            .name(dto.name())
            .dish(dish)
            .build();

    Ingredient createdIngredient = ingredientRepository.save(ingredient);

    return new IngredientResDTO(
            createdIngredient.getId(),
            createdIngredient.getName()
    );
  }

  @Override
  public void updateDishIngredient(Long ingredientId, UpdateIngredientReqDTO dto) {
    Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(IngredientNotFoundException::new);

    ingredient.setName(dto.name());

    ingredientRepository.save(ingredient);
  }
}
