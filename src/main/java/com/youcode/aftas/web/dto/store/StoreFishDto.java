package com.youcode.aftas.web.dto.store;

import com.youcode.aftas.web.dto.update.UpdateLevelDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

public record StoreFishDto(
        @NotNull(message = "name cannot be null.") @NotBlank(message = "name cannot be blank.") String name,
        @NotNull(message = "average weight cannot be null.") @Positive(message = "average weight cannot be negative.") Double averageWeight,
        @NotNull(message = "level cannot be null.") UpdateLevelDto level) implements Serializable {
}