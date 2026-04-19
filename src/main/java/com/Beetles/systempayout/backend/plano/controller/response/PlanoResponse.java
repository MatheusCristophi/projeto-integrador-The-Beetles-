package com.Beetles.systempayout.backend.plano.controller.response;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.Set;

@Builder
public record PlanoResponse(String nome,
                            Set<Aluno> alunos,
                            String categoria,
                            int frequenciaAulas,
                            BigDecimal valor) {
}
