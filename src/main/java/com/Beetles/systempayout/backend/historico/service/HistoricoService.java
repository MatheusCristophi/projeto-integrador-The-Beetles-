package com.Beetles.systempayout.backend.historico.service;

import com.Beetles.systempayout.backend.historico.model.Historico;
import com.Beetles.systempayout.backend.aluno.model.Aluno;
import com.Beetles.systempayout.backend.historico.repository.HistoricoRepository;
import com.Beetles.systempayout.backend.aluno.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoricoService {

    private final HistoricoRepository historicoRepository;
    private final AlunoRepository alunoRepository;

    public HistoricoService(HistoricoRepository historicoRepository, AlunoRepository alunoRepository) {
        this.historicoRepository = historicoRepository;
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Historico registrarPagamento(Integer alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
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