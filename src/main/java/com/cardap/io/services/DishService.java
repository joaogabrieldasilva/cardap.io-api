package com.cardap.io.services;

import com.cardap.io.dtos.req.dish.CreateDishReqDTO;
import com.cardap.io.dtos.req.dish.UpdateDishReqDTO;
import com.cardap.io.dtos.res.dish.DishResDTO;

import java.util.Collection;

public interface DishService {

    Collection<DishResDTO> getEstablishmentDishes(Long establishmentId);

    DishResDTO createDish(CreateDishReqDTO dto);

    DishResDTO updateDish(Long dishId, UpdateDishReqDTO dto);
}
