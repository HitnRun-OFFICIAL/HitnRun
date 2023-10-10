package com.HitnRun.models;

import java.sql.Date;

public class RentalDTO {

    private int RentalID;
    private int customerID;
    private int vehicleID;
    private int staffID;
    private Date RentalDate;
    private Date ReturnDate;
    private double RentalFee;

    public RentalDTO() {
        // Default constructor
    }

    public RentalDTO(int rentalID, int customerID, int vehicleID, int staffID,
            Date rentalDate, Date returnDate, double rentalFee) {
        RentalID = rentalID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.staffID = staffID;
        RentalDate = rentalDate;
        ReturnDate = returnDate;
        RentalFee = rentalFee;
    }

    public int getRentalID() {
        return RentalID;
    }

    public void setRentalID(int rentalID) {
        RentalID = rentalID;
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
        return RentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        RentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        ReturnDate = returnDate;
    }

    public double getRentalFee() {
        return RentalFee;
    }

    public void setRentalFee(double rentalFee) {
        RentalFee = rentalFee;
    }

}
