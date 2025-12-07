package dev.unchk.platformm2po.internal.features.user.presentation.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
