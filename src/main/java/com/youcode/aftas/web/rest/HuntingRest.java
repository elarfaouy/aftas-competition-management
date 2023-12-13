package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.IHuntingService;
import com.youcode.aftas.web.dto.read.HuntingDto;
import com.youcode.aftas.web.dto.store.StoreHuntingDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hunting")
public class HuntingRest {
    @Qualifier("huntingService")
    private final IHuntingService service;

    @PostMapping
    public HuntingDto save(@Valid @RequestBody StoreHuntingDto storeHuntingDto) {
        return service.store(storeHuntingDto);
    }
}
