package com.company.market.domain.port.spi;

import com.company.market.domain.Block;

public interface BlockPersistencePort {

    Block create(Block block);

}
