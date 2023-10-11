package com.HitnRun.models;

import java.sql.Date;

public class RentalDTO {

    private int rentalID;
    private int customerID;
    private int vehicleID;
    private int staffID;
    private Date rentalDate;
    private Date returnDate;
    private double rentalFee;

    public RentalDTO() {
        // Default constructor
    }

    public RentalDTO(
            int customerID,
            int vehicleID,
            int staffID,
            Date rentalDate,
            Date returnDate,
            double rentalFee) {
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.staffID = staffID;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalFee = rentalFee;
    }

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

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
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
