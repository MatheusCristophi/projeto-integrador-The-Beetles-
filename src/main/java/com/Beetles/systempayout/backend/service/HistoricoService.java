package com.Beetles.systempayout.backend.service;

import com.Beetles.systempayout.backend.domain.Historico;
import com.Beetles.systempayout.backend.domain.Aluno;
import com.Beetles.systempayout.backend.repository.HistoricoRepository;
import com.Beetles.systempayout.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final UserRepository userRepository;

    public HistoricoService(HistoricoRepository historicoRepository, UserRepository userRepository) {
        this.historicoRepository = historicoRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Historico registrarPagamento(Integer alunoId) {
        Aluno aluno = userRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
        if (aluno.getPlanoEscolhidoId() == null) {
            throw new RuntimeException("O usuário não possui nenhum plano vinculado");
        }
        Historico novoHistorico = new Historico();
        novoHistorico.setHistoricoAlunoId(aluno);
        novoHistorico.setValorCobrado(aluno.getPlanoEscolhidoId().getValor());
        novoHistorico.setStatusPagamento("Concluido");
        return historicoRepository.save(novoHistorico);
    }
}