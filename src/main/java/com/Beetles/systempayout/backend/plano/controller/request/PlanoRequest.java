package com.Beetles.systempayout.backend.plano.controller.request;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;

@Builder
public record PlanoRequest(String nome,
                           Set<Aluno> alunos,
                           String categoria,
                           int frequenciaAulas,
                           BigDecimal valor,
                           boolean ativo) {
}
