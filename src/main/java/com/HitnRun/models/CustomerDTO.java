package com.HitnRun.models;

// This class represents a Data Transfer Object (DTO) for storing customer information.
public class CustomerDTO {

  private int customerID;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String username;
  private String password;

  // Default constructor for CustomerDTO.
  public CustomerDTO() {
    // default constructor
  }

  // Parameterized constructor for CustomerDTO.
  public CustomerDTO(
      String firstName,
      String lastName,
      String email,
      String phone,
      String username,
      String password) {
    // Constructor that initializes the object with customer information.
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.username = username;
    this.password = password;
  }

  // Getter and setter methods for the private fields.
  public int getCustomerID() {
    return this.customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
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

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
