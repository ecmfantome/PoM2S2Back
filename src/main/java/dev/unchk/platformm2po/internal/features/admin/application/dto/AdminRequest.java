package dev.unchk.platformm2po.internal.features.admin.application.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminRequest(
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
        @NotBlank
        String post
) {
}
