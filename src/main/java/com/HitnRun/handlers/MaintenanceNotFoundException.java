package com.HitnRun.handlers;

public class MaintenanceNotFoundException extends Exception {
  public MaintenanceNotFoundException(String message) {
    super(message);
  }

  public MaintenanceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
