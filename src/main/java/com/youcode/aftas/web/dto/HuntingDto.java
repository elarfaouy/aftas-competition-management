package com.youcode.aftas.web.dto;

import com.youcode.aftas.domain.entity.Competition;
import com.youcode.aftas.domain.entity.Member;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serializable;

public record HuntingDto(
        @NotNull(message = "id cannot be null.") @Positive(message = "id cannot be negative.") Integer id,
        @NotNull(message = "number of fish cannot be null.") @PositiveOrZero(message = "number of fish cannot be negative.") Integer numberOfFish,
        @NotNull(message = "fish cannot be null.") FishDto fish,
        @NotNull(message = "member cannot be null.") Member member,
        @NotNull(message = "competition cannot be null.") Competition competition) implements Serializable {
}