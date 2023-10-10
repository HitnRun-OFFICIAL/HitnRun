package com.HitnRun.handlers;

public class RentalNotFoundException extends Exception {
    public RentalNotFoundException(String message) {
        super(message);
    }

    public RentalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
