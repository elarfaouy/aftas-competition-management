package com.youcode.aftas.web.dto.read;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LevelDto implements Serializable {
    private Integer code;
    private Integer points;
    private String description;
}