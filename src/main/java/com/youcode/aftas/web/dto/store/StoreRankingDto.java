package com.youcode.aftas.web.dto.store;

import com.youcode.aftas.web.dto.update.UpdateMemberDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serializable;

public record StoreRankingDto(@NotNull(message = "id cannot be null.") RankingKeyDto id,
                              @NotNull(message = "rank cannot be null.") Integer rank,
                              @NotNull(message = "score cannot be null.") @PositiveOrZero(message = "score cannot be negative.") Integer score,
                              @NotNull(message = "competition cannot be null.") StoreCompetitionDto competition,
                              @NotNull(message = "member cannot be null.") UpdateMemberDto member) implements Serializable {
    public record RankingKeyDto(
            @NotNull(message = "code cannot be null.") @NotBlank(message = "code cannot be blank.") String code,
            @NotNull(message = "num cannot be null.") @Positive(message = "num cannot be negative.") Integer num) implements Serializable {
    }
}