package com.HitnRun.utils;

import com.HitnRun.handlers.CustomerNotFoundException;
import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.repositories.CustomerDAO;

public class Authenticator {
  // Initialize a static CustomerDTO object to store the user's profile information.
  private static CustomerDTO profile = new CustomerDTO(null, null, null, null, null, null);

  // Authenticate a customer based on provided username and password.
  public static boolean AuthenticateCustomer(String username, String password)
      throws DatabaseOperationException, CustomerNotFoundException {
    // Retrieve the customer's profile from the database using the CustomerDAO.
    profile = new CustomerDAO(HSQLDBConnector.getConnection()).readCustomerByUsername(username);
    // Check if the retrieved password matches the provided password.
    if (profile.getPassword().equals(password)) {
      // If the passwords match, update the current profile and return true to indicate a successful
      // login.
      Authenticator.setProfile(profile);
      return true;
    }
    // If passwords do not match, return false to indicate authentication failure.
    return false;
  }

  // Log out a customer by resetting the profile information.
  public static void logout() {
    profile = new CustomerDTO(null, null, null, null, null, null);
  }

  // Get the current customer profile.
  public static CustomerDTO getProfile() {
    return profile;
  }

  // Set the customer profile to a provided CustomerDTO.
  public static void setProfile(CustomerDTO profile) {
    Authenticator.profile = profile;
  }
}
