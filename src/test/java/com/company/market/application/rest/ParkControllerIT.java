package com.company.market.application.rest;

import com.company.market.application.TestFactory;
import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;
import com.company.market.domain.Park;
import com.company.market.domain.ParkType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class ParkControllerIT {

    @Autowired
    private ParkController cut;

    @Autowired
    private OfferController offerController;

    @Autowired
    private TestFactory factory;

    @Test
    public void shouldCreatePark(){
        Park request = Park.builder().type(ParkType.NUCLEAR).build();

        Park response = cut.create(request);

        assertNotNull(response);
        assertNotNull(response.getId());
        assertEquals(request.getType(), response.getType());
    }

    @Test
    public void shouldNotCreatePark(){
        Park request = Park.builder().build();

        assertThrows(ConstraintViolationException.class, () -> {
            cut.create(request);
        });
    }

    @Test
    public void shouldFindByMarket() {
        Offer input = factory.provideOfferByMarket(MarketType.PRIMARY);
        offerController.create(input);

        List<Park> output = cut.findByMarket(MarketType.PRIMARY);

        assertFalse(output.isEmpty());
        assertEquals(2, output.size());
    }
}
