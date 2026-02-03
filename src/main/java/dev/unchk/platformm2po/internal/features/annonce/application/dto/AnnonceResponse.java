package dev.unchk.platformm2po.internal.features.annonce.application.dto;

import dev.unchk.platformm2po.internal.features.courses.domain.entities.Course;
import lombok.Builder;

import java.time.Instant;

@Builder
public record AnnonceResponse(
        String id,
        String type,
        String titre,
        String message,
        Course course,
        Instant datePublication,
        Instant createdAt,
        Instant updatedAt
) {
}
