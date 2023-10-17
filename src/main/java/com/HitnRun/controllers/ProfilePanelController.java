package com.HitnRun.controllers;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.VehicleNotFoundException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.repositories.CustomerDAO;
import com.HitnRun.repositories.RentalDAO;
import com.HitnRun.repositories.VehicleDAO;
import com.HitnRun.utils.Authenticator;
import com.HitnRun.utils.MSSQLJDBConnector;
import java.sql.Connection;
import java.util.List;

public class ProfilePanelController {
  private CustomerDAO customerDAO;
  private CustomerDTO customer;
  private List<RentalDTO> rentals;
  private RentalDAO rentalDAO;
  private VehicleDAO vehicleDAO;
  private VehicleDTO vehicle;
  private Connection connection;

  public ProfilePanelController() {
    this.connection = MSSQLJDBConnector.getConnection("hitnrun");
    rentalDAO = new RentalDAO(connection);
    vehicleDAO = new VehicleDAO(connection);
    customerDAO = new CustomerDAO(connection);
  }

  public CustomerDTO getCustomer() {
    customer = Authenticator.getProfile();
    return customer;
  }

  public List<RentalDTO> getRentals() {
    try {
      rentals = rentalDAO.readAllRentalsForCustomer(Authenticator.getProfile().getCustomerID());
      return rentals;
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
    return null;
  }

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

  public void updateProfile(CustomerDTO profile) {
    try {
      customerDAO.updateCustomer(profile);
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }

  public void deleteProfile(int profileId) {
    try {
      customerDAO.deleteCustomer(profileId);
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }
}
