package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.ICompetitionService;
import com.youcode.aftas.web.dto.read.CompetitionDto;
import com.youcode.aftas.web.dto.read.RankingDto;
import com.youcode.aftas.web.dto.store.StoreCompetitionDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competition")
public class CompetitionRest {
    @Qualifier("competitionService")
    private final ICompetitionService service;

    @GetMapping
    public List<CompetitionDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public CompetitionDto save(@Valid @RequestBody StoreCompetitionDto storeCompetitionDto) {
        return service.store(storeCompetitionDto);
    }

    @GetMapping("/score/{code}")
    public List<RankingDto> calculateScore(@PathVariable String code){
        return service.calculateScore(code);
    }
}
