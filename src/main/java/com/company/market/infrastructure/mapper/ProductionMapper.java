package com.company.market.infrastructure.mapper;

import com.company.market.domain.Production;
import com.company.market.infrastructure.entity.ProductionEntity;
import com.company.market.infrastructure.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductionMapper {

    @Autowired
    private ProductionRepository repository;

    @Autowired
    private ParkMapper parkMapper;

    public ProductionEntity productionToProductionEntity(Production domain) {
        if (domain.getId() != null) {
            Optional<ProductionEntity> entity = repository.findById(domain.getId());
            if (entity.isPresent()) {
                return entity.get();
            }
        }
        return ProductionEntity.builder().id(domain.getId())
                .park(parkMapper.parkToParkEntity(domain.getPark()))
                .quantity(domain.getQuantity()).build();
    }

    protected Set<ProductionEntity> productionToProductionEntity(Set<Production> domainSet) {
        return domainSet.stream().map(this::productionToProductionEntity).collect(Collectors.toSet());
    }

    public static Production productionEntityToProduction(ProductionEntity entity) {
        return Production.builder().id(entity.getId()).park(ParkMapper.parkEntityToPark(entity.getPark()))
                .quantity(entity.getQuantity())
                .build();
    }

    protected static Set<Production> productionEntityToProduction(Set<ProductionEntity> entitySet) {
        return entitySet.stream().map(ProductionMapper::productionEntityToProduction).collect(Collectors.toSet());
    }
}
