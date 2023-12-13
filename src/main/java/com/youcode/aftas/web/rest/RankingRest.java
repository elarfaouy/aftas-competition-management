package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.IRankingService;
import com.youcode.aftas.web.dto.read.RankingDto;
import com.youcode.aftas.web.dto.store.StoreRankingDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/register")
public class RankingRest {
    @Qualifier("rankingService")
    private final IRankingService service;

    @GetMapping
    public List<RankingDto> getAll() {
        return service.findAll();
    }

    @PostMapping
    public StoreRankingDto registerMemberToCompetition(@Valid @RequestBody StoreRankingDto storeRankingDto) {
        return service.registerMember(storeRankingDto);
    }
}
