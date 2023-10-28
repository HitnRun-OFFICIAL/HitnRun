package com.HitnRun.handlers;

// Define a custom exception class called StaffNotFoundException that extends the built-in Exception
// class.
public class StaffNotFoundException extends Exception {
  // Constructor that accepts a custom error message as a parameter.
  public StaffNotFoundException(String message) {
    // Call the constructor of the parent Exception class and pass the custom message to it.
    super(message);
  }

  // Constructor that accepts a custom error message and a Throwable cause as parameters.
  public StaffNotFoundException(String message, Throwable cause) {
    // Call the constructor of the parent Exception class and pass both the message and cause to it.
    super(message, cause);
  }
}
