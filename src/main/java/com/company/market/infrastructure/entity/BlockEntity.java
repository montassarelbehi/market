package com.company.market.infrastructure.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Table(name = "block")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
public class BlockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private BigDecimal priceThreshold;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductionEntity> productions;
}
