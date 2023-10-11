package com.HitnRun.handlers;

public class PaymentNotFoundException extends Exception {
  public PaymentNotFoundException(String message) {
    super(message);
  }

  public PaymentNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
