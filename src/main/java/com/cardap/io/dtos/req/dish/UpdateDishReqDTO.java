package com.cardap.io.dtos.req.dish;

import java.util.Optional;

public record UpdateDishReqDTO(Long dishId, Optional<String> name, Optional<String> description) {
}
