package com.HitnRun.handlers;

public class StaffNotFoundException extends Exception {
    public StaffNotFoundException(String message) {
        super(message);
    }

    public StaffNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}