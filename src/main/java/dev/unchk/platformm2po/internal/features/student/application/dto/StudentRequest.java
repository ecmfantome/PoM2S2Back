package dev.unchk.platformm2po.internal.features.student.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record StudentRequest(
        @NotBlank
        String name,
        @NotBlank
        String lastName,
        @Email
        String email,
        @NotBlank
        String phone,
        @NotNull
        Boolean isActive,
        @NotNull
        String backToSchoolYear
) {
}

