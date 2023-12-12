package com.youcode.aftas.web.dto.read;

import com.youcode.aftas.domain.entity.Competition;
import com.youcode.aftas.domain.entity.Member;

import java.io.Serializable;

public record HuntingDto(
        Integer id,
        Integer numberOfFish,
        FishDto fish,
        MemberDto member,
        CompetitionDto competition) implements Serializable {
}