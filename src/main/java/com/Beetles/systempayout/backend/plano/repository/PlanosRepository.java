package com.Beetles.systempayout.backend.plano.repository;

import com.Beetles.systempayout.backend.plano.model.Planos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanosRepository extends JpaRepository<Planos, Integer> {
}
