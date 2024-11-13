package com.cardap.io.dtos.req.establishment;

import com.cardap.io.validation.annotation.OptionalPhone;
import com.cardap.io.validation.annotation.OptionalSize;
import com.cardap.io.validation.annotation.Phone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record UpdateEstablishmentReqDTO(
        @Valid
        @OptionalSize(min = 4, message = "Name must be at least 4 characters long")
        Optional<String> name,

        @Valid
        @OptionalPhone(message = "Phone must be valid")
        Optional<String> phone) {
}
