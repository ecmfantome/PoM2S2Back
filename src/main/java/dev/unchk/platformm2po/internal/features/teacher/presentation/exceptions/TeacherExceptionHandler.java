package dev.unchk.platformm2po.internal.features.teacher.presentation.exceptions;

import dev.unchk.platformm2po.internal.shared.presentation.entities.ErrorResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TeacherExceptionHandler {

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ErrorResponseApi> handleUserRoleException(TeacherNotFoundException ex) {
        ErrorResponseApi errorResponseApi = ErrorResponseApi.builder().error(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseApi);
    }

}
