package com.cardap.io.dtos.req.auth;

import com.cardap.io.validation.annotation.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record SignUpReqDTO(
        @Size(min = 3, message = "Name must be at least 3 characters long")
        String name,
        @Email(message = "Email must be valid")
        String email,
        @Size(min = 4, message = "Password must be at least 4 characters long")
        String password,
        @Phone(message = "Phone must be valid")
        String phone
) {
}
