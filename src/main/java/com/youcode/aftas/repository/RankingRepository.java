package com.youcode.aftas.repository;

import com.youcode.aftas.domain.entity.Competition;
import com.youcode.aftas.domain.entity.Ranking;
import com.youcode.aftas.domain.entity.RankingKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, RankingKey> {
    List<Ranking> findByCompetition(Competition competition);
}
