package com.cardap.io.dtos.req.establishment;

import com.cardap.io.dtos.req.establishmentAddress.CreateEstablishmentAddressReqDTO;
import com.cardap.io.validation.annotation.Phone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateEstablishmentReqDTO(
        @Size(min = 4, message = "Name must be at least 4 characters long")
        String name,

        @Valid
        CreateEstablishmentAddressReqDTO address,

        @Phone(message = "Phone must be valid")
        String phone
) {
}
