package com.cardap.io.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
@Slf4j
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

  @ExceptionHandler(ProductNotFoundException.class)
  private ResponseEntity<RestException> dishNotFoundHandler(ProductNotFoundException exception) {
    RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(restException.getStatus()).body(restException);
  }

  @ExceptionHandler(IngredientNotFoundException.class)
  private ResponseEntity<RestException> ingredientNotFoundHandler(IngredientNotFoundException exception) {
    RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(restException.getStatus()).body(restException);
  }

  @ExceptionHandler(EstablishmentAddressNotFoundException.class)
  private ResponseEntity<RestException> establishmentAddressNotFoundHandler(EstablishmentAddressNotFoundException exception) {
    RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(restException.getStatus()).body(restException);
  }

  @ExceptionHandler(UserAddressNotFoundException.class)
  private ResponseEntity<RestException> userAddressNotFoundHandler(UserAddressNotFoundException exception) {
    RestException restException = new RestException(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(restException.getStatus()).body(restException);
  }

  @ExceptionHandler(InvalidOrderShippingAddressException.class)
  private ResponseEntity<RestException> invalidOrderShippingAddressIdHandler(InvalidOrderShippingAddressException exception) {
    RestException restException = new RestException(HttpStatus.BAD_REQUEST, exception.getMessage());

    return ResponseEntity.status(restException.getStatus()).body(restException);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    Optional<FieldError> error = ex.getBindingResult()
            .getFieldErrors()
                    .stream().findFirst();

    String message = ex.getMessage();

    if (error.isPresent()) {
     message = error.get().getDefaultMessage();
    }

    RestException restException = new RestException((HttpStatus) HttpStatusCode.valueOf(400), message);

    return ResponseEntity.status(restException.getStatus()).body(restException);

  }


}


