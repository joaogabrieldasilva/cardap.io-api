package com.cardap.io.controllers;

import com.cardap.io.dtos.req.ingredient.AddIngredientProductReqDTO;
import com.cardap.io.dtos.req.ingredient.UpdateIngredientReqDTO;
import com.cardap.io.dtos.res.ingredient.IngredientResDTO;
import com.cardap.io.dtos.res.order.OrderResDTO;
import com.cardap.io.services.IngredientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
@AllArgsConstructor
public class IngredientController {

  private IngredientService ingredientService;


  @PostMapping()
  public ResponseEntity<IngredientResDTO> addIngredientToDish(@Valid @RequestBody AddIngredientProductReqDTO body) {

    IngredientResDTO ingredient = ingredientService.createProductIngredient(body);

    return new ResponseEntity<>(ingredient, HttpStatus.CREATED);
  }

  @PutMapping("{ingredientId}")
  public ResponseEntity<?> updateIngredientToDish(@PathVariable Long ingredientId, @Valid @RequestBody UpdateIngredientReqDTO body) {

    ingredientService.updateProductIngredient(ingredientId, body);

    return ResponseEntity.ok().build();
  }

}
