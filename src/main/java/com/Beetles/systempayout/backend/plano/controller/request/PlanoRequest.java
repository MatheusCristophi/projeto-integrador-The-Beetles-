package com.Beetles.systempayout.backend.plano.controller.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public record PlanoRequest(@NotBlank
                           String nome,
                           @Nullable
                           Set<UUID> alunos,
                           @NotBlank
                           String categoria,
                           @NotNull
                           int frequenciaAulas,
                           @NotNull
                           BigDecimal valor,
                           @NotNull
                           boolean ativo) {
}
