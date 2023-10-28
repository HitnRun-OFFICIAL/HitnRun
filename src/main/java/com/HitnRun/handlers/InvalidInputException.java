package com.HitnRun.handlers;

// Define a custom exception class named 'InvalidInputException' that extends the built-in
// 'Exception' class.
public class InvalidInputException extends Exception {
  // Constructor for creating an instance of 'InvalidInputException' with a custom error message.
  public InvalidInputException(String message) {
    // Call the constructor of the parent 'Exception' class with the provided error message.
    super(message);
  }

  // Constructor for creating an instance of 'InvalidInputException' with a custom error message and
  // a cause (another exception).
  public InvalidInputException(String message, Throwable cause) {
    // Call the constructor of the parent 'Exception' class with the provided error message and the
    // cause of the exception.
    super(message, cause);
  }
}
