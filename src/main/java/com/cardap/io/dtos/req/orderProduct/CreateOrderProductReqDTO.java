package com.cardap.io.dtos.req.orderProduct;

import java.util.Collection;

public record CreateOrderProductReqDTO(Long productId, Collection<Long> ingredientIds, int quantity) {
}
