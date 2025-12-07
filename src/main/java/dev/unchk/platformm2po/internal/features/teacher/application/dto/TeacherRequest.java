package dev.unchk.platformm2po.internal.features.teacher.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record TeacherRequest(
        @NotBlank
        String name,
        @NotBlank
        String lastName,
        @NotBlank   @Email
        String email,
        @NotBlank
        String phone,
        @NotNull
        Boolean isActive,
        @NotBlank
        String speciality,
        @NotBlank
        String department) {
}

