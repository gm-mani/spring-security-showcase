package com.mani.securebank.exceptions;

public class RefreshTokenReuseException extends RuntimeException {
    public RefreshTokenReuseException(String message) {
        super(message);
    }
}
