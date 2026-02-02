package dev.unchk.platformm2po.internal.features.courses.application.dto;


import jakarta.validation.constraints.NotBlank;



public record CourseUpdateRequest(
        @NotBlank
        String id,
        @NotBlank
        String titre,
        String description,
        @NotBlank
        String semester,
        @NotBlank
        int credit,
        @NotBlank
        String moduleId,
        @NotBlank
        String adminId,
        @NotBlank
        String createdBy

) {
}
