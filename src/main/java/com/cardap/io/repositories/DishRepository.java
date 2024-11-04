package com.cardap.io.repositories;

import com.cardap.io.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface DishRepository extends JpaRepository<Dish, Long> {

    Collection<Dish> findDishByEstablishmentId(Long establishmentId);
}
