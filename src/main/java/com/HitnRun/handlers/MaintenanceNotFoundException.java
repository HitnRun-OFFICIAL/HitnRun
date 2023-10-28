package com.HitnRun.handlers;

// Create a custom exception class named MaintenanceNotFoundException that extends the built-in
// Exception class.
public class MaintenanceNotFoundException extends Exception {
  // Constructor for creating an instance of MaintenanceNotFoundException with a custom error
  // message.
  public MaintenanceNotFoundException(String message) {
    super(message); // Call the constructor of the parent class (Exception) with the given message.
  }

  // Constructor for creating an instance of MaintenanceNotFoundException with a custom error
  // message and a Throwable (exception) that caused it.
  public MaintenanceNotFoundException(String message, Throwable cause) {
    super(
        message,
        cause); // Call the constructor of the parent class (Exception) with the given message and
    // cause.
  }
}
