import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDao {
    private Connection connection;

    public RentalDao(Connection connection) {
        this.connection = connection;
    }

    // Create a Rental record
    public void createRental(RentalDTO rental) throws SQLException {
        String sql = "INSERT INTO Rental (CustomerID, VehicleID, StaffID, RentalDate, ReturnDate, RentalFee) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rental.getCustomerID());
            preparedStatement.setInt(2, rental.getVehicleID());
            preparedStatement.setInt(3, rental.getStaffID());
            preparedStatement.setTimestamp(4, rental.getRentalDate());
            preparedStatement.setTimestamp(5, rental.getReturnDate());
            preparedStatement.setDouble(6, rental.getRentalFee());
            preparedStatement.executeUpdate();
        }
    }

    // Read a Rental record by ID
    public RentalDTO readRental(int rentalID) throws SQLException {
        String sql = "SELECT * FROM Rental WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rentalID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToRental(resultSet);
                }
            }
        }
        return null; // Rental record not found
    }

    // Read all Rental records for a specific customer
    public List<RentalDTO> readAllRentalsForCustomer(int customerID) throws SQLException {
        List<RentalDTO> rentals = new ArrayList<>();
        String sql = "SELECT * FROM Rental WHERE CustomerID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    rentals.add(mapResultSetToRental(resultSet));
                }
            }
        }
        return rentals;
    }

    // Update a Rental record
    public void updateRental(RentalDTO rental) throws SQLException {
        String sql = "UPDATE Rental SET CustomerID = ?, VehicleID = ?, StaffID = ?, RentalDate = ?, ReturnDate = ?, RentalFee = ? WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rental.getCustomerID());
            preparedStatement.setInt(2, rental.getVehicleID());
            preparedStatement.setInt(3, rental.getStaffID());
            preparedStatement.setTimestamp(4, rental.getRentalDate());
            preparedStatement.setTimestamp(5, rental.getReturnDate());
            preparedStatement.setDouble(6, rental.getRentalFee());
            preparedStatement.setInt(7, rental.getRentalID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete a Rental record by ID
    public void deleteRental(int rentalID) throws SQLException {
        String sql = "DELETE FROM Rental WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rentalID);
            preparedStatement.executeUpdate();
        }
    }

    // Helper method to map ResultSet to RentalDTO
    private RentalDTO mapResultSetToRental(ResultSet resultSet) throws SQLException {
        RentalDTO rental = new RentalDTO();

        rental.setRentalID(resultSet.getInt("RentalID"));
        rental.setCustomerID(resultSet.getInt("CustomerID"));
        rental.setVehicleID(resultSet.getInt("VehicleID"));
        rental.setStaffID(resultSet.getInt("StaffID"));
        rental.setRentalDate(resultSet.getTimestamp("RentalDate"));
        rental.setReturnDate(resultSet.getTimestamp("ReturnDate"));
        rental.setRentalFee(resultSet.getDouble("RentalFee"));

        return rental;
    }
}
