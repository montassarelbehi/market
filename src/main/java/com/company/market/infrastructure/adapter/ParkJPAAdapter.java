package com.company.market.infrastructure.adapter;

import com.company.market.domain.MarketType;
import com.company.market.domain.Park;
import com.company.market.domain.port.spi.ParkPersistencePort;
import com.company.market.infrastructure.entity.ParkEntity;
import com.company.market.infrastructure.mapper.ParkMapper;
import com.company.market.infrastructure.repository.OfferRepository;
import com.company.market.infrastructure.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ParkJPAAdapter implements ParkPersistencePort {

    @Autowired
    private ParkRepository repository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ParkMapper mapper;

    @Override
    public Park create(Park park) {
        ParkEntity entity = mapper.parkToParkEntity(park);
        ParkEntity persisted = repository.save(entity);

        return ParkMapper.parkEntityToPark(persisted);
    }

    @Override
    public List<Park> findByMarket(MarketType marketType) {
        //TODO WIP: filter by dateTimes to handle the "qui vendent sur un marché"
//        return offerRepository.findByMarket(marketType).stream()
//                .map(OfferEntity::getBlocks)
//                .flatMap(Collection::stream)
//                .map(BlockEntity::getProductions)
//                .flatMap(Collection::stream)
//                .map(ProductionEntity::getPark)
//                .map(ParkMapper::parkEntityToPark)
//                .collect(Collectors.toList());

        return ParkMapper.parkEntityToPark(repository.findByMarket(marketType));
    }
}
