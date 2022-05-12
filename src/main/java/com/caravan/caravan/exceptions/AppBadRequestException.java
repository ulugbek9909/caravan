package com.caravan.caravan.exceptions;

public class AppBadRequestException extends RuntimeException {
    public AppBadRequestException(String message) {
        super(message);
    }
}
