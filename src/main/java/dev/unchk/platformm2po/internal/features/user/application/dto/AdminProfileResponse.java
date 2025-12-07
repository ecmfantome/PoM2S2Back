package dev.unchk.platformm2po.internal.features.user.application.dto;

import lombok.Builder;

@Builder
public record AdminProfileResponse(
        String adminId,
        String role
) implements UserProfileResponse {}
