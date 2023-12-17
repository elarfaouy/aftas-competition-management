package com.youcode.aftas.web.rest;

import com.youcode.aftas.service.IFishService;
import com.youcode.aftas.web.dto.read.FishDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fish")
public class FishRest {
    @Qualifier("fishService")
    private final IFishService service;

    @GetMapping
    public List<FishDto> getAll(){
        return service.findAll();
    }
}
