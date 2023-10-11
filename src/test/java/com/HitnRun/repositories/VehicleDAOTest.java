package com.HitnRun.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.VehicleNotFoundException;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.utils.MSSQLJDBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VehicleDAOTest {
  private VehicleDAO vehicleDAO;
  private VehicleDTO vehicle;

  @BeforeAll
  void setUp() {
    vehicleDAO = new VehicleDAO(MSSQLJDBConnector.getConnection("hitnruntest"));

    // Create a test vehicle to be used in various test methods
    vehicle = new VehicleDTO("test", "test", 1000, "test", "test", "test", 5, "path");
  }

  @AfterAll
  void tearDown() throws DatabaseOperationException {
    try (Connection connection = MSSQLJDBConnector.getConnection("hitnruntest");
        Statement statement = connection.createStatement()) {
      statement.execute("DELETE FROM " + "vehicles");
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while tear down", e);
    }
  }

  @Test
  void testCreateVehicle() {
    try {
      // Create a vehicle
      vehicleDAO.createVehicle(vehicle);

      // Retrieve the created vehicle and assert its properties
      VehicleDTO createdVehicle = vehicleDAO.readVehicle(vehicle.getVehicleID());
      assertNotNull(createdVehicle);
      assertEquals(vehicle.getMake(), createdVehicle.getMake());
      assertEquals(vehicle.getModel(), createdVehicle.getModel());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | VehicleNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testDeleteVehicle() {
    try {
      // Create a vehicle first
      vehicleDAO.createVehicle(vehicle);

      // Delete the vehicle
      vehicleDAO.deleteVehicle(vehicle.getVehicleID());

      // Try to read the deleted vehicle, should result in VehicleNotFoundException
      assertThrows(
          VehicleNotFoundException.class, () -> vehicleDAO.readVehicle(vehicle.getVehicleID()));
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadVehicle() {
    try {
      // Create a vehicle first
      vehicleDAO.createVehicle(vehicle);

      // Read the vehicle and assert its properties
      VehicleDTO readVehicle = vehicleDAO.readVehicle(vehicle.getVehicleID());
      assertNotNull(readVehicle);
      assertEquals(vehicle.getMake(), readVehicle.getMake());
      assertEquals(vehicle.getModel(), readVehicle.getModel());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | VehicleNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testUpdateVehicle() {
    try {
      // Create a vehicle first
      vehicleDAO.createVehicle(vehicle);

      // Modify some properties of the vehicle
      vehicle.setMake("UpdatedMake");
      vehicle.setModel("UpdatedModel");

      // Update the vehicle in the database
      vehicleDAO.updateVehicle(vehicle);

      // Retrieve the updated vehicle and assert its properties
      VehicleDTO updatedVehicle = vehicleDAO.readVehicle(vehicle.getVehicleID());
      assertNotNull(updatedVehicle);
      assertEquals(vehicle.getMake(), updatedVehicle.getMake());
      assertEquals(vehicle.getModel(), updatedVehicle.getModel());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | VehicleNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadAllVehicles() {
    try {
      // Create vehicles or ensure there are existing vehicles in the database

      // Read all vehicles
      List<VehicleDTO> vehicles = vehicleDAO.readAllVehicles();
      assertNotNull(vehicles);

      // Iterate through the vehicles and make assertions
      for (VehicleDTO vehicleRecord : vehicles) {
        assertNotNull(vehicleRecord);
        // Add assertions for each vehicle record's properties
      }
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }
}
