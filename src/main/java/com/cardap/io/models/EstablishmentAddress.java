package com.cardap.io.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "establishments_addresses")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstablishmentAddress {

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

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "establishment_id", nullable = false)
  private Establishment establishment;
}
