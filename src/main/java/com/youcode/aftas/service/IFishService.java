package com.youcode.aftas.service;

import com.youcode.aftas.web.dto.read.FishDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFishService {
    List<FishDto> findAll();
}
