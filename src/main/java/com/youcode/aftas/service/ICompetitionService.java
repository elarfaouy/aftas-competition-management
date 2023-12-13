package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.CompetitionDto;
import com.youcode.aftas.web.dto.read.RankingDto;
import com.youcode.aftas.web.dto.store.StoreCompetitionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICompetitionService {
    List<CompetitionDto> findAll();

    Optional<CompetitionDto> findOne(String code);

    CompetitionDto store(StoreCompetitionDto storeCompetitionDto);

    List<RankingDto> calculateScore(String code);
}
