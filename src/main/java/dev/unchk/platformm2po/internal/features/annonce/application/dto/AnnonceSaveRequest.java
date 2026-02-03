package dev.unchk.platformm2po.internal.features.annonce.application.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;


public record AnnonceSaveRequest(
        @NotBlank
        String titre,
        @NotBlank
        String type,
        @NotBlank
        String message,
        @NotBlank
        String courseId,
        @NotBlank
        Instant datePublication
) {
}

