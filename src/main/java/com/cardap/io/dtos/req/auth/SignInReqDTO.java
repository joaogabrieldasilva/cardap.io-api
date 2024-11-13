package com.cardap.io.dtos.req.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record SignInReqDTO(
        @Email(message = "Email must be valid")
        String email,
        @Size(min = 4, message = "Password must be at least 4 characters long")
        String password) {
}
