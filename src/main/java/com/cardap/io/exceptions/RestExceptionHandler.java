package com.cardap.io.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(AccessDeniedException.class)
    private ResponseEntity<RestException> invalidEmailOrPasswordHandler(AccessDeniedException exception) {
        RestException restException = new RestException(HttpStatus.FORBIDDEN, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }

    @ExceptionHandler(AuthenticationException.class)
    private ResponseEntity<RestException> invalidEmailOrPasswordHandler(AuthenticationException exception) {
        RestException restException = new RestException(HttpStatus.UNAUTHORIZED, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    private ResponseEntity<RestException> userAlreadyExistsHandler(UserAlreadyExistsException exception) {
        RestException restException = new RestException(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }


    @ExceptionHandler(InvalidEmailOrPasswordException.class)
    private ResponseEntity<RestException> invalidEmailOrPasswordHandler(InvalidEmailOrPasswordException exception) {
        RestException restException = new RestException(HttpStatus.UNAUTHORIZED, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<RestException> userNotFoundHandler(UserNotFoundException exception) {
        RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }

    @ExceptionHandler(EstablishmentNotFoundException.class)
    private ResponseEntity<RestException> establishmentNotFoundHandler(EstablishmentNotFoundException exception) {
        RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }

    @ExceptionHandler(DishNotFoundException.class)
    private ResponseEntity<RestException> dishNotFoundHandler(DishNotFoundException exception) {
        RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(restException.getStatus()).body(restException);
    }

}
