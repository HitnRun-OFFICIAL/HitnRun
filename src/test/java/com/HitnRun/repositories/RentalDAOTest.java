package com.HitnRun.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.RentalNotFoundException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.utils.HSQLDBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RentalDAOTest {
  private RentalDAO rentalDAO;
  private RentalDTO rental;
  private VehicleDAO vehicleDAO;
  private VehicleDTO vehicle;
  private CustomerDAO customerDAO;
  private CustomerDTO customer;

  @BeforeAll
  void setUp() {
    Connection connection = HSQLDBConnector.getTestConnection();// Get a test connection from the HSQLDBConnector

    try {
      vehicleDAO = new VehicleDAO(connection);
      vehicle = new VehicleDTO("test", "test", 1000, "test", "test", "test", 5, 69.0, "test");
      vehicleDAO.createVehicle(vehicle);
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }

    try {
      customerDAO = new CustomerDAO(connection);
      customer = new CustomerDTO("test", "test", "test", "test", "test", "test");
      customerDAO.createCustomer(customer);
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }

    rentalDAO = new RentalDAO(connection);

    // Create a test rental record to be used in various test methods
    rental = new RentalDTO(1, 1, new Date(0), new Date(0), 1000);
  }

  @AfterAll
  void tearDown() throws DatabaseOperationException {
    try (Connection connection = HSQLDBConnector.getTestConnection();
        Statement statement = connection.createStatement()) {
      statement.execute("DELETE FROM " + "rental");
      statement.execute("DELETE FROM " + "staff");
      statement.execute("DELETE FROM " + "vehicles");
      statement.execute("DELETE FROM " + "customers");
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while tear down", e);
    }
  }

  @Test
  void testCreateRental() {
    try {
      // Create a rental record
      rentalDAO.createRental(rental);

      // Retrieve the created rental record and assert its properties
      RentalDTO createdRental = rentalDAO.readRental(rental.getRentalID());
      assertNotNull(createdRental);
      assertEquals(rental.getCustomerID(), createdRental.getCustomerID());
      assertEquals(rental.getVehicleID(), createdRental.getVehicleID());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | RentalNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testDeleteRental() {
    try {
      // Create a rental record first
      rentalDAO.createRental(rental);

      // Delete the rental record
      rentalDAO.deleteRental(rental.getRentalID());

      // Try to read the deleted rental record, should result in RentalNotFoundException
      assertThrows(RentalNotFoundException.class, () -> rentalDAO.readRental(rental.getRentalID()));
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadRental() {
    try {
      // Create a rental record first
      rentalDAO.createRental(rental);

      // Read the rental record and assert its properties
      RentalDTO readRental = rentalDAO.readRental(rental.getRentalID());
      assertNotNull(readRental);
      assertEquals(rental.getCustomerID(), readRental.getCustomerID());
      assertEquals(rental.getVehicleID(), readRental.getVehicleID());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | RentalNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testUpdateRental() {
    try {
      // Create a rental record first
      rentalDAO.createRental(rental);

      // Modify some properties of the rental record
      rental.setRentalDate(new Date(2));
      rental.setRentalFee(10);

      // Update the rental record in the database
      rentalDAO.updateRental(rental);

      // Retrieve the updated rental record and assert its properties
      RentalDTO updatedRental = rentalDAO.readRental(rental.getRentalID());
      assertNotNull(updatedRental);
      assertEquals(rental.getRentalDate().toString(), updatedRental.getRentalDate().toString());
      assertEquals(rental.getRentalFee(), updatedRental.getRentalFee());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | RentalNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadAllRentalsForCustomer() {
    try {
      // Create rental records for a specific customer or ensure there are existing rental records
      // in the database

      // Read all rental records for the customer
      List<RentalDTO> rentalRecords = rentalDAO.readAllRentalsForCustomer(rental.getCustomerID());
      assertNotNull(rentalRecords);

      // Iterate through the rental records and make assertions
      for (RentalDTO rentalRecord : rentalRecords) {
        assertNotNull(rentalRecord);
        // Add assertions for each rental record's properties
      }
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }
}
