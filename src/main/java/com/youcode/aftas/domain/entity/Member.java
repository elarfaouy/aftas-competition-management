package com.youcode.aftas.domain.entity;

import com.youcode.aftas.domain.enums.IdentityDocumentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Member {
    @Id
    private Integer num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    @Column(unique = true)
    private String identityNumber;
    private IdentityDocumentType identityDocument;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Hunting> huntingList;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Ranking> rankingList;
}
