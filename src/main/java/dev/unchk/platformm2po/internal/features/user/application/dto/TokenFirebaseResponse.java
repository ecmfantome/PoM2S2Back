package dev.unchk.platformm2po.internal.features.user.application.dto;

public record TokenFirebaseResponse(String kind, String localId, String displayName, String idToken, Boolean registered,
                    String refreshToken, String email, String expiresIn) {
}
