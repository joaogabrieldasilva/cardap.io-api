package com.cardap.io.controllers;

import com.cardap.io.dtos.req.order.PlaceOrderReqDTO;
import com.cardap.io.dtos.res.order.OrderResDTO;
import com.cardap.io.models.User;
import com.cardap.io.services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor

public class OrderController {

  private final OrderService orderService;


  @PostMapping("/{establishmentId}/place")
  public ResponseEntity<OrderResDTO> placeOrder(@PathVariable Long establishmentId, @AuthenticationPrincipal User user, @Valid @RequestBody PlaceOrderReqDTO body) {

    OrderResDTO order = orderService.placeOrder(user.getId(), establishmentId, body);

    return new ResponseEntity<OrderResDTO>(order, HttpStatus.CREATED);
  }

}
