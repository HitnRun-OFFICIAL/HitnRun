import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {
    private Connection connection;

    public PaymentDao(Connection connection) {
        this.connection = connection;
    }

    // Create a Payment record
    public void createPayment(PaymentDTO payment) throws SQLException {
        String sql = "INSERT INTO Payments (RentalID, PaymentDate, Amount) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, payment.getRentalID());
            preparedStatement.setTimestamp(2, payment.getPaymentDate());
            preparedStatement.setDouble(3, payment.getAmount());
            preparedStatement.executeUpdate();
        }
    }

    // Read a Payment record by ID
    public PaymentDTO readPayment(int paymentID) throws SQLException {
        String sql = "SELECT * FROM Payments WHERE PaymentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, paymentID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToPayment(resultSet);
                }
            }
        }
        return null; // Payment record not found
    }

    // Read all Payment records for a specific rental
    public List<PaymentDTO> readAllPaymentsForRental(int rentalID) throws SQLException {
        List<PaymentDTO> payments = new ArrayList<>();
        String sql = "SELECT * FROM Payments WHERE RentalID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, rentalID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    payments.add(mapResultSetToPayment(resultSet));
                }
            }
        }
        return payments;
    }

    // Update a Payment record
    public void updatePayment(PaymentDTO payment) throws SQLException {
        String sql = "UPDATE Payments SET RentalID = ?, PaymentDate = ?, Amount = ? WHERE PaymentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, payment.getRentalID());
            preparedStatement.setTimestamp(2, payment.getPaymentDate());
            preparedStatement.setDouble(3, payment.getAmount());
            preparedStatement.setInt(4, payment.getPaymentID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete a Payment record by ID
    public void deletePayment(int paymentID) throws SQLException {
        String sql = "DELETE FROM Payments WHERE PaymentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, paymentID);
            preparedStatement.executeUpdate();
        }
    }

    // Helper method to map ResultSet to PaymentDTO
    private PaymentDTO mapResultSetToPayment(ResultSet resultSet) throws SQLException {
        PaymentDTO payment = new PaymentDTO();

        payment.setPaymentID(resultSet.getInt("PaymentID"));
        payment.setRentalID(resultSet.getInt("RentalID"));
        payment.setPaymentDate(resultSet.getTimestamp("PaymentDate"));
        payment.setAmount(resultSet.getDouble("Amount"));

        return payment;
    }
}
