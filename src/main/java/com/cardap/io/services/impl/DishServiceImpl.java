package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.dish.CreateDishReqDTO;
import com.cardap.io.dtos.req.dish.UpdateDishReqDTO;
import com.cardap.io.dtos.res.dish.DishResDTO;
import com.cardap.io.exceptions.DishNotFoundException;
import com.cardap.io.exceptions.EstablishmentNotFoundException;
import com.cardap.io.models.Dish;
import com.cardap.io.models.Establishment;
import com.cardap.io.models.Ingredient;
import com.cardap.io.repositories.DishRepository;
import com.cardap.io.repositories.EstablishmentRepository;
import com.cardap.io.services.DishService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class DishServiceImpl implements DishService {

  private DishRepository dishRepository;

  private EstablishmentRepository establishmentRepository;

  @Override
  public Collection<DishResDTO> getEstablishmentDishes(Long establishmentId) {
    return dishRepository.findDishByEstablishmentId(establishmentId).stream().map(dish -> new DishResDTO(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice())).toList();
  }

  @Override
  public DishResDTO createDish(CreateDishReqDTO dto) {

    Establishment establishment = establishmentRepository.findById(dto.establishmentId()).orElseThrow(EstablishmentNotFoundException::new);


    Collection<Ingredient> ingredients = dto.ingredients().stream().map(ingredient -> Ingredient.builder()
            .name(ingredient.name())
            .build()
    ).toList();

    Dish dish = Dish.builder()
            .name(dto.name())
            .description(dto.description())
            .price(dto.price())
            .establishment(establishment)
            .ingredients(ingredients)
            .build();

    ingredients.forEach(ingredient -> ingredient.setDish(dish));

    Dish createdDish = dishRepository.save(dish);

    return new DishResDTO(createdDish.getId(), createdDish.getName(), createdDish.getDescription(), createdDish.getPrice());
  }

  @Override
  public DishResDTO updateDish(Long dishId, UpdateDishReqDTO dto) {

    Dish dish = dishRepository.findById(dishId).orElseThrow(DishNotFoundException::new);

    dto.name().ifPresent(dish::setName);
    dto.description().ifPresent(dish::setDescription);
    dto.price().ifPresent(dish::setPrice);

    dishRepository.save(dish);

    return new DishResDTO(dish.getId(), dish.getName(), dish.getDescription(), dish.getPrice());
  }
}
