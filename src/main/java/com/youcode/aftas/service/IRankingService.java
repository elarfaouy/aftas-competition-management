package com.youcode.aftas.service;

import com.youcode.aftas.domain.entity.Ranking;
import com.youcode.aftas.web.dto.store.StoreRankingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRankingService {
    List<Ranking> findAll();
    StoreRankingDto registerMember(StoreRankingDto storeRankingDto);
}
