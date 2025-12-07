package dev.unchk.platformm2po.internal.shared.presentation.exceptions;

import dev.unchk.platformm2po.internal.shared.presentation.entities.ErrorResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SharedExceptionHandler {
    private static final String ERROR_RESPONSE_SERVER_FR = "une erreur est survenue merci de réessayer plus tard ! ";
    private static final String ERROR_RESPONSE_SERVER_EN = "An error has occurred, please try again later!";

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorResponseApi> handleValidationErrors(WebExchangeBindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(errors.toString()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseApi);

    }


    //
    @ExceptionHandler(IdTokenFirebaseException.class)
    public ResponseEntity<ErrorResponseApi> handleFirebaseAuthException(IdTokenFirebaseException ex) {
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error("Teste  == ").build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseApi);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponseApi> handleValidationErrors(RuntimeException ex) {
        System.err.println("Erreur Server == " + ex.toString());
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(ERROR_RESPONSE_SERVER_FR).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseApi);

    }
}
