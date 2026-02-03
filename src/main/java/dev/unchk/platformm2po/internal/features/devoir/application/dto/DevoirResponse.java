package dev.unchk.platformm2po.internal.features.devoir.application.dto;

import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import lombok.Builder;

import java.time.Instant;

@Builder
public record DevoirResponse(
        String id,
        String titre,
        String consigne,
        Course course,
        Instant dateLimite,
        Instant createdAt,
        Instant updatedAt
) {
}
