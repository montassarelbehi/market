package com.company.market.domain.service;

import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;
import com.company.market.domain.port.api.OfferServicePort;
import com.company.market.domain.port.spi.OfferPersistencePort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OfferService implements OfferServicePort {

    private final OfferPersistencePort persistence;

    @Override
    public Offer create(Offer offer) {

        return persistence.create(offer);
    }

    @Override
    public List<Offer> findByMarketType(MarketType market) {
        return persistence.findByMarket(market);
    }
}
