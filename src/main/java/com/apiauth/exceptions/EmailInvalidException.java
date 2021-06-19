package com.apiauth.exceptions;

public class EmailInvalidException extends RuntimeException {
    public EmailInvalidException(String message) {
        super(message);
    }
}
