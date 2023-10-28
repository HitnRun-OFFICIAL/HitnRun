package com.HitnRun.handlers;

// Custom Exception class for handling VehicleNotFoundException
public class VehicleNotFoundException extends Exception {
  // Constructor that accepts a message to describe the exception
  public VehicleNotFoundException(String message) {
    // Call the constructor of the parent class (Exception) with the provided message
    super(message);
  }

  // Constructor that accepts a message and a cause (another Throwable) to describe the exception
  // and its underlying cause
  public VehicleNotFoundException(String message, Throwable cause) {
    // Call the constructor of the parent class (Exception) with both the message and cause
    super(message, cause);
  }
}
