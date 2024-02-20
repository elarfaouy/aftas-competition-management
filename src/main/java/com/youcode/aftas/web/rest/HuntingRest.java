package com.youcode.aftas.web.rest;

import com.youcode.aftas.dto.payload.HuntingDto;
import com.youcode.aftas.dto.store.StoreHuntingDto;
import com.youcode.aftas.service.IHuntingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hunting")
public class HuntingRest {
    private final IHuntingService huntingService;

    @PostMapping
    public HuntingDto save(@Valid @RequestBody StoreHuntingDto storeHuntingDto) {
        return huntingService.store(storeHuntingDto);
    }

    @GetMapping("/competition/{code}")
    public List<HuntingDto> getAllByCompetition(@PathVariable String code) {
        return huntingService.findByCompetition(code);
    }
}
