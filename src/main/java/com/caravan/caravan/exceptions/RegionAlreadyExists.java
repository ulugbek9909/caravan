package com.caravan.caravan.exceptions;

public class RegionAlreadyExists extends RuntimeException{
    public RegionAlreadyExists(String message) {
        super(message);
    }
}
