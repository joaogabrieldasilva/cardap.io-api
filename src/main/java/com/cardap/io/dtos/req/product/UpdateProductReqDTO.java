package com.cardap.io.dtos.req.product;

import java.util.Optional;

public record UpdateProductReqDTO(Optional<String> name, Optional<String> description, Optional<Double> price) {
}
