package com.HitnRun.handlers;

public class VehicleNotFoundException extends Exception {
  public VehicleNotFoundException(String message) {
    super(message);
  }

  public VehicleNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
