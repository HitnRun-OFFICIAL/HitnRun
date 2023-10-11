package com.HitnRun.models;

import java.sql.Date;

public class PaymentsDTO {

  private int PaymentID;
  private int rentalID;
  private Date PaymentDate;
  private double Amount;

  public PaymentsDTO() {
    // Default constructor
  }

  public PaymentsDTO(int rentalID, Date paymentDate, double amount) {
    this.rentalID = rentalID;
    PaymentDate = paymentDate;
    Amount = amount;
  }

  public int getPaymentID() {
    return PaymentID;
  }

  public void setPaymentID(int paymentID) {
    PaymentID = paymentID;
  }

  public int getRentalID() {
    return rentalID;
  }

  public void setRentalID(int rentalID) {
    this.rentalID = rentalID;
  }

  public Date getPaymentDate() {
    return PaymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    PaymentDate = paymentDate;
  }

  public double getAmount() {
    return Amount;
  }

  public void setAmount(double amount) {
    Amount = amount;
  }
}
