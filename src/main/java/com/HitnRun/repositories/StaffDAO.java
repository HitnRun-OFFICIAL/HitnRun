package com.HitnRun.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.StaffNotFoundException;
import com.HitnRun.models.StaffDTO;

public class StaffDAO {
    private Connection connection;

    public StaffDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a Staff member
    public void createStaff(StaffDTO staff) throws DatabaseOperationException {
        String sql = "INSERT INTO Staff (FirstName, LastName, Position, Email, Phone, Username, Password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, staff.getStaffID());
            preparedStatement.setString(2, staff.getFirstName());
            preparedStatement.setString(3, staff.getLastName());
            preparedStatement.setString(4, staff.getPosition());
            preparedStatement.setString(5, staff.getEmail());
            preparedStatement.setString(6, staff.getPhone());
            preparedStatement.setString(7, staff.getUserName());
            preparedStatement.setString(8, staff.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while creating staff: " + staff.getStaffID(), e);
        }
    }

    // Read a Staff member by ID
    public StaffDTO readStaff(int staffID) throws DatabaseOperationException, StaffNotFoundException {
        String sql = "SELECT * FROM Staff WHERE StaffID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, staffID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToStaff(resultSet);
                } else {
                    throw new StaffNotFoundException("Staff not found with ID: " + staffID);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while reading staff: " + staffID, e);
        }
    }

    // Read all Staff members
    public List<StaffDTO> readAllStaff() throws DatabaseOperationException {
        List<StaffDTO> staffList = new ArrayList<>();
        String sql = "SELECT * FROM Staff";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                staffList.add(mapResultSetToStaff(resultSet));
            }
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while reading all staffs.", e);
        }
        return staffList;
    }

    // Update a Staff member
    public void updateStaff(StaffDTO staff) throws DatabaseOperationException {
        String sql = "UPDATE Staff SET FirstName = ?, LastName = ?, Position = ?, Email = ?, Phone = ?, Username = ?, Password = ? WHERE StaffID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, staff.getFirstName());
            preparedStatement.setString(2, staff.getLastName());
            preparedStatement.setString(3, staff.getPosition());
            preparedStatement.setString(4, staff.getEmail());
            preparedStatement.setString(5, staff.getPhone());
            preparedStatement.setString(6, staff.getUserName());
            preparedStatement.setString(7, staff.getPassword());
            preparedStatement.setInt(8, staff.getStaffID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while updating staff: " + staff.getStaffID(), e);
        }
    }

    // Delete a Staff member by ID
    public void deleteStaff(int staffID) throws DatabaseOperationException {
        String sql = "DELETE FROM Staff WHERE StaffID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, staffID);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            throw new DatabaseOperationException("Error while deleting staff: " + staffID, e);
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
        staff.setUserName(resultSet.getString("Username"));
        staff.setPassword(resultSet.getString("Password"));

        return staff;
    }
}
