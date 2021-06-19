package com.apiauth.exceptions;

public class UserNotPermissionException extends RuntimeException {
    public UserNotPermissionException(String message) {
        super(message);
    }
}
