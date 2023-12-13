package com.youcode.aftas.service.imp;

import com.youcode.aftas.domain.entity.Competition;
import com.youcode.aftas.domain.entity.Member;
import com.youcode.aftas.domain.entity.Ranking;
import com.youcode.aftas.domain.entity.RankingKey;
import com.youcode.aftas.exception.DataBaseConstraintException;
import com.youcode.aftas.repository.CompetitionRepository;
import com.youcode.aftas.repository.MemberRepository;
import com.youcode.aftas.repository.RankingRepository;
import com.youcode.aftas.service.IRankingService;
import com.youcode.aftas.web.dto.store.StoreRankingDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RankingService implements IRankingService {
    private final RankingRepository repository;
    private final CompetitionRepository competitionRepository;
    private final MemberRepository memberRepository;
    private final ModelMapper mapper;

    @Override
    public List<Ranking> findAll() {
        return repository.findAll();
    }

    @Override
    public StoreRankingDto registerMember(StoreRankingDto storeRankingDto) {
        Optional<Competition> optionalCompetition = competitionRepository.findById(storeRankingDto.getCompetition().getCode());
        if (optionalCompetition.isEmpty()) {
            throw new DataBaseConstraintException("their is no competition with that code.");
        }

        Optional<Member> optionalMember = memberRepository.findById(storeRankingDto.getMember().getNum());
        if (optionalMember.isEmpty()) {
            throw new DataBaseConstraintException("their is no member with that number.");
        }

        Ranking ranking = mapper.map(storeRankingDto, Ranking.class);
        ranking.setId(new RankingKey(storeRankingDto.getCompetition().getCode(), storeRankingDto.getMember().getNum()));

        Optional<Ranking> optional = repository.findById(ranking.getId());
        if (optional.isPresent()) {
            throw new DataBaseConstraintException("this member already registered in that competition.");
        }

        if (!isRegisterBeforeTwentyFourHours(optionalCompetition.get())) {
            throw new DataBaseConstraintException("you can't register now, the register close before 24 hour.");
        }

        Ranking saved = repository.save(ranking);
        return mapper.map(saved, StoreRankingDto.class);
    }

    private Boolean isRegisterBeforeTwentyFourHours(Competition competition) {
        LocalDateTime competitionDateTime = LocalDateTime.of(competition.getDate(), competition.getStartTime());
        LocalDateTime now = LocalDateTime.now();

        return now.isBefore(competitionDateTime.minusHours(24));
    }
}
