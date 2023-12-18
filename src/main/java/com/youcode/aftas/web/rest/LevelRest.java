package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.ILevelService;
import com.youcode.aftas.web.dto.read.LevelDto;
import com.youcode.aftas.web.dto.store.StoreLevelDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/level")
public class LevelRest {
    @Qualifier("levelService")
    private final ILevelService service;

    @PostMapping
    public LevelDto save(@Valid @RequestBody StoreLevelDto storeLevelDto){
        return service.store(storeLevelDto);
    }
}
