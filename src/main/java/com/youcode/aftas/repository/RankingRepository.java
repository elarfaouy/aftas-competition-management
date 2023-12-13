package com.youcode.aftas.repository;

import com.youcode.aftas.domain.entity.Ranking;
import com.youcode.aftas.domain.entity.RankingKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking, RankingKey> {
}
