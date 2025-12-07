package dev.unchk.platformm2po.internal.features.user.application.dto;


import lombok.Builder;

@Builder
public record UserLoginResponse(
        String userId,
        String name,
        String lastName,
        String email,
        String phone,
        String role,
        Boolean isActive,
        TokenFirebaseResponse token,
        UserProfileResponse profile
) {
}

