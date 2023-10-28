package com.HitnRun.models;

// This class represents a Data Transfer Object (DTO) for storing staff information.
public class StaffDTO {

  private int staffID;
  private String firstName;
  private String lastName;
  private String position;
  private String email;
  private String phone;
  private String userName;
  private String password;

  // Default constructor for StaffDTO.
  public StaffDTO() {
    // default constructor
  }

  // Parameterized constructor for StaffDTO.
  public StaffDTO(
      String firstName,
      String lastName,
      String position,
      String email,
      String phone,
      String userName,
      String password) {
    // Initialize a StaffDTO object with provided values.
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.email = email;
    this.phone = phone;
    this.userName = userName;
    this.password = password;
  }

  // Getter and setter methods for the private fields.
  public int getStaffID() {
    return this.staffID;
  }

  public void setStaffID(int staffID) {
    this.staffID = staffID;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
