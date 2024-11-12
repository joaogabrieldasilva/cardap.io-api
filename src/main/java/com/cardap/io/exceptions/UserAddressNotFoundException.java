package com.cardap.io.exceptions;

public class UserAddressNotFoundException extends RuntimeException {

    public UserAddressNotFoundException() {
        super("User address not found");
    }


}
