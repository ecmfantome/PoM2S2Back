package dev.unchk.platformm2po.internal.features.courses.application.dto;

import jakarta.validation.constraints.NotBlank;


public record CourseSaveRequest(
        @NotBlank
        String titre,
        String description,
        @NotBlank
        String semester,
        @NotBlank
        int credit,
        String moduleId,
        @NotBlank
        String adminId
) {
}

