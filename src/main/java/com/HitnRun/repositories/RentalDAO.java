package com.HitnRun.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.RentalNotFoundException;
import com.HitnRun.models.RentalDTO;

public class RentalDAO {
    private Connection connection;

    public RentalDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a Rental record
    public void createRental(RentalDTO rental) throws DatabaseOperationException {
        String sql = "INSERT INTO Rental (RentalID, CustomerID, VehicleID, StaffID, RentalDate, ReturnDate, RentalFee) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rental.getRentalID());
            preparedStatement.setInt(2, rental.getCustomerID());
            preparedStatement.setInt(3, rental.getVehicleID());
            preparedStatement.setInt(4, rental.getStaffID());
            preparedStatement.setDate(5, rental.getRentalDate());
            preparedStatement.setDate(6, rental.getReturnDate());
            preparedStatement.setDouble(7, rental.getRentalFee());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while creating rental: " + rental.getRentalID(), e);
        }
    }

    // Read a Rental record by ID
    public RentalDTO readRental(int rentalID) throws DatabaseOperationException, RentalNotFoundException {
        String sql = "SELECT * FROM Rental WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rentalID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToRental(resultSet);
                } else {
                    throw new RentalNotFoundException("Rental not found with ID: " + rentalID);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while reading rental: " + rentalID, e);
        }
    }

    // Read all Rental records for a specific customer
    public List<RentalDTO> readAllRentalsForCustomer(int customerID) throws DatabaseOperationException {
        List<RentalDTO> rentals = new ArrayList<>();
        String sql = "SELECT * FROM Rental WHERE CustomerID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    rentals.add(mapResultSetToRental(resultSet));
                }
            }
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while reading rentals for customer: " + customerID, e);
        }
        return rentals;
    }

    // Update a Rental record
    public void updateRental(RentalDTO rental) throws DatabaseOperationException {
        String sql = "UPDATE Rental SET CustomerID = ?, VehicleID = ?, StaffID = ?, RentalDate = ?, ReturnDate = ?, RentalFee = ? WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rental.getCustomerID());
            preparedStatement.setInt(2, rental.getVehicleID());
            preparedStatement.setInt(3, rental.getStaffID());
            preparedStatement.setDate(4, rental.getRentalDate());
            preparedStatement.setDate(5, rental.getReturnDate());
            preparedStatement.setDouble(6, rental.getRentalFee());
            preparedStatement.setInt(7, rental.getRentalID());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while updating rental: " + rental.getRentalID(), e);
        }
    }

    // Delete a Rental record by ID
    public void deleteRental(int rentalID) throws DatabaseOperationException {
        String sql = "DELETE FROM Rental WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rentalID);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while deleting rental: " + rentalID, e);
        }
    }

    // Helper method to map ResultSet to RentalDTO
    private RentalDTO mapResultSetToRental(ResultSet resultSet) throws SQLException {
        RentalDTO rental = new RentalDTO();

        rental.setRentalID(resultSet.getInt("RentalID"));
        rental.setCustomerID(resultSet.getInt("CustomerID"));
        rental.setVehicleID(resultSet.getInt("VehicleID"));
        rental.setStaffID(resultSet.getInt("StaffID"));
        rental.setRentalDate(resultSet.getDate("RentalDate"));
        rental.setReturnDate(resultSet.getDate("ReturnDate"));
        rental.setRentalFee(resultSet.getDouble("RentalFee"));

        return rental;
    }
}