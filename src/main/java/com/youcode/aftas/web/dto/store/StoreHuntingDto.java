package com.youcode.aftas.web.dto.store;

import com.youcode.aftas.domain.entity.Competition;
import com.youcode.aftas.domain.entity.Member;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record StoreHuntingDto(
        @NotNull(message = "fish cannot be null.") StoreFishDto fish,
        @NotNull(message = "member cannot be null.") Member member,
        @NotNull(message = "competition cannot be null.") Competition competition) implements Serializable {
}