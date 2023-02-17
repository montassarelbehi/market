package com.company.market.domain.port.spi;

import com.company.market.domain.Production;

public interface ProductionPersistencePort {

    Production create(Production production);

}
