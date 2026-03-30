package com.Beetles.SystemPayout.backEnd.service;

import com.Beetles.SystemPayout.backEnd.domain.Historico;
import com.Beetles.SystemPayout.backEnd.domain.User;
import com.Beetles.SystemPayout.backEnd.repository.HistoricoRepository;
import com.Beetles.SystemPayout.backEnd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final UserRepository userRepository;

    public HistoricoService(HistoricoRepository historicoRepository, UserRepository userRepository) {
        this.historicoRepository = historicoRepository;
        this.userRepository = userRepository;
    }

    public Historico registrarPagamento(Integer alunoId) {
        User aluno = userRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Id não encontrado"));
        if (aluno.getPlanoescolhidoId() == null) {
            throw new RuntimeException("O usuário não possui nenhum plano vinculado");
        }
        Historico novoHistorico = new Historico();
        novoHistorico.setHistoricoAlunoId(aluno);
        novoHistorico.setValorCobrado(aluno.getPlanoescolhidoId().getValor());
        novoHistorico.setDataSolicitacao(LocalDateTime.now());
        novoHistorico.setStatusPagamento("Concluido");
        return historicoRepository.save(novoHistorico);
    }
}