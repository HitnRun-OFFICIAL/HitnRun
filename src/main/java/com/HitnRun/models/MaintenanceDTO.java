package com.HitnRun.models;

import java.sql.Date;

// This class represents a Data Transfer Object (DTO) for storing maintenance information.
public class MaintenanceDTO {
  // Fields to store information about maintenance records
  private int maintenanceID;
  private int vehicleID;
  private Date maintenanceDate;
  private String description;
  private double cost;

  // Default constructor
  public MaintenanceDTO() {
    // Default constructor
  }

  // Parameterized constructor
  public MaintenanceDTO(int vehicleID, Date maintenanceDate, String description, double cost) {
    // Initialize a new instance of MaintenanceDTO with provided values
    this.vehicleID = vehicleID;
    this.maintenanceDate = maintenanceDate;
    this.description = description;
    this.cost = cost;
  }

  // Getter and setter methods for the private fields.
  public int getMaintenanceID() {
    return this.maintenanceID;
  }

  public void setMaintenanceID(int maintenanceID) {
    this.maintenanceID = maintenanceID;
  }

  public int getVehicleID() {
    return this.vehicleID;
  }

  public void setVehicleID(int vehicleID) {
    this.vehicleID = vehicleID;
  }

  public Date getMaintenanceDate() {
    return this.maintenanceDate;
  }

  public void setMaintenanceDate(Date maintenanceDate) {
    this.maintenanceDate = maintenanceDate;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getCost() {
    return this.cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }
}
