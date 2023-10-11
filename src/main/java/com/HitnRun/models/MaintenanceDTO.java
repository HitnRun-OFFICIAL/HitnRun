package com.HitnRun.models;

import java.sql.Date;

public class MaintenanceDTO {

  private int maintenanceID;
  private int vehicleID;
  private Date maintenanceDate;
  private String description;
  private double cost;

  public MaintenanceDTO() {
    // Default constructor
  }

  public MaintenanceDTO(int vehicleID, Date maintenanceDate, String description, double cost) {
    this.vehicleID = vehicleID;
    this.maintenanceDate = maintenanceDate;
    this.description = description;
    this.cost = cost;
  }

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
