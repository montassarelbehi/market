package com.company.market.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Production {

    private UUID id;

    @NotNull
    private Park park;

    @PositiveOrZero
    private Integer quantity;

}
