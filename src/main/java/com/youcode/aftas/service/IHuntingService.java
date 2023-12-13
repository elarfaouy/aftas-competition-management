package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.HuntingDto;
import com.youcode.aftas.web.dto.store.StoreHuntingDto;
import org.springframework.stereotype.Service;

@Service
public interface IHuntingService {
    HuntingDto store(StoreHuntingDto storeHuntingDto);
}
