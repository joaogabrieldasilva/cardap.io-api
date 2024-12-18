package com.cardap.io.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users_addresses")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String street;

  private String state;

  private String country;

  private String zipCode;

  private int number;

  private String complement;

  private String reference;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

}
