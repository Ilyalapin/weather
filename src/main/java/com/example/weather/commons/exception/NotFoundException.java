package com.example.weather.commons.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mesage) {
        super(mesage);
    }
}
