package com.company.market.infrastructure.configuration;

import com.company.market.domain.port.api.BlockServicePort;
import com.company.market.domain.port.api.OfferServicePort;
import com.company.market.domain.port.api.ParkServicePort;
import com.company.market.domain.port.api.ProductionServicePort;
import com.company.market.domain.port.spi.BlockPersistencePort;
import com.company.market.domain.port.spi.OfferPersistencePort;
import com.company.market.domain.port.spi.ParkPersistencePort;
import com.company.market.domain.port.spi.ProductionPersistencePort;
import com.company.market.domain.service.BlockService;
import com.company.market.domain.service.OfferService;
import com.company.market.domain.service.ParkService;
import com.company.market.domain.service.ProductionService;
import com.company.market.infrastructure.adapter.BlockJPAAdapter;
import com.company.market.infrastructure.adapter.OfferJPAAdapter;
import com.company.market.infrastructure.adapter.ParkJPAAdapter;
import com.company.market.infrastructure.adapter.ProductionJPAAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return JsonMapper.builder().addModule(new JavaTimeModule()).build();
    }

    @Bean
    public OfferPersistencePort offerPersistence() {
        return new OfferJPAAdapter();
    }

    @Bean
    public OfferServicePort offerService(){
        return new OfferService(offerPersistence());
    }

    @Bean
    public ParkPersistencePort parkPersistence() { return new ParkJPAAdapter(); }

    @Bean
    public ParkServicePort parkService() {
        return new ParkService(parkPersistence());
    }

    @Bean
    public ProductionPersistencePort productionPersistence() { return new ProductionJPAAdapter(); }

    @Bean
    public ProductionServicePort productionService() {
        return new ProductionService(productionPersistence());
    }

    @Bean
    public BlockPersistencePort blockPersistence() { return new BlockJPAAdapter(); }

    @Bean
    public BlockServicePort blockService() {
        return new BlockService(blockPersistence());
    }
}
