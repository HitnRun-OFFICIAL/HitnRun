package com.HitnRun.repositories;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.PaymentNotFoundException;
import com.HitnRun.models.PaymentsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAO {
  private Connection connection;

  public PaymentsDAO(Connection connection) {
    this.connection = connection;
  }

  public int generatePaymentID() throws DatabaseOperationException {
    String sql = "SELECT MAX(PaymentID) FROM Payments";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getInt(1) + 1;
      } else {
        return 1;
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error in generating new paymentID", e);
    }
  }

  // Create a Payment record
  public void createPayment(PaymentsDTO payment) throws DatabaseOperationException {
    String sql =
        "INSERT INTO Payments (PaymentID, RentalID, PaymentDate, Amount) VALUES (?, ?, ?," + " ?)";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      payment.setPaymentID(generatePaymentID());
      preparedStatement.setInt(1, payment.getPaymentID());
      preparedStatement.setInt(2, payment.getRentalID());
      preparedStatement.setDate(3, payment.getPaymentDate());
      preparedStatement.setDouble(4, payment.getAmount());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseOperationException(
          "Error while creating payment: " + payment.getPaymentID(), e);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Read a Payment record by ID
  public PaymentsDTO readPayment(int paymentID)
      throws DatabaseOperationException, PaymentNotFoundException {
    String sql = "SELECT * FROM Payments WHERE PaymentID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, paymentID);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        if (resultSet.next()) {
          return mapResultSetToPayment(resultSet);
        } else {
          throw new PaymentNotFoundException("Payment not found with ID: " + paymentID);
        }
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while reading payment ID: " + paymentID, e);
    }
  }

  // Read all Payment records for a specific rental
  public List<PaymentsDTO> readAllPaymentsForRental(int rentalID)
      throws DatabaseOperationException {
    List<PaymentsDTO> payments = new ArrayList<>();
    String sql = "SELECT * FROM Payments WHERE RentalID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, rentalID);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          payments.add(mapResultSetToPayment(resultSet));
        }
      }
    } catch (SQLException e) {
      throw new DatabaseOperationException(
          "Error while reading payment for rental: " + rentalID, e);
    }
    return payments;
  }

  // Update a Payment record
  public void updatePayment(PaymentsDTO payment) throws DatabaseOperationException {
    String sql =
        "UPDATE Payments SET RentalID = ?, PaymentDate = ?, Amount = ? WHERE PaymentID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, payment.getRentalID());
      preparedStatement.setDate(2, payment.getPaymentDate());
      preparedStatement.setDouble(3, payment.getAmount());
      preparedStatement.setInt(4, payment.getPaymentID());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseOperationException(
          "Error while updating payment: " + payment.getPaymentID(), e);
    }
  }

  // Delete a Payment record by ID
  public void deletePayment(int paymentID) throws DatabaseOperationException {
    String sql = "DELETE FROM Payments WHERE PaymentID = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setInt(1, paymentID);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while deleting payment: " + paymentID, e);
    }
  }

  // Helper method to map ResultSet to PaymentsDTO
  private PaymentsDTO mapResultSetToPayment(ResultSet resultSet) throws DatabaseOperationException {
    try {
      PaymentsDTO payment = new PaymentsDTO();

      payment.setPaymentID(resultSet.getInt("PaymentID"));
      payment.setRentalID(resultSet.getInt("RentalID"));
      payment.setPaymentDate(resultSet.getDate("PaymentDate"));
      payment.setAmount(resultSet.getDouble("Amount"));

      return payment;
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while mapping payment", e);
    }
  }
}
