package com.cardap.io.dtos.req.order;

import com.cardap.io.dtos.req.orderProduct.CreateOrderProductReqDTO;

import java.util.Collection;

public record PlaceOrderReqDTO(Collection<CreateOrderProductReqDTO> products) {
}
