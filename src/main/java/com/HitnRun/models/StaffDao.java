import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {
    private Connection connection;

    public StaffDao(Connection connection) {
        this.connection = connection;
    }

    // Create a Staff member
    public void createStaff(StaffDTO staff) throws SQLException {
        String sql = "INSERT INTO Staff (FirstName, LastName, Position, Email, Phone, Username, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getPosition());
            preparedStatement.setString(4, staff.getEmail());
            preparedStatement.setString(5, staff.getPhone());
            preparedStatement.setString(6, staff.getUsername());
            preparedStatement.setString(7, staff.getPassword());
            preparedStatement.executeUpdate();
        }
    }

    // Read a Staff member by ID
    public StaffDTO readStaff(int staffID) throws SQLException {
        String sql = "SELECT * FROM Staff WHERE StaffID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, staffID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToStaff(resultSet);
                }
            }
        }
        return null; // Staff member not found
    }

    // Read all Staff members
    public List<StaffDTO> readAllStaff() throws SQLException {
        List<StaffDTO> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                staffList.add(mapResultSetToStaff(resultSet));
            }
        }
        return staffList;
    }

    // Update a Staff member
    public void updateStaff(StaffDTO staff) throws SQLException {
        String sql = "UPDATE Staff SET FirstName = ?, LastName = ?, Position = ?, Email = ?, Phone = ?, Username = ?, Password = ? WHERE StaffID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getPosition());
            preparedStatement.setString(4, staff.getEmail());
            preparedStatement.setString(5, staff.getPhone());
            preparedStatement.setString(6, staff.getUsername());
            preparedStatement.setString(7, staff.getPassword());
            preparedStatement.setInt(8, staff.getStaffID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete a Staff member by ID
    public void deleteStaff(int staffID) throws SQLException {
        String sql = "DELETE FROM Staff WHERE StaffID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, staffID);
            preparedStatement.executeUpdate();
        }
    }

    // Helper method to map ResultSet to StaffDTO
    private StaffDTO mapResultSetToStaff(ResultSet resultSet) throws SQLException {
        StaffDTO staff = new StaffDTO();

        staff.setStaffID(resultSet.getInt("StaffID"));
        staff.setFirstName(resultSet.getString("FirstName"));
        staff.setLastName(resultSet.getString("LastName"));
        staff.setPosition(resultSet.getString("Position"));
        staff.setEmail(resultSet.getString("Email"));
        staff.setPhone(resultSet.getString("Phone"));
        staff.setUsername(resultSet.getString("Username"));
        staff.setPassword(resultSet.getString("Password"));

        return staff;
    }
}
