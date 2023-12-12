package com.youcode.aftas.web.dto.read;

import com.youcode.aftas.domain.enums.IdentityDocumentType;

import java.io.Serializable;
import java.time.LocalDate;

public record MemberDto(
        Integer num,
        String name,
        String familyName,
        LocalDate accessionDate,
        String nationality,
        String identityNumber,
        IdentityDocumentType identityDocument) implements Serializable {
}