package com.Beetles.systempayout.backend.admin.controller.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AdminResponse(String nome,
                            String email) {
}
