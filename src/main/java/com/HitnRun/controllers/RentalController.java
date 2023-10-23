package com.HitnRun.controllers;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.repositories.RentalDAO;
import com.HitnRun.utils.HSQLDBConnector;
import java.sql.Connection;

public class RentalController {
  private RentalDAO rentalDAO;
  private RentalDTO rental;
  private Connection connection;

  public RentalController() {
    this.connection = HSQLDBConnector.getConnection();
    rentalDAO = new RentalDAO(connection);
  }

  public void rent(RentalDTO rental) {
    try {
      rentalDAO.createRental(rental);
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }
}
