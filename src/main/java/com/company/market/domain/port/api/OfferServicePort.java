package com.company.market.domain.port.api;

import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;

import java.util.List;

public interface OfferServicePort {

    Offer create(Offer offer);

    List<Offer> findByMarketType(MarketType market);
}
