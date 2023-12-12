package com.youcode.aftas.web.dto.read;

import java.io.Serializable;

public record LevelDto(
        Integer code,
        Integer points,
        String description) implements Serializable {
}