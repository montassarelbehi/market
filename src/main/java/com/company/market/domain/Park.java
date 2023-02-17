package com.company.market.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Park {

    private UUID id;

    @NotNull
    private ParkType type;
}
