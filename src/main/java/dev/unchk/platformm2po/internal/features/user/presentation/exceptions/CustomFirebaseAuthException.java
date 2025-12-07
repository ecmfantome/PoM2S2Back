package dev.unchk.platformm2po.internal.features.user.presentation.exceptions;

public class CustomFirebaseAuthException extends RuntimeException {
    public CustomFirebaseAuthException(String message) {
        super(message);
    }
}
