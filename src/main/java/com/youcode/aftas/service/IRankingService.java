package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.RankingDto;
import com.youcode.aftas.web.dto.store.StoreRankingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRankingService {
    List<RankingDto> findAll();
    StoreRankingDto registerMember(StoreRankingDto storeRankingDto);
}
