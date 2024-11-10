package com.cardap.io.controllers;

import com.cardap.io.dtos.req.ingredient.AddIngredientDishReqDTO;
import com.cardap.io.dtos.req.ingredient.UpdateIngredientReqDTO;
import com.cardap.io.dtos.res.ingredient.IngredientResDTO;
import com.cardap.io.services.IngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
@AllArgsConstructor
public class IngredientController {

  private IngredientService ingredientService;


  @PostMapping()
  public ResponseEntity<IngredientResDTO> addIngredientToDish(@RequestBody AddIngredientDishReqDTO body) {

    var ingredient = ingredientService.createDishIngredient(body);

    return ResponseEntity.ok().build();
  }

  @PutMapping("{ingredientId}")
  public ResponseEntity<?> updateIngredientToDish(@PathVariable Long ingredientId, @RequestBody UpdateIngredientReqDTO body) {

    ingredientService.updateDishIngredient(ingredientId, body);

    return ResponseEntity.ok().build();
  }

}
