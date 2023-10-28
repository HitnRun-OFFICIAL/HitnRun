package com.HitnRun.models;

import java.sql.Date;

// This class represents a Data Transfer Object (DTO) for storing rental information.
public class RentalDTO {
  // Fields to represent rental information
  private int rentalID;
  private int customerID;
  private int vehicleID;
  private Date rentalDate;
  private Date returnDate;
  private double rentalFee;

  // Default constructor for RentalDTO
  public RentalDTO() {
    // Default constructor
  }

  // Parameterized constructor for RentalDTO
  public RentalDTO(
      int customerID, int vehicleID, Date rentalDate, Date returnDate, double rentalFee) {
    // Initialize the RentalDTO with provided values.
    this.customerID = customerID;
    this.vehicleID = vehicleID;
    this.rentalDate = rentalDate;
    this.returnDate = returnDate;
    this.rentalFee = rentalFee;
  }

  // Getter and setter methods for the private fields.
  public int getRentalID() {
    return rentalID;
  }

  public void setRentalID(int rentalID) {
    this.rentalID = rentalID;
  }

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public int getVehicleID() {
    return vehicleID;
  }

  public void setVehicleID(int vehicleID) {
    this.vehicleID = vehicleID;
  }

  public Date getRentalDate() {
    return rentalDate;
  }

  public void setRentalDate(Date rentalDate) {
    this.rentalDate = rentalDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }

  public double getRentalFee() {
    return rentalFee;
  }

  public void setRentalFee(double rentalFee) {
    this.rentalFee = rentalFee;
  }
}
