package com.HitnRun.handlers;

// Create a custom exception class named RentalNotFoundException that extends the built-in Exception
// class
public class RentalNotFoundException extends Exception {
  // Constructor that takes a custom error message as input
  public RentalNotFoundException(String message) {
    // Call the constructor of the parent Exception class with the provided message
    super(message);
  }

  // Constructor that takes a custom error message and an additional Throwable cause as input
  public RentalNotFoundException(String message, Throwable cause) {
    // Call the constructor of the parent Exception class with the provided message and cause
    super(message, cause);
  }
}
