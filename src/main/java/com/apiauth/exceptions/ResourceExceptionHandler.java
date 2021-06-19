package com.apiauth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

import static com.apiauth.utils.MessageExceptions.*;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler({BadRequestException.class, EmailInvalidException.class})
    public ResponseEntity<StandardError> badRequest(RuntimeException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.BAD_REQUEST.name())
                .messages(Collections.singletonList(e.getMessage()))
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<StandardError> notFound(NoDataFoundException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.NOT_FOUND.name())
                .messages(Collections.singletonList(e.getMessage()))
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> conflict(DataIntegrityException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.CONFLICT.name())
                .messages(Collections.singletonList(e.getMessage()))
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<StandardError> queryParam(MissingServletRequestParameterException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.BAD_REQUEST.name())
                .messages(Collections.singletonList(QUERY_PARAM_WITHOUT))
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> pathVariable(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.BAD_REQUEST.name())
                .messages(Collections.singletonList(PATH_VARIABLE_WITHOUT))
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler(UserNotPermissionException.class)
    public ResponseEntity<StandardError> userNotPermission(UserNotPermissionException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.FORBIDDEN.name())
                .messages(Collections.singletonList(USER_LOGGED_NOT_PERMISSION_FOR_THIS_CREATION))
                .path(request.getRequestURI())
                .build()
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<StandardError> userNotPermission(AccessDeniedException e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(StandardError
                .builder()
                .timestamp(System.currentTimeMillis())
                .erro(HttpStatus.FORBIDDEN.name())
                .messages(Collections.singletonList(USER_LOGGED_NOT_PERMISSION_FOR_THIS_CREATION))
                .path(request.getRequestURI())
                .build()
        );
    }
}
