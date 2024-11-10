package com.cardap.io.dtos.res.orderProduct;

import com.cardap.io.models.Ingredient;

import java.util.Collection;

public record OrderProductResDTO(Long id, String name, int quantity, Collection<String> ingredients) {
}
