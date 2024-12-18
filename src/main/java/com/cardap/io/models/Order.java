package com.cardap.io.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Table(name = "orders")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "establishment_id", nullable = false)
  private Establishment establishment;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
  private Collection<OrderProduct> orderProducts;

  @ManyToOne(fetch =  FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "payment_method", nullable = false)
  private String paymentMethod;

  private Boolean isForPickUp;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shipping_address_id", nullable = true)
  private UserAddress shippingAddress;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pick_up_address_id", nullable = true)
  private EstablishmentAddress pickUpAddress;
}
