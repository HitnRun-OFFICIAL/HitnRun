package com.HitnRun.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.VehicleNotFoundException;
import com.HitnRun.models.VehicleDTO;

public class VehicleDAO {
    private Connection connection;

    public VehicleDAO(Connection connection) {
        this.connection = connection;
    }

    public void createVehicle(VehicleDTO vehicle) throws DatabaseOperationException {
        String sql = "INSERT INTO Vehicles (VehicleID, Make, Model, Year, LicensePlate, Description, Color, Rating, ImagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicle.getVehicleID());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setString(5, vehicle.getLicensePlate());
            preparedStatement.setString(6, vehicle.getDescription());
            preparedStatement.setString(7, vehicle.getColor());
            preparedStatement.setDouble(8, vehicle.getRating());
            preparedStatement.setString(9, vehicle.getImagePath());
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while creating vehicle: " + vehicle.getVehicleID(), e);
        }
    }

    // Read a Vehicle by ID
    public VehicleDTO readVehicle(int vehicleID) throws DatabaseOperationException, VehicleNotFoundException {
        String sql = "SELECT * FROM Vehicles WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToVehicle(resultSet);
                } else {
                    throw new VehicleNotFoundException("Vehicle not found with ID: " + vehicleID);
                }
            }
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while reading vehicle: " + vehicleID, e);
        }
    }

    // Add other reads If necessary

    // Read all Vehicles
    public List<VehicleDTO> readAllVehicles() throws DatabaseOperationException {
        List<VehicleDTO> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicles";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                vehicles.add(mapResultSetToVehicle(resultSet));
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while reading vehicles.", e);
        }
        return vehicles;
    }

    // Update a Vehicle
    public void updateVehicle(VehicleDTO vehicle) throws DatabaseOperationException {
        String sql = "UPDATE Vehicles SET Make = ? , Model = ? , Year = ? , LicensePlate = ? , Description = ?, Color = ?,Rating = ?,ImagePath = ? WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicle.getVehicleID());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setInt(4, vehicle.getYear());
            preparedStatement.setString(5, vehicle.getLicensePlate());
            preparedStatement.setString(6, vehicle.getDescription());
            preparedStatement.setString(7, vehicle.getColor());
            preparedStatement.setDouble(8, vehicle.getRating());
            preparedStatement.setString(9, vehicle.getImagePath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while updating vehicle: " + vehicle.getVehicleID(), e);
        }
    }

    // Delete a Vehicle by ID
    public void deleteVehicle(int vehicleID) throws DatabaseOperationException {
        String sql = "DELETE FROM Vehicles WHERE VehicleID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while deleting vehicle: " + vehicleID, e);
        }
    }

    // Helper method to map ResultSet to VehicleDTO
    private VehicleDTO mapResultSetToVehicle(ResultSet resultSet) throws SQLException {
        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setVehicleID(resultSet.getInt("VehicleID"));
        vehicle.setMake(resultSet.getString("Make"));
        vehicle.setModel(resultSet.getString("Model"));
        vehicle.setYear(resultSet.getInt("Year"));
        vehicle.setLicensePlate(resultSet.getString("LisensePlate"));
        vehicle.setMake(resultSet.getString("Make"));
        vehicle.setRating(resultSet.getDouble("Rating"));
        vehicle.setImagePath(resultSet.getString("ImagePath"));
        return vehicle;
    }

}
