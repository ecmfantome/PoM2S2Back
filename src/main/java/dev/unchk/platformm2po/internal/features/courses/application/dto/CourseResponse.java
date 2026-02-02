package dev.unchk.platformm2po.internal.features.courses.application.dto;

import dev.unchk.platformm2po.internal.features.admin.domain.entities.Admin;
import dev.unchk.platformm2po.internal.features.module.domain.entities.Module_;
import dev.unchk.platformm2po.internal.features.teacher.domain.entities.Teacher;
import lombok.Builder;

import java.time.Instant;

@Builder
public record CourseResponse(
        String id,
        String titre,
        String semester,
        String description,
        int credit,
        Module_ module,
        Admin createdBy,
        Instant createdAt,
        Instant updatedAt
) {
}
