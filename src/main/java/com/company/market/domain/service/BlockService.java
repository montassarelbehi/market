package com.company.market.domain.service;

import com.company.market.domain.Block;
import com.company.market.domain.port.api.BlockServicePort;
import com.company.market.domain.port.spi.BlockPersistencePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BlockService implements BlockServicePort {

    private final BlockPersistencePort persistence;

    @Override
    public Block create(Block block) {
        return persistence.create(block);
    }

}
