package com.youcode.aftas.web.dto.store;

import com.youcode.aftas.web.dto.update.UpdateMemberDto;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record StoreHuntingDto(
        @NotNull(message = "fish cannot be null.") StoreFishDto fish,
        @NotNull(message = "member cannot be null.") UpdateMemberDto member,
        @NotNull(message = "competition cannot be null.") StoreCompetitionDto competition) implements Serializable {
}