package com.cardap.io.exceptions;

public class InvalidOrderShippingAddressException extends RuntimeException {

    public InvalidOrderShippingAddressException() {
        super("Shipping address id cannot be null if isForPick up is false");
    }


}
