package com.cardap.io.dtos.req.dish;

import java.util.Optional;

public record UpdateDishReqDTO(Optional<String> name, Optional<String> description, Optional<Double> price) {
}
