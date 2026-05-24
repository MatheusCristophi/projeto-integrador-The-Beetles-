package com.Beetles.systempayout.backend.security.securityController.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AlterarSenhaRequest(
        @NotBlank String email,
        @Size(min = 8, max = 15) String senha
) {}