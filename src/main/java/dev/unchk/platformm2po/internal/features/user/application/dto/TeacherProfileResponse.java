package dev.unchk.platformm2po.internal.features.user.application.dto;

import lombok.Builder;

@Builder

public record TeacherProfileResponse(
        String teacherId,
        String registrationNumber,
        String speciality,
        String department
) implements UserProfileResponse {
}


