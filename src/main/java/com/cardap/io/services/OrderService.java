package com.cardap.io.services;

import com.cardap.io.dtos.req.order.PlaceOrderReqDTO;
import com.cardap.io.dtos.res.order.OrderResDTO;

public interface OrderService {

  OrderResDTO placeOrder(Long userId, Long establishmentId, PlaceOrderReqDTO dto);
}
