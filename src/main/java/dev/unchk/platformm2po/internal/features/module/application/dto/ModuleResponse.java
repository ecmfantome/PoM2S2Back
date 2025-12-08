package dev.unchk.platformm2po.internal.features.module.application.dto;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import lombok.Builder;

import java.time.Instant;

@Builder
public record ModuleResponse(
        String id,
        String name,
        String semester,
        String code,
        Teacher responsible,
        Admin createdBy,
        Instant createdAt,
        Instant updatedAt
) {
}
