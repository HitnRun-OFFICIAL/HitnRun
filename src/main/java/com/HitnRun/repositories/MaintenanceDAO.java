package com.HitnRun.repositories;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.MaintenanceNotFoundException;
import com.HitnRun.models.MaintenanceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {
    private Connection connection;

    public MaintenanceDAO(Connection connection) {
        this.connection = connection;
    }

    public int generateMaintenanceID() throws DatabaseOperationException {
        String sql = "SELECT MAX(MaintenanceID) FROM Maintenance";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) + 1;
            } else {
                return 1;
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error in generating new MaintenanceID", e);
        }
    }

    // Create a Maintenance record
    public void createMaintenance(MaintenanceDTO maintenance) throws DatabaseOperationException {
        String sql =
                "INSERT INTO Maintenance (MaintenanceID, VehicleID, MaintenanceDate, Description,"
                    + " Cost) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            maintenance.setMaintenanceID(generateMaintenanceID());
            preparedStatement.setInt(1, maintenance.getMaintenanceID());
            preparedStatement.setInt(2, maintenance.getVehicleID());
            preparedStatement.setDate(3, maintenance.getMaintenanceDate());
            preparedStatement.setString(4, maintenance.getDescription());
            preparedStatement.setDouble(5, maintenance.getCost());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(
                    "Error while creating maintenance: " + maintenance.getMaintenanceID(), e);
        }
    }

    // Read a Maintenance record by ID
    public MaintenanceDTO readMaintenance(int maintenanceID)
            throws DatabaseOperationException, MaintenanceNotFoundException {
        String sql = "SELECT * FROM Maintenance WHERE MaintenanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenanceID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToMaintenance(resultSet);
                } else {
                    throw new MaintenanceNotFoundException(
                            "Maintenance not found with ID: " + maintenanceID);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(
                    "Error while reading maintenance: " + maintenanceID, e);
        }
    }

    // Read all Maintenance records for a specific vehicle
    public List<MaintenanceDTO> readAllMaintenanceForVehicle(int vehicleID)
            throws DatabaseOperationException {
        List<MaintenanceDTO> maintenanceList = new ArrayList<>();
        String sql = "SELECT * FROM Maintenance WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    maintenanceList.add(mapResultSetToMaintenance(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException(
                    "Error while reading all maintenance by vehicle ID: " + vehicleID, e);
        }
        return maintenanceList;
    }

    // Update a Maintenance record
    public void updateMaintenance(MaintenanceDTO maintenance) throws DatabaseOperationException {
        String sql =
                "UPDATE Maintenance SET VehicleID = ?, MaintenanceDate = ?, Description = ?, Cost ="
                    + " ? WHERE MaintenanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenance.getVehicleID());
            preparedStatement.setDate(2, maintenance.getMaintenanceDate());
            preparedStatement.setString(3, maintenance.getDescription());
            preparedStatement.setDouble(4, maintenance.getCost());
            preparedStatement.setInt(5, maintenance.getMaintenanceID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(
                    "Error while updating maintenance: " + maintenance.getMaintenanceID(), e);
        }
    }

    // Delete a Maintenance record by ID
    public void deleteMaintenance(int maintenanceID) throws DatabaseOperationException {
        String sql = "DELETE FROM Maintenance WHERE MaintenanceID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maintenanceID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(
                    "Error while deleting maintenace: " + maintenanceID, e);
        }
    }

    // Helper method to map ResultSet to MaintenanceDTO
    private MaintenanceDTO mapResultSetToMaintenance(ResultSet resultSet)
            throws DatabaseOperationException {
                try {
            MaintenanceDTO maintenance = new MaintenanceDTO();
            maintenance.setMaintenanceID(resultSet.getInt("MaintenanceID"));
            maintenance.setVehicleID(resultSet.getInt("VehicleID"));
            maintenance.setMaintenanceDate(resultSet.getDate("MaintenanceDate"));
            maintenance.setDescription(resultSet.getString("Description"));
            maintenance.setCost(resultSet.getDouble("Cost"));
            return maintenance;
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while mapping maintenance.", e);
        }
    }
}
