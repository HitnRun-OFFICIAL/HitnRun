package com.HitnRun.models;

public class VehicleDTO {

  private int vehicleID;
  private String make;
  private String model;
  private int year;
  private String licensePlate;
  private String description;
  private String color;
  private double rating;
  private double rent;
  private String imagePath;

  public VehicleDTO() {
    // Default constructor
  }

  // Parameterized constructor
  public VehicleDTO(
      String make,
      String model,
      int year,
      String licensePlate,
      String description,
      String color,
      double rating,
      double rent,
      String imagePath) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.licensePlate = licensePlate;
    this.description = description;
    this.color = color;
    this.rating = rating;
    this.rent = rent;
    this.imagePath = imagePath;
  }

  // Getters and setters
  public int getVehicleID() {
    return this.vehicleID;
  }

  public void setVehicleID(int vehicleID) {
    this.vehicleID = vehicleID;
  }

  public String getMake() {
    return this.make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getLicensePlate() {
    return this.licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getRating() {
    return this.rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public double getRent() {
    return this.rent;
  }

  public void setRent(double rent) {
    this.rent = rent;
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }
}
