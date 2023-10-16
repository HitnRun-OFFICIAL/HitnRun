package com.HitnRun.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.PaymentNotFoundException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.models.PaymentsDTO;
import com.HitnRun.models.RentalDTO;
import com.HitnRun.models.StaffDTO;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.utils.MSSQLJDBConnector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PaymentsDAOTest {
  private PaymentsDAO paymentsDAO;
  private PaymentsDTO payment;
  private RentalDAO rentalDAO;
  private RentalDTO rental;
  private StaffDAO staffDAO;
  private StaffDTO staff;
  private VehicleDAO vehicleDAO;
  private VehicleDTO vehicle;
  private CustomerDAO customerDAO;
  private CustomerDTO customer;

  @BeforeAll
  void setUp() {

    Connection connection = MSSQLJDBConnector.getConnection("hitnruntest");

    try {

      staffDAO = new StaffDAO(connection);
      staff = new StaffDTO("test", "test", "test", "test", "test", "test", "test");
      staffDAO.createStaff(staff);
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }

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

    try {
      rentalDAO = new RentalDAO(connection);
      rental = new RentalDTO(1, 1, 1, new Date(0), new Date(0), 1000);
      rentalDAO.createRental(rental);

    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }

    paymentsDAO = new PaymentsDAO(connection);

    // Create a test payment record to be used in various test methods
    payment = new PaymentsDTO(1, new Date(0), 1000);
  }

  @AfterAll
  void tearDown() throws DatabaseOperationException {
    try (Connection connection = MSSQLJDBConnector.getConnection("hitnruntest");
        Statement statement = connection.createStatement()) {
      statement.execute("DELETE FROM " + "payments");
      statement.execute("DELETE FROM " + "rental");
      statement.execute("DELETE FROM " + "staff");
      statement.execute("DELETE FROM " + "vehicles");
      statement.execute("DELETE FROM " + "customers");
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while tear down", e);
    }
  }

  @Test
  void testCreatePayment() {
    try {
      // Create a payment record
      paymentsDAO.createPayment(payment);

      // Retrieve the created payment record and assert its properties
      PaymentsDTO createdPayment = paymentsDAO.readPayment(payment.getPaymentID());
      assertNotNull(createdPayment);
      assertEquals(payment.getRentalID(), createdPayment.getRentalID());
      assertEquals(payment.getAmount(), createdPayment.getAmount());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | PaymentNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testDeletePayment() {
    try {
      // Create a payment record first
      paymentsDAO.createPayment(payment);

      // Delete the payment record
      paymentsDAO.deletePayment(payment.getPaymentID());

      // Try to read the deleted payment record, should result in PaymentNotFoundException
      assertThrows(
          PaymentNotFoundException.class, () -> paymentsDAO.readPayment(payment.getPaymentID()));
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadPayment() {
    try {
      // Create a payment record first
      paymentsDAO.createPayment(payment);

      // Read the payment record and assert its properties
      PaymentsDTO readPayment = paymentsDAO.readPayment(payment.getPaymentID());
      assertNotNull(readPayment);
      assertEquals(payment.getRentalID(), readPayment.getRentalID());
      assertEquals(payment.getAmount(), readPayment.getAmount());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | PaymentNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testUpdatePayment() {
    try {
      // Create a payment record first
      paymentsDAO.createPayment(payment);

      // Modify some properties of the payment record
      payment.setAmount(payment.getAmount() * 2);

      // Update the payment record in the database
      paymentsDAO.updatePayment(payment);

      // Retrieve the updated payment record and assert its properties
      PaymentsDTO updatedPayment = paymentsDAO.readPayment(payment.getPaymentID());
      assertNotNull(updatedPayment);
      assertEquals(payment.getAmount(), updatedPayment.getAmount());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | PaymentNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadAllPaymentsForRental() {
    try {
      // Create payment records for a specific rental or ensure there are existing payment records
      // in the database

      // Read all payment records for the rental
      List<PaymentsDTO> paymentRecords =
          paymentsDAO.readAllPaymentsForRental(payment.getRentalID());
      assertNotNull(paymentRecords);

      // Iterate through the payment records and make assertions
      for (PaymentsDTO paymentRecord : paymentRecords) {
        assertNotNull(paymentRecord);
        // Add assertions for each payment record's properties
      }
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }
}
