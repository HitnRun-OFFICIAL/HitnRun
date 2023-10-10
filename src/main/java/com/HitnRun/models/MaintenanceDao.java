
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDao {
    private Connection connection;

    public MaintenanceDao(Connection connection) {
        this.connection = connection;
    }

    // Create a Maintenance record
    public void createMaintenance(MaintenanceDTO maintenance) throws SQLException {
        String sql = "INSERT INTO Maintenance (VehicleID, MaintenanceDate, Description, Cost) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenance.getVehicleID());
            preparedStatement.setTimestamp(2, maintenance.getMaintenanceDate());
            preparedStatement.setString(3, maintenance.getDescription());
            preparedStatement.setDouble(4, maintenance.getCost());
            preparedStatement.executeUpdate();
        }
    }

    // Read a Maintenance record by ID
    public MaintenanceDTO readMaintenance(int maintenanceID) throws SQLException {
        String sql = "SELECT * FROM Maintenance WHERE MaintenanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenanceID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToMaintenance(resultSet);
                }
            }
        }
        return null; // Maintenance record not found
    }

    // Read all Maintenance records for a specific vehicle
    public List<MaintenanceDTO> readAllMaintenanceForVehicle(int vehicleID) throws SQLException {
        List<MaintenanceDTO> maintenanceList = new ArrayList<>();
        String sql = "SELECT * FROM Maintenance WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    maintenanceList.add(mapResultSetToMaintenance(resultSet));
                }
            }
        }
        return maintenanceList;
    }

    // Update a Maintenance record
    public void updateMaintenance(MaintenanceDTO maintenance) throws SQLException {
        String sql = "UPDATE Maintenance SET VehicleID = ?, MaintenanceDate = ?, Description = ?, Cost = ? WHERE MaintenanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenance.getVehicleID());
            preparedStatement.setTimestamp(2, maintenance.getMaintenanceDate());
            preparedStatement.setString(3, maintenance.getDescription());
            preparedStatement.setDouble(4, maintenance.getCost());
            preparedStatement.setInt(5, maintenance.getMaintenanceID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete a Maintenance record by ID
    public void deleteMaintenance(int maintenanceID) throws SQLException {
        String sql = "DELETE FROM Maintenance WHERE MaintenanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenanceID);
            preparedStatement.executeUpdate();
        }
    }

    // Helper method to map ResultSet to MaintenanceDTO
    private MaintenanceDTO mapResultSetToMaintenance(ResultSet resultSet) throws SQLException {
        MaintenanceDTO maintenance = new MaintenanceDTO();

        maintenance.setMaintenanceID(resultSet.getInt("MaintenanceID"));
        maintenance.setVehicleID(resultSet.getInt("VehicleID"));
        maintenance.setMaintenanceDate(resultSet.getTimestamp("MaintenanceDate"));
        maintenance.setDescription(resultSet.getString("Description"));
        maintenance.setCost(resultSet.getDouble("Cost"));

        return maintenance;
    }
}

