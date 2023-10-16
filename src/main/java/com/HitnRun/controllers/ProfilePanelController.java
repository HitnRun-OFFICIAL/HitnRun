package com.HitnRun.controllers;

import com.HitnRun.models.CustomerDTO;
import com.HitnRun.utils.Authenticator;

public class ProfilePanelController {
  private CustomerDTO customer;

  public ProfilePanelController() {}

  public CustomerDTO getCustomer() {
    customer = Authenticator.getProfile();
    return customer;
  }
}
