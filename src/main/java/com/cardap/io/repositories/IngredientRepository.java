package com.cardap.io.repositories;

import com.cardap.io.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
