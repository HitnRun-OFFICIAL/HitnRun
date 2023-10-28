package com.HitnRun.handlers;

// Define a custom exception class called DatabaseException that extends the built-in
// RuntimeException class.
public class DatabaseException extends RuntimeException {
  // Constructor that takes a message as a parameter and calls the constructor of the parent class
  // (RuntimeException) with the message.
  public DatabaseException(String message) {
    super(message);
  }

  // Constructor that takes a message and a cause (another exception that triggered this one) as
  // parameters.
  // It calls the constructor of the parent class (RuntimeException) with the message and cause.
  public DatabaseException(String message, Throwable cause) {
    super(message, cause);
  }
}
