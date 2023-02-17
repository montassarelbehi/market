package com.company.market.infrastructure.adapter;

import com.company.market.domain.Block;
import com.company.market.domain.port.spi.BlockPersistencePort;
import com.company.market.infrastructure.entity.BlockEntity;
import com.company.market.infrastructure.mapper.BlockMapper;
import com.company.market.infrastructure.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BlockJPAAdapter implements BlockPersistencePort {

    @Autowired
    private BlockRepository repository;

    @Autowired
    private BlockMapper mapper;

    @Override
    public Block create(Block block) {

        BlockEntity entity = mapper.blockToBlockEntity(block);
        BlockEntity persisted = repository.save(entity);
        return mapper.blockEntityToBlock(persisted);
    }


}
