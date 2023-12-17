package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.ICompetitionService;
import com.youcode.aftas.web.dto.read.CompetitionDto;
import com.youcode.aftas.web.dto.read.RankingDto;
import com.youcode.aftas.web.dto.store.StoreCompetitionDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competition")
public class CompetitionRest {
    @Qualifier("competitionService")
    private final ICompetitionService service;

    @GetMapping
    public Page<CompetitionDto> getAll(@RequestParam int page, @RequestParam int size) {
        return service.findAll(page, size);
    }

    @GetMapping("/{code}")
    public ResponseEntity<CompetitionDto> getOne(@PathVariable String code) {
        Optional<CompetitionDto> competitionDto = service.findOne(code);
        return competitionDto.map(dto -> ResponseEntity.ok().body(dto)).orElseGet(() -> ResponseEntity.notFound().build());
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
