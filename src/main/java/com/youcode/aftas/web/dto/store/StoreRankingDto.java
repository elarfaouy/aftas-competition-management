package com.youcode.aftas.web.dto.store;

import com.youcode.aftas.web.dto.update.UpdateMemberDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StoreRankingDto implements Serializable {
    @NotNull(message = "id cannot be null.")
    private RankingKeyDto id;

    @NotNull(message = "rank cannot be null.")
    private Integer rank;

    @NotNull(message = "score cannot be null.")
    @PositiveOrZero(message = "score cannot be negative.")
    private Integer score;

    @NotNull(message = "competition cannot be null.")
    private StoreCompetitionDto competition;

    @NotNull(message = "member cannot be null.")
    private UpdateMemberDto member;

    public static class RankingKeyDto implements Serializable {
        @NotNull(message = "code cannot be null.")
        @NotBlank(message = "code cannot be blank.")
        private String code;

        @NotNull(message = "num cannot be null.")
        @Positive(message = "num cannot be negative.")
        private Integer num;
    }
}