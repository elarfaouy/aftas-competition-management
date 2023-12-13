package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.LevelDto;
import com.youcode.aftas.web.dto.store.StoreLevelDto;
import org.springframework.stereotype.Service;

@Service
public interface ILevelService {
    LevelDto store(StoreLevelDto storeLevelDto);
}
