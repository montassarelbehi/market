package com.company.market.domain.port.spi;

import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;

import java.util.List;

public interface OfferPersistencePort {

    Offer create(Offer offer);

    List<Offer> findByMarket(MarketType market);
}

