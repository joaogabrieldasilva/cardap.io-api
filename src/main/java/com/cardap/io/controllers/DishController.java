package com.cardap.io.controllers;

import com.cardap.io.dtos.req.dish.CreateDishReqDTO;
import com.cardap.io.dtos.req.dish.UpdateDishReqDTO;
import com.cardap.io.dtos.res.dish.DishResDTO;
import com.cardap.io.services.DishService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {

    private DishService dishService;

    @PostMapping
    public ResponseEntity<DishResDTO> createDish(@RequestBody CreateDishReqDTO dto) {
        return new ResponseEntity<DishResDTO>(dishService.createDish(dto), HttpStatus.CREATED);
    }

    @PutMapping("{dishId}")
    public ResponseEntity<DishResDTO> createDish(@RequestBody UpdateDishReqDTO dto) {
        return ResponseEntity.ok(dishService.updateDish(dto));
    }

}
