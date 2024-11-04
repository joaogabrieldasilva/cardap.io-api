package com.cardap.io.exceptions;

public class DishNotFoundException extends RuntimeException {

    public DishNotFoundException() {
        super("Dish not found");
    }


}
