package com.caravan.caravan.exceptions;

public class TokenNotValidException extends RuntimeException{
    public TokenNotValidException(String message) {
        super(message);
    }
}
