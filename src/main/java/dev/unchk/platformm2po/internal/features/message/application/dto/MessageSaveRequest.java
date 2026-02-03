package dev.unchk.platformm2po.internal.features.message.application.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;


public record MessageSaveRequest(
        @NotBlank
        String message,
        @NotBlank
        Boolean lu,
        @NotBlank
        Instant dateEnvoi
) {
}

