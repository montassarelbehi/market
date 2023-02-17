package com.company.market.application.rest;

import com.company.market.domain.MarketType;
import com.company.market.domain.Offer;
import com.company.market.domain.port.api.OfferServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/offers")
@RestController
@AllArgsConstructor
public class OfferController {

    private final OfferServicePort service;

    @PostMapping
    public Offer create(@RequestBody Offer offer){ //TODO split to OfferRequest and OfferResponse

        return service.create(offer);
    }

    @GetMapping("/{market}")
    public List<Offer> findByMarketType(@PathVariable MarketType market){

        return service.findByMarketType(market);
    }
}
