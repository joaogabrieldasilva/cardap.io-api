package com.cardap.io.exceptions;

public class EstablishmentNotFoundException extends RuntimeException {

    public EstablishmentNotFoundException() {
        super("Establishment not found");
    }


}
