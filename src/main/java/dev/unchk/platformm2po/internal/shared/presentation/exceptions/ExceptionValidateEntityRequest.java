package dev.unchk.platformm2po.internal.shared.presentation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionValidateEntityRequest extends RuntimeException {
    public ExceptionValidateEntityRequest(String message) {
        super(message);
    }
}


