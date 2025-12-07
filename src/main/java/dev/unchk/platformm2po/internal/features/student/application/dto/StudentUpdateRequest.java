package dev.unchk.platformm2po.internal.features.student.application.dto;


import jakarta.validation.constraints.NotBlank;

public record StudentUpdateRequest(
        @NotBlank
        String userId,
        String name,
        String lastName,
        String email,
        String phone,
        Boolean isActive,
        String backToSchoolYear
) {
}
