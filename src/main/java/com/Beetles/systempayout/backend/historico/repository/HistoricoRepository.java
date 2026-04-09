package com.Beetles.systempayout.backend.historico.repository;

import com.Beetles.systempayout.backend.historico.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
}
