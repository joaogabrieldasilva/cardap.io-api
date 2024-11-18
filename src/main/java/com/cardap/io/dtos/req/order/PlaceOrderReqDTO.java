package com.cardap.io.dtos.req.order;

import com.cardap.io.dtos.req.orderProduct.CreateOrderProductReqDTO;
import com.cardap.io.validation.annotation.OptionalLong;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.Optional;

public record PlaceOrderReqDTO(

        Collection<@Valid CreateOrderProductReqDTO> products,

        @NotNull(message = "Payment method cannot be null")
        String paymentMethod,

        @NotNull(message = "Shipping address cannot be null")
        @OptionalLong(message = "Shipping address id must be a valid number")
        Optional<Long> shippingAddressId,

        @NotNull(message = "isForPickup flag cannot be null")
        boolean isForPickUp
) {
}
