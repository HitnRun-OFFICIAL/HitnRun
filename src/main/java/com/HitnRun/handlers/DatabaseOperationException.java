package com.HitnRun.handlers;

// Define a custom exception class named DatabaseOperationException that extends the built-in
// Exception class.
public class DatabaseOperationException extends Exception {
  // Constructor that takes a custom error message as a parameter.
  public DatabaseOperationException(String message) {
    // Call the constructor of the parent (Exception) class with the provided error message.
    super(message);
  }

  // Constructor that takes a custom error message and a Throwable (exception) cause as parameters.
  public DatabaseOperationException(String message, Throwable cause) {
    // Call the constructor of the parent (Exception) class with the provided error message and
    // cause.
    super(message, cause);
  }
}
