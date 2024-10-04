package com.example.weather.commons.exception;

public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String mesage) {
        super(mesage);
    }
}
