package dev.unchk.platformm2po.internal.features.message.application.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
public record MessageResponse(
        String id,
        String message,
        Boolean lu,
        Instant dateEnvoi,
        Instant createdAt,
        Instant updatedAt
) {
}
