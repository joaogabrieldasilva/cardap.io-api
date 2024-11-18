package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.ingredient.AddIngredientProductReqDTO;
import com.cardap.io.dtos.req.ingredient.UpdateIngredientReqDTO;
import com.cardap.io.dtos.res.ingredient.IngredientResDTO;
import com.cardap.io.exceptions.ProductNotFoundException;
import com.cardap.io.exceptions.IngredientNotFoundException;
import com.cardap.io.models.Product;
import com.cardap.io.models.Ingredient;
import com.cardap.io.repositories.ProductRepository;
import com.cardap.io.repositories.IngredientRepository;
import com.cardap.io.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class IngredientServiceImpl implements IngredientService {

  private IngredientRepository ingredientRepository;

  private ProductRepository productRepository;

  @Override
  public IngredientResDTO createProductIngredient(AddIngredientProductReqDTO dto) {

    Product product = productRepository.findById(dto.productId()).orElseThrow(ProductNotFoundException::new);

    Ingredient ingredient = Ingredient.builder()
            .name(dto.name())
            .product(product)
            .build();

    Ingredient createdIngredient = ingredientRepository.save(ingredient);

    return new IngredientResDTO(
            createdIngredient.getId(),
            createdIngredient.getName()
    );
  }

  @Override
  public void updateProductIngredient(Long ingredientId, UpdateIngredientReqDTO dto) {
    Ingredient ingredient = ingredientRepository.findById(ingredientId).orElseThrow(IngredientNotFoundException::new);

    ingredient.setName(dto.name());

    ingredientRepository.save(ingredient);
  }
}
