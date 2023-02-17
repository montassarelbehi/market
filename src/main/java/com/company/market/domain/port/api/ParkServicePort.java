package com.company.market.domain.port.api;

import com.company.market.domain.MarketType;
import com.company.market.domain.Park;

import java.util.List;

public interface ParkServicePort {

    Park create(Park park);

    List<Park> findByMarket(MarketType marketType);
}
