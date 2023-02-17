package com.company.market.infrastructure.entity;

import com.company.market.domain.MarketType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Table(name = "offer")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private MarketType market;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BlockEntity> blocks;
}
