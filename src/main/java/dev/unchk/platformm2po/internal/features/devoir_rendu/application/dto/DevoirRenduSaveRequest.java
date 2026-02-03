package dev.unchk.platformm2po.internal.features.devoir_rendu.application.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;


public record DevoirRenduSaveRequest(
        @NotBlank
        String description,
        @NotBlank
        String fileName,
        @NotBlank
        String contentType,
        @NotBlank
        byte[]  fileContent
) {
}

