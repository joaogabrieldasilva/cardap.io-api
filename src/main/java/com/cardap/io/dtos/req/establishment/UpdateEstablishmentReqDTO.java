package com.cardap.io.dtos.req.establishment;

import java.util.Optional;

public record UpdateEstablishmentReqDTO(Optional<String> name, Optional<String> phone) {
}
