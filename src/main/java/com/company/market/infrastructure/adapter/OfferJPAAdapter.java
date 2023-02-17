package com.company.market.infrastructure.adapter;

import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;
import com.company.market.domain.port.spi.OfferPersistencePort;
import com.company.market.infrastructure.entity.OfferEntity;
import com.company.market.infrastructure.mapper.BlockMapper;
import com.company.market.infrastructure.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OfferJPAAdapter implements OfferPersistencePort {

    @Autowired
    private OfferRepository repository;

    @Autowired
    private BlockMapper blockMapper;

    @Transactional
    @Override
    public Offer create(Offer offer) {
        OfferEntity entity = offerToOfferEntity(offer);
        OfferEntity persisted = repository.save(entity);

        return offerEntityToOffer(persisted);
    }

    @Override
    public List<Offer> findByMarket(MarketType market) {
        List<OfferEntity> entities = repository.findByMarket(market);
        return offerEntityListToOfferList(entities);
    }

    private OfferEntity offerToOfferEntity(Offer domain) {
        if (domain.getId() != null) {
            Optional<OfferEntity> entity = repository.findById(domain.getId());
            if (entity.isPresent()) {
                return entity.get();
            }
        }
        return OfferEntity.builder()
                .id(domain.getId())
                .market(domain.getMarket())
                .blocks(blockMapper.blockToBlockEntity(domain.getBlocks()))
                .build();
    }

    private static Offer offerEntityToOffer(OfferEntity entity){
        return Offer.builder()
                .id(entity.getId())
                .market(entity.getMarket())
                .blocks(BlockMapper.blockEntityToBlock(entity.getBlocks()))
                .build();
    }

    private static List<Offer> offerEntityListToOfferList(List<OfferEntity> entities) {
        return entities.stream().map(OfferJPAAdapter::offerEntityToOffer).collect(Collectors.toList());
    }
}
