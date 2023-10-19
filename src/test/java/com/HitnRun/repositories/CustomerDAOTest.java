package com.HitnRun.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.handlers.CustomerNotFoundException;
import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.CustomerDTO;
import com.HitnRun.utils.MSSQLJDBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerDAOTest {
  private CustomerDAO customerDAO;
  private CustomerDTO customer;

  @BeforeAll
  void setUp() {
    customerDAO = new CustomerDAO(MSSQLJDBConnector.getConnection("hitnruntest"));

    // Create a test customer to be used in various test methods
    customer = new CustomerDTO("test", "test", "test@test.test", "+94700000000", "user", "pass");
  }

  @AfterAll
  void tearDown() throws DatabaseOperationException {
    try (Connection connection = MSSQLJDBConnector.getConnection("hitnruntest");
        Statement statement = connection.createStatement()) {
      statement.execute("DELETE FROM " + "customers");
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while tear down", e);
    }
  }

  @Test
  void testCreateCustomer() {
    try {
      // Create a customer
      customerDAO.createCustomer(customer);

      // Retrieve the created customer and assert its properties
      CustomerDTO createdCustomer = customerDAO.readCustomer(customer.getCustomerID());
      assertNotNull(createdCustomer);
      assertEquals(customer.getFirstName(), createdCustomer.getFirstName());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | CustomerNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadCustomer() {
    try {
      // Create a customer first
      customerDAO.createCustomer(customer);

      // Read the customer and assert its properties
      CustomerDTO readCustomer = customerDAO.readCustomer(customer.getCustomerID());
      assertNotNull(readCustomer);
      assertEquals(customer.getFirstName(), readCustomer.getFirstName());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | CustomerNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadAllCustomers() {
    try {
      // Create multiple customers or ensure there are existing customers in the
      // database

      // Read all customers
      Iterable<CustomerDTO> customers = customerDAO.readAllCustomers();
      assertNotNull(customers);

      // Iterate through the customers and make assertions
      for (CustomerDTO customer : customers) {
        assertNotNull(customer);
        // Add assertions for each customer's properties
      }
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testUpdateCustomer() {
    try {
      // Create a customer first
      customerDAO.createCustomer(customer);

      // Modify some properties of the customer
      customer.setFirstName("UpdatedFirstName");
      customer.setEmail("updated@test.test");

      // Update the customer in the database
      customerDAO.updateCustomer(customer);

      // Retrieve the updated customer and assert its properties
      CustomerDTO updatedCustomer = customerDAO.readCustomer(customer.getCustomerID());
      assertNotNull(updatedCustomer);
      assertEquals(customer.getFirstName(), updatedCustomer.getFirstName());
      assertEquals(customer.getEmail(), updatedCustomer.getEmail());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | CustomerNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testDeleteCustomer() {
    try {
      // Create a customer first
      customerDAO.createCustomer(customer);

      // Delete the customer
      customerDAO.deleteCustomer(customer.getCustomerID());

      // Try to read the deleted customer, should result in CustomerNotFoundException
      assertThrows(
          CustomerNotFoundException.class,
          () -> customerDAO.readCustomer(customer.getCustomerID()));
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }
}
