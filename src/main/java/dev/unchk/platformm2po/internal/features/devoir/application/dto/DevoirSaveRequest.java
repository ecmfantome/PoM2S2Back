package dev.unchk.platformm2po.internal.features.devoir.application.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;


public record DevoirSaveRequest(
        @NotBlank
        String titre,
        @NotBlank
        String consigne,
        @NotBlank
        String courseId,
        @NotBlank
        Instant dateLimite

) {
}

