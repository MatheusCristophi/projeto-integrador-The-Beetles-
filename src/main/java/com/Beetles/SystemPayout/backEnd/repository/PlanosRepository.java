package com.Beetles.SystemPayout.backEnd.repository;

import com.Beetles.SystemPayout.backEnd.domain.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanosRepository extends JpaRepository<Planos, Integer> {
}
