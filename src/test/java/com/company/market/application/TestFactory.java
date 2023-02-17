package com.company.market.application;

import com.company.market.domain.*;
import com.company.market.domain.port.api.BlockServicePort;
import com.company.market.domain.port.api.ParkServicePort;
import com.company.market.domain.port.api.ProductionServicePort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Component
public class TestFactory {
    @Autowired
    private ParkServicePort parkService;

    @Autowired
    private BlockServicePort blockService;

    @Autowired
    private ProductionServicePort productionService;

    public Offer provideOfferByMarket(MarketType type){

        Park park1 = parkService.create(Park.builder().type(ParkType.NUCLEAR).build());
        Park park2 = parkService.create(Park.builder().type(ParkType.SOLAR).build());

        Production production = productionService.create(Production.builder().park(park1).quantity(100).build());
        Production production2 = productionService.create(Production.builder().park(park2).quantity(50).build());

        Block block = blockService.create(Block.builder().priceThreshold(BigDecimal.ONE).startDateTime(LocalDateTime.now())
                .endDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS).plus(1, ChronoUnit.HOURS))
                .productions(Set.of(production, production2)).build());

        Offer offer = Offer.builder().blocks(Set.of(block)).market(type).build();

        return offer;
    }
}
