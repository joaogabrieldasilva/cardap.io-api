package com.cardap.io.exceptions;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException() {
        super("Ingredient not found");
    }


}
