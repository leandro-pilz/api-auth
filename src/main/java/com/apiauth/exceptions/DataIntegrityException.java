package com.apiauth.exceptions;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String message) {
        super(message);
    }
}
