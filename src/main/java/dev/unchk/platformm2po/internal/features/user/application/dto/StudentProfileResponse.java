package dev.unchk.platformm2po.internal.features.user.application.dto;


import lombok.Builder;

@Builder

public record StudentProfileResponse(
        String studentId,
        String registrationNumber,
        String backToYearSchool
) implements UserProfileResponse {}

