package com.company.market.infrastructure.mapper;

import com.company.market.domain.Block;
import com.company.market.infrastructure.entity.BlockEntity;
import com.company.market.infrastructure.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BlockMapper {

    @Autowired
    private BlockRepository repository;


    @Autowired
    private ProductionMapper productionMapper;

    public BlockEntity blockToBlockEntity(Block domain) {
        if (domain.getId() != null) {
            Optional<BlockEntity> entity = repository.findById(domain.getId());
            if (entity.isPresent()) {
                return entity.get();
            }
        }
        return BlockEntity.builder().id(domain.getId())
                .startDateTime(domain.getStartDateTime())
                .endDateTime(domain.getEndDateTime())
                .productions(productionMapper.productionToProductionEntity(domain.getProductions()))
                .priceThreshold(domain.getPriceThreshold())
                .build();
    }

    public Set<BlockEntity> blockToBlockEntity(Set<Block> domainSet) {
        return domainSet.stream().map(this::blockToBlockEntity).collect(Collectors.toSet());
    }

    public static Block blockEntityToBlock(BlockEntity entity) {
        return Block.builder().id(entity.getId())
                .startDateTime(entity.getStartDateTime())
                .endDateTime(entity.getEndDateTime())
                .productions(ProductionMapper.productionEntityToProduction(entity.getProductions()))
                .priceThreshold(entity.getPriceThreshold())
                .build();
    }

    public static Set<Block> blockEntityToBlock(Set<BlockEntity> entitySet) {
        return entitySet.stream().map(BlockMapper::blockEntityToBlock).collect(Collectors.toSet());
    }
}
