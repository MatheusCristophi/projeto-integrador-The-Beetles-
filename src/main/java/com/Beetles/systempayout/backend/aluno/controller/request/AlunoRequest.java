package com.Beetles.systempayout.backend.aluno.controller.request;


import com.Beetles.systempayout.backend.plano.model.Plano;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record AlunoRequest(@NotBlank
                           String nome,
                           @NotBlank
                           String email,
                           @Size(min = 9, max = 13, message = "O número deve conter entre 9 e 13 caracteres")
                           String numero,
                           @Size(min = 8, max = 15, message = "A senha deve conter entre 8 e 15 caracteres")
                           @Nullable
                           String senha,
                           @Nullable
                           Plano plano
                           ) {
}
