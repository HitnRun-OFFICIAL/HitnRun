package com.HitnRun.handlers;

// Dions comments
// Define a custom exception class called "CustomerNotFoundException" that extends the built-in
// "Exception" class.
public class CustomerNotFoundException extends Exception {
  // Constructor for creating an instance of the exception with a custom error message.
  public CustomerNotFoundException(String message) {
    // Call the constructor of the parent class "Exception" and pass the provided error message.
    super(message);
  }

  // Constructor for creating an instance of the exception with a custom error message and a cause
  // (another exception).
  public CustomerNotFoundException(String message, Throwable cause) {
    // Call the constructor of the parent class "Exception" and pass the provided error message and
    // the cause exception.
    super(message, cause);
  }
}
