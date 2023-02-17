package com.company.market.infrastructure.repository;

import com.company.market.domain.MarketType;
import com.company.market.infrastructure.entity.ParkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ParkRepository extends JpaRepository<ParkEntity, UUID> {

    @Query(nativeQuery = true, value = "SELECT p.* FROM PARK p \n" +
            "JOIN PRODUCTION  pr ON pr.PARK_ID = p.ID \n" +
            "JOIN BLOCK_PRODUCTIONS bp ON bp.PRODUCTIONS_ID = pr.ID \n" +
            "JOIN BLOCK b ON b.ID = bp.BLOCK_ENTITY_ID \n" +
            "JOIN OFFER_BLOCKS ob ON ob.BLOCKS_ID = b.ID \n" +
            "JOIN OFFER o ON o.ID = ob.OFFER_ENTITY_ID \n" +
            "WHERE o.MARKET = :#{#market.name()}")
    List<ParkEntity> findByMarket(@Param("market") MarketType marketType);
}