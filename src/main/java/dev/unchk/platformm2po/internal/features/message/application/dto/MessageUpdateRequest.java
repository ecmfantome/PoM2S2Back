package dev.unchk.platformm2po.internal.features.message.application.dto;


import jakarta.validation.constraints.NotBlank;



public record MessageUpdateRequest(
        @NotBlank
        String id,
        @NotBlank
        String message,
        @NotBlank
        Boolean lu
        ) {
}


