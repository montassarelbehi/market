package com.company.market.infrastructure.repository;

import com.company.market.infrastructure.entity.ProductionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductionRepository extends JpaRepository<ProductionEntity, UUID> {
}
