package com.company.market.infrastructure.adapter;

import com.company.market.domain.Production;
import com.company.market.domain.port.spi.ProductionPersistencePort;
import com.company.market.infrastructure.entity.ProductionEntity;
import com.company.market.infrastructure.mapper.ProductionMapper;
import com.company.market.infrastructure.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductionJPAAdapter implements ProductionPersistencePort {

    @Autowired
    private ProductionRepository repository;

    @Autowired
    private ProductionMapper mapper;

    @Override
    public Production create(Production production) {
        ProductionEntity entity = mapper.productionToProductionEntity(production);
        ProductionEntity persisted = repository.save(entity);
        return ProductionMapper.productionEntityToProduction(persisted);
    }
}
