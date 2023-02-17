package com.company.market.application.rest;

import com.company.market.domain.MarketType;
import com.company.market.domain.Park;
import com.company.market.domain.port.api.ParkServicePort;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/parks")
@RestController
@AllArgsConstructor
@Validated
public class ParkController {

    private final ParkServicePort service;

    @PostMapping
    public @Valid Park create(@RequestBody @Valid Park park){

        return service.create(park);
    }

    @GetMapping("/{market}")
    public List<Park> findByMarket(@PathVariable MarketType market) {
        return service.findByMarket(market);
    }
}
