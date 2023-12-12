package com.youcode.aftas.web.dto.read;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionDto(
        String code,
        LocalDate date,
        LocalTime startTime,
        LocalTime endTime,
        String location,
        Double amount) implements Serializable {
}