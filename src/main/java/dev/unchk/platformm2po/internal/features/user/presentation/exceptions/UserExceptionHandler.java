package dev.unchk.platformm2po.internal.features.user.presentation.exceptions;

import dev.unchk.platformm2po.internal.shared.presentation.entities.ErrorResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static dev.unchk.platformm2po.internal.features.user.presentation.custom_labels.CustomLabels.getCustomLabels;
import static dev.unchk.platformm2po.internal.features.user.presentation.custom_labels.CustomLabels.userLoginError;

@RestControllerAdvice
public class UserExceptionHandler {

    //  l'exception UserRoleException pour le cas de mes roles
    @ExceptionHandler(UserRoleException.class)
    public ResponseEntity<ErrorResponseApi> handleUserRoleException(UserRoleException ex) {
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseApi);
    }

    /// Gère les not_found_request erreurs Client
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseApi> clientErrorNotFoundException(UserNotFoundException e) {
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseApi);
    }

    // Gère les forbidden_request erreurs Client
    @ExceptionHandler(UserForbiddenException.class)
    public ResponseEntity<ErrorResponseApi> clientErrorForbiddenException(UserForbiddenException e) {
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponseApi);
    }

    // Gère les bad_request erreurs Client
    @ExceptionHandler(UserBadRequestException.class)
    public ResponseEntity<ErrorResponseApi> clientErrorBadRequestException(UserBadRequestException e) {
        String message = getCustomLabels("Fr", userLoginError);
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(e.getMessage()).message(message).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseApi);
    }

    // Gère les bad_request erreurs Client
    @ExceptionHandler(CustomFirebaseAuthException.class)
    public ResponseEntity<ErrorResponseApi> clientErrorBadRequestException(CustomFirebaseAuthException e) {
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(e.getMessage()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseApi);
    }

}
