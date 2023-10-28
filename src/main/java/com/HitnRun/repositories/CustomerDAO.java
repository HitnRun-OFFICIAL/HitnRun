package com.HitnRun.repositories;

import com.HitnRun.handlers.CustomerNotFoundException;
import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.CustomerDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
  private Connection connection;

  // Constructor to initialize the DAO with a database connection
  public CustomerDAO(Connection connection) {
    this.connection = connection;
  }

  // Generate a new customer ID for inserting a new customer into the database
  public int generateCustomerID() throws DatabaseOperationException {
    String sql = "SELECT MAX(CustomerID) FROM Customers";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt(1) + 1;
      } else {
        return 1;
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error in generating new customerID", e);
    }
  }

  // Create a new customer in the database
  public void createCustomer(CustomerDTO customer) throws DatabaseOperationException {
    String sql =
        "INSERT INTO Customers (CustomerID, FirstName, LastName, Email, Phone, Username,"
            + " Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      customer.setCustomerID(generateCustomerID());
      preparedStatement.setInt(1, customer.getCustomerID());
      preparedStatement.setString(2, customer.getFirstName());
      preparedStatement.setString(3, customer.getLastName());
      preparedStatement.setString(4, customer.getEmail());
      preparedStatement.setString(5, customer.getPhone());
      preparedStatement.setString(6, customer.getUsername());
      preparedStatement.setString(7, customer.getPassword());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseOperationException(
          "Error while creating customer: " + customer.getCustomerID(), e);
    }
  }

  // Read a customer by ID
  public CustomerDTO readCustomer(int customerID)
      throws DatabaseOperationException, CustomerNotFoundException {
    String sql = "SELECT * FROM Customers WHERE CustomerID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, customerID);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return mapResultSetToCustomer(resultSet);
        } else {
          throw new CustomerNotFoundException("Customer not found with ID: " + customerID);
        }
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while reading customer: " + customerID, e);
    }
  }

  // Read a customer by username
  public CustomerDTO readCustomerByUsername(String username)
      throws DatabaseOperationException, CustomerNotFoundException {
    String sql = "SELECT TOP 1 * FROM Customers WHERE Username = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, username);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return mapResultSetToCustomer(resultSet);
        } else {
          throw new CustomerNotFoundException("Customer not found with username: " + username);
        }
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException(
          "Error while reading customer by username: " + username, e);
    }
  }

  // Read all customers
  public List<CustomerDTO> readAllCustomers() throws DatabaseOperationException {
    List<CustomerDTO> customers = new ArrayList<>();
    String sql = "SELECT * FROM Customers";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()) {
      while (resultSet.next()) {
        customers.add(mapResultSetToCustomer(resultSet));
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while reading all customers.", e);
    }
    return customers;
  }

  // Update a customer
  public void updateCustomer(CustomerDTO customer) throws DatabaseOperationException {
    String sql =
        "UPDATE Customers SET FirstName = ?, LastName = ?, Email = ?, Phone = ?, Username ="
            + " ?, Password = ? WHERE CustomerID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setString(1, customer.getFirstName());
      preparedStatement.setString(2, customer.getLastName());
      preparedStatement.setString(3, customer.getEmail());
      preparedStatement.setString(4, customer.getPhone());
      preparedStatement.setString(5, customer.getUsername());
      preparedStatement.setString(6, customer.getPassword());
      preparedStatement.setInt(7, customer.getCustomerID());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseOperationException(
          "Error while updating customer: " + customer.getCustomerID(), e);
    }
  }

  // Delete a customer by ID
  public void deleteCustomer(int customerID) throws DatabaseOperationException {
    String sql = "DELETE FROM Customers WHERE CustomerID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, customerID);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while deleting customer: " + customerID, e);
    }
  }

  // Helper method to map ResultSet to CustomerDTO
  private CustomerDTO mapResultSetToCustomer(ResultSet resultSet)
      throws DatabaseOperationException {
    try {
      CustomerDTO customer = new CustomerDTO();
      customer.setCustomerID(resultSet.getInt("CustomerID"));
      customer.setFirstName(resultSet.getString("FirstName"));
      customer.setLastName(resultSet.getString("LastName"));
      customer.setEmail(resultSet.getString("Email"));
      customer.setPhone(resultSet.getString("Phone"));
      customer.setUsername(resultSet.getString("Username"));
      customer.setPassword(resultSet.getString("Password"));
      return customer;
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while mapping vehicle", e);
    }
  }
}
