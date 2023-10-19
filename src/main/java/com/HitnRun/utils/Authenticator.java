package com.HitnRun.utils;

import com.HitnRun.handlers.CustomerNotFoundException;
import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.repositories.CustomerDAO;

public class Authenticator {
  private static CustomerDTO profile = new CustomerDTO(null, null, null, null, null, null);

  public static boolean AuthenticateCustomer(String username, String password)
      throws DatabaseOperationException, CustomerNotFoundException {
    profile =
        new CustomerDAO(MSSQLJDBConnector.getConnection("hitnrun"))
            .readCustomerByUsername(username);
    if (profile.getPassword().equals(password)) {
      Authenticator.setProfile(profile);
      return true;
    }
    return false;
  }

  public static void logout() {
    profile = new CustomerDTO(null, null, null, null, null, null);
  }

  public static CustomerDTO getProfile() {
    return profile;
  }

  public static void setProfile(CustomerDTO profile) {
    Authenticator.profile = profile;
  }
}
