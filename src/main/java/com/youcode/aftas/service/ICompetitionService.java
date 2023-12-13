package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.CompetitionDto;
import com.youcode.aftas.web.dto.store.StoreCompetitionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompetitionService {
    List<CompetitionDto> findAll();

    CompetitionDto store(StoreCompetitionDto storeCompetitionDto);
}
