package com.cardap.io.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "establishments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_id")
    private User responsible;

    private String description;
}
