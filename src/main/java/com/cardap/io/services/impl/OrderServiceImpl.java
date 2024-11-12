package com.cardap.io.services.impl;

import com.cardap.io.dtos.req.order.PlaceOrderReqDTO;
import com.cardap.io.dtos.res.order.OrderResDTO;
import com.cardap.io.dtos.res.orderProduct.OrderProductResDTO;
import com.cardap.io.exceptions.*;
import com.cardap.io.models.*;
import com.cardap.io.repositories.*;
import com.cardap.io.services.OrderService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;

  private ProductRepository productRepository;

  private IngredientRepository ingredientRepository;

  private UserRepository userRepository;

  private EstablishmentRepository establishmentRepository;

  private EstablishmentAddressRepository establishmentAddressRepository;

  private UserAddressRepository userAddressRepository;



  @Override
  public OrderResDTO placeOrder(Long userId, Long establishmentId, PlaceOrderReqDTO dto) {

    User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    Establishment establishment = establishmentRepository.findById(establishmentId).orElseThrow(EstablishmentNotFoundException::new);


    Collection<Long> productIds = dto.products().stream()
            .map(product -> product.productId())
            .collect(Collectors.toList());
    Collection<Product> products = productRepository.findAllById(productIds);

    Map<Long, Product> productMap = products.stream()
            .collect(Collectors.toMap(Product::getId, product -> product));

    var orderProducts = dto.products().stream().map(product -> OrderProduct.builder()
            .quantity(product.quantity())
            .product(productMap.get(product.productId()))
            .ingredients(ingredientRepository.findAllById(product.ingredientIds()))
            .build()).toList();



    Order order = Order.builder()
            .orderProducts(orderProducts)
            .user(user)
            .isForPickUp(dto.isForPickUp())
            .establishment(establishment)
            .paymentMethod(dto.paymentMethod())
            .build();

    if (dto.isForPickUp()) {
      EstablishmentAddress pickUpAddress = establishmentAddressRepository.findByEstablishmentId(establishment.getId()).orElseThrow(EstablishmentAddressNotFoundException::new);
      order.setPickUpAddress(pickUpAddress);
    } else {
      dto.shippingAddressId().ifPresentOrElse((shippingAddressId) -> {
        UserAddress shippingAddress = userAddressRepository.findById(shippingAddressId).orElseThrow(UserAddressNotFoundException::new);
        order.setShippingAddress(shippingAddress);
      }, () -> {
        throw new InvalidOrderShippingAddressException();
      });
    }

    orderProducts.forEach(orderProduct -> orderProduct.setOrder(order));

    Order createdOrder = orderRepository.save(order);

    Collection<OrderProductResDTO> mappedOrderProducts = createdOrder.getOrderProducts().stream()
            .map(orderProduct -> {
              return new OrderProductResDTO(orderProduct.getId(), orderProduct.getProduct().getName(), orderProduct.getQuantity(), orderProduct.getIngredients().stream().map(Ingredient::getName).toList());
            })
            .toList();

    return new OrderResDTO(createdOrder.getId(), mappedOrderProducts);
  }
}
