package dev.unchk.platformm2po.internal.features.user.presentation.exceptions;

public class UserBadRequestException extends RuntimeException {
    public UserBadRequestException(String message) {
        super(message);
    }
}
