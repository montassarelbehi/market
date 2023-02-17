package com.company.market.infrastructure.entity;

import com.company.market.domain.ParkType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Table(name = "park")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
public class ParkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ParkType type;

    @OneToMany(mappedBy = "park")
    private Set<ProductionEntity> productions;
}
