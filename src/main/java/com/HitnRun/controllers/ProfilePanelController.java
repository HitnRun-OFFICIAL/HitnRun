package com.HitnRun.controllers;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.InvalidInputException;
import com.HitnRun.handlers.VehicleNotFoundException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.repositories.CustomerDAO;
import com.HitnRun.repositories.RentalDAO;
import com.HitnRun.repositories.VehicleDAO;
import com.HitnRun.utils.Authenticator;
import com.HitnRun.utils.HSQLDBConnector;
import com.HitnRun.validations.InputValidation;
import java.sql.Connection;
import java.util.List;

// class controller for the profile panel, handles its interactions
public class ProfilePanelController {
  private CustomerDAO customerDAO;
  private CustomerDTO customer;
  private List<RentalDTO> rentals;
  private RentalDAO rentalDAO;
  private VehicleDAO vehicleDAO;
  private VehicleDTO vehicle;
  private Connection connection;
  //Custructor to initialize the controller and database connections
  public ProfilePanelController() {
    this.connection = HSQLDBConnector.getConnection();
    rentalDAO = new RentalDAO(connection);
    vehicleDAO = new VehicleDAO(connection);
    customerDAO = new CustomerDAO(connection);
  }
  // Retrieve and return the customer's profile information
  public CustomerDTO getCustomer() {
    customer = Authenticator.getProfile();
    return customer;
  }
  // Get and return the list of rentals associated with the customer's profile
  public List<RentalDTO> getRentals() {
    try {
      rentals = rentalDAO.readAllRentalsForCustomer(Authenticator.getProfile().getCustomerID());
      return rentals;
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return null;
  }
  // Register a new customer profile in the system
  public void register(CustomerDTO profile) throws InvalidInputException {
    InputValidation.validateProfile(profile);
    try {
      customerDAO.createCustomer(profile);
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }
  // Get and return information about a specific vehicle
  public VehicleDTO getVehicle(int vehicleId) {
    try {
      vehicle = vehicleDAO.readVehicle(vehicleId);
      return vehicle;
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    } catch (VehicleNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }
  // Update an existing customer profile
  public void updateProfile(CustomerDTO profile) throws InvalidInputException {
    InputValidation.validateProfile(profile);
    try {
      customerDAO.updateCustomer(profile);
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }
  // Delete a customer profile and associated rentals
  public void deleteProfile(int profileId) {
    try {
      rentalDAO.deleteRentalWithCustomerID(profileId);
      customerDAO.deleteCustomer(profileId);
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }
}
