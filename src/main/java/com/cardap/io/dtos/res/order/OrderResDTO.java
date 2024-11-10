package com.cardap.io.dtos.res.order;


import com.cardap.io.dtos.res.orderProduct.OrderProductResDTO;

import java.util.Collection;

public record OrderResDTO(Long id, Collection<OrderProductResDTO> items) {
}
