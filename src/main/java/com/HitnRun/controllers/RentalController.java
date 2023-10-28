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

  // constructor to initializes the database connection and rental data access object.
  public RentalController() {
    this.connection = HSQLDBConnector.getConnection();
    rentalDAO = new RentalDAO(connection);
  }

  public void rent(RentalDTO rental) {
    try {
      rentalDAO.createRental(rental); //Add records
    } catch (DatabaseOperationException e) {
      e.printStackTrace();
    }
  }
}
