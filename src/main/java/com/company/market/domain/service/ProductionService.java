package com.company.market.domain.service;

import com.company.market.domain.Production;
import com.company.market.domain.port.api.ProductionServicePort;
import com.company.market.domain.port.spi.ProductionPersistencePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductionService implements ProductionServicePort {

    private final ProductionPersistencePort persistence;

    @Override
    public Production create(Production production) {
        return persistence.create(production);
    }

}
