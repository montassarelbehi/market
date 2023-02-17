package com.company.market.domain.service;

import com.company.market.domain.MarketType;
import com.company.market.domain.Park;
import com.company.market.domain.port.api.ParkServicePort;
import com.company.market.domain.port.spi.ParkPersistencePort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ParkService implements ParkServicePort {

    private final ParkPersistencePort persistence;

    @Override
    public Park create(Park park) {
        return persistence.create(park);
    }

    @Override
    public List<Park> findByMarket(MarketType marketType){
        return persistence.findByMarket(marketType);
    }
}
