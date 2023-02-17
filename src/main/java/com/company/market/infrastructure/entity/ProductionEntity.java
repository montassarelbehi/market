package com.company.market.infrastructure.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "production")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
public class ProductionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "park_id", nullable = false)
    private ParkEntity park;

    private Integer quantity;
}
