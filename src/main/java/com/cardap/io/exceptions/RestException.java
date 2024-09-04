package com.cardap.io.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestException {

    private HttpStatus status;

    private String message;

    public RestException(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

}
