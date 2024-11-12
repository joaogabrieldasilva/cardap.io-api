package com.cardap.io.dtos.req.order;

import com.cardap.io.dtos.req.orderProduct.CreateOrderProductReqDTO;

import java.util.Collection;
import java.util.Optional;

public record PlaceOrderReqDTO(Collection<CreateOrderProductReqDTO> products, String paymentMethod,
                               Optional<Long> shippingAddressId, boolean isForPickUp) {
}
