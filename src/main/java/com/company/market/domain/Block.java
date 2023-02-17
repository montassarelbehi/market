package com.company.market.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Block {

    private UUID id;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    @Positive
    private BigDecimal priceThreshold; // assuming unit EURo

    @NotEmpty
    private Set<Production> productions;
}
