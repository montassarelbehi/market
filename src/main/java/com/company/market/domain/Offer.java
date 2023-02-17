package com.company.market.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Offer {

    private UUID id;

    @NotNull
    private MarketType market;

    @NotEmpty
    private Set<Block> blocks;
}
