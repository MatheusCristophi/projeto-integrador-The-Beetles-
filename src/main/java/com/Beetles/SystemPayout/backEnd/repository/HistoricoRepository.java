package com.Beetles.SystemPayout.backEnd.repository;

import com.Beetles.SystemPayout.backEnd.domain.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
}
