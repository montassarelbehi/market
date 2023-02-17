package com.company.market.infrastructure.mapper;

import com.company.market.domain.Park;
import com.company.market.infrastructure.entity.ParkEntity;
import com.company.market.infrastructure.repository.ParkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ParkMapper {

    @Autowired
    private ParkRepository repository;

    public ParkEntity parkToParkEntity(Park domain) {
        if (domain.getId() != null) {
            Optional<ParkEntity> entity = repository.findById(domain.getId());
            if (entity.isPresent()) {
                return entity.get();
            }
        }
        return ParkEntity.builder().id(domain.getId()).type(domain.getType()).build();
    }

    public static Park parkEntityToPark(ParkEntity entity) {
        return Park.builder().id(entity.getId()).type(entity.getType()).build();
    }

    public static List<Park> parkEntityToPark(List<ParkEntity> entities) {
        return entities.stream().map(ParkMapper::parkEntityToPark).collect(Collectors.toList());
    }
}
