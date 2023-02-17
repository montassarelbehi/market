package com.company.market.domain.port.spi;

import com.company.market.domain.MarketType;
import com.company.market.domain.Park;

import java.util.List;

public interface ParkPersistencePort {

    Park create(Park park);

    List<Park> findByMarket(MarketType marketType);
}
