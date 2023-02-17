package com.company.market.infrastructure.repository;

import com.company.market.domain.MarketType;
import com.company.market.infrastructure.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<OfferEntity, UUID> {

    List<OfferEntity> findByMarket(MarketType market);
}
