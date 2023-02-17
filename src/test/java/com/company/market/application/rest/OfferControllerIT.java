package com.company.market.application.rest;

import com.company.market.application.TestFactory;
import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class OfferControllerIT {

    @Autowired
    private OfferController cut;

    @Autowired
    private TestFactory factory;

    @Test
    public void shouldCreate(){

        Offer input = factory.provideOfferByMarket(MarketType.PRIMARY);

        Offer output = cut.create(input);

        assertNotNull(output);
        assertNotNull(output.getId());
    }

    @Test
    public void shouldFindByMarket() {

        Offer input = factory.provideOfferByMarket(MarketType.PRIMARY);
        cut.create(input);

        List<Offer> output = cut.findByMarketType(MarketType.PRIMARY);

        assertFalse(output.isEmpty());
        output.forEach(o -> {
            assertEquals(MarketType.PRIMARY, o.getMarket());
        });
    }

}
