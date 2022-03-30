package com.example.currencyratesapplication.exception;

public class RatesNotFoundException extends RuntimeException {
    public RatesNotFoundException(String message) {
        super(message);
    }
}
