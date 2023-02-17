package com.company.market.infrastructure.repository;

import com.company.market.infrastructure.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlockRepository extends JpaRepository<BlockEntity, UUID> {
}


