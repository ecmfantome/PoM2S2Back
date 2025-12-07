package dev.unchk.platformm2po.internal.features.user.presentation.exceptions;

public class UserForbiddenException extends RuntimeException {
    public UserForbiddenException(String message) {
        super(message);
    }
}
