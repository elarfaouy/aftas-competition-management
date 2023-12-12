package com.youcode.aftas.repository;

import com.youcode.aftas.domain.entity.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HuntingRepository extends JpaRepository<Hunting, Integer> {
}
