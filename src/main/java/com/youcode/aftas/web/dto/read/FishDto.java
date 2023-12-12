package com.youcode.aftas.web.dto.read;

import java.io.Serializable;

public record FishDto(
        String name,
        Double averageWeight,
        LevelDto level) implements Serializable {
}