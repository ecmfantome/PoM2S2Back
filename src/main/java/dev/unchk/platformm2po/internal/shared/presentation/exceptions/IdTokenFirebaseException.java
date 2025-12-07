package dev.unchk.platformm2po.internal.shared.presentation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IdTokenFirebaseException extends RuntimeException {
    public IdTokenFirebaseException() {
    }
}

