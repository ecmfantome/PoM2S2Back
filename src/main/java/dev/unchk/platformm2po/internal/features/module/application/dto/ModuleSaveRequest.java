package dev.unchk.platformm2po.internal.features.module.application.dto;

import jakarta.validation.constraints.NotBlank;


public record ModuleSaveRequest(
        @NotBlank
        String name,
        @NotBlank
        String semester,
        @NotBlank
        String code,
        String responsibleId,
        @NotBlank
        String adminId
) {
}

