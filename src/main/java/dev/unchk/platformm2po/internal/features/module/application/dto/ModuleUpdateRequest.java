package dev.unchk.platformm2po.internal.features.module.application.dto;


import jakarta.validation.constraints.NotBlank;


public record ModuleUpdateRequest(
        @NotBlank
        String id,
        @NotBlank
        String name,
        @NotBlank
        String semester,
        @NotBlank
        String code,
        @NotBlank
        String createdBy,

        String responsibleId
) {
}
