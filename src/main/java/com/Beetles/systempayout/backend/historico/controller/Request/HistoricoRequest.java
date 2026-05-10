package com.Beetles.systempayout.backend.historico.controller.Request;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record HistoricoRequest(@NotNull
                               Aluno aluno) {
}
