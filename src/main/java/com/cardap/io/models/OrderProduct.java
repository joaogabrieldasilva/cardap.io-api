package com.cardap.io.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Table(name = "order_products")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_products_ingredients",
            joinColumns = @JoinColumn(name = "order_product_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private Collection<Ingredient> ingredients;

    private int quantity;


}
