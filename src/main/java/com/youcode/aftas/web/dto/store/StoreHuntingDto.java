package com.youcode.aftas.web.dto.store;

import com.youcode.aftas.web.dto.update.UpdateMemberDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StoreHuntingDto implements Serializable {
    @NotNull(message = "fish cannot be null.")
    private StoreFishDto fish;

    @NotNull(message = "member cannot be null.")
    private UpdateMemberDto member;

    @NotNull(message = "competition cannot be null.")
    private StoreCompetitionDto competition;
}