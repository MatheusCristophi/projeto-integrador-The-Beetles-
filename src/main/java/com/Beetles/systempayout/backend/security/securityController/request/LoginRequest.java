package com.Beetles.systempayout.backend.security.securityController.request;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank
                           String email,
                           @NotBlank
                           String senha){
}
