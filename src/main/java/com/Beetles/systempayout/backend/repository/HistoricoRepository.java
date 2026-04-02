package com.Beetles.systempayout.backend.repository;

import com.Beetles.systempayout.backend.domain.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
}
