package com.HitnRun.utils;

import com.HitnRun.handlers.DatabaseException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareTestDatabase {
  // SQL commands for database and table creation
  private static final String CREATE_DATABASE = "CREATE DATABASE hitnruntest";
  private static final String USE_DATABASE = "USE hitnruntest";
  private static final String CREATE_TABLES =
      ""
          + // Create 'Customers' table
          "CREATE TABLE Customers ("
          + //
          "    CustomerID INT PRIMARY KEY,"
          + //
          "    FirstName VARCHAR(50),"
          + //
          "    LastName VARCHAR(50),"
          + //
          "    Email VARCHAR(100),"
          + //
          "    Phone VARCHAR(20),"
          + //
          "    Username VARCHAR(50),"
          + //
          "    Password VARCHAR(50)"
          + //
          ");"
          + // Create 'Vehicles' table
          "CREATE TABLE Vehicles ("
          + //
          "    VehicleID INT PRIMARY KEY,"
          + //
          "    Make VARCHAR(50),"
          + //
          "    Model VARCHAR(50),"
          + //
          "    Year INT,"
          + //
          "    LicensePlate VARCHAR(20),"
          + //
          "    Description VARCHAR(400),"
          + //
          "    Color VARCHAR(20),"
          + //
          "    Rating DECIMAL(3, 2),"
          + //
          "    Rent DECIMAL(10, 2),"
          + //
          "    ImagePath VARCHAR(255)"
          + //
          ");"
          + // Create 'Staff' table
          "CREATE TABLE Staff ("
          + //
          "    StaffID INT PRIMARY KEY,"
          + //
          "    FirstName VARCHAR(50),"
          + //
          "    LastName VARCHAR(50),"
          + //
          "    Position VARCHAR(50),"
          + //
          "    Email VARCHAR(100),"
          + //
          "    Phone VARCHAR(20),"
          + //
          "    Username VARCHAR(50),"
          + //
          "    Password VARCHAR(50),"
          + //
          ");"
          + // Create 'Rental' table
          "CREATE TABLE Rental ("
          + //
          "    RentalID INT PRIMARY KEY,"
          + //
          "    CustomerID INT,"
          + //
          "    VehicleID INT,"
          + //
          "    RentalDate TIMESTAMP,"
          + //
          "    ReturnDate TIMESTAMP,"
          + //
          "    RentalFee DECIMAL(10, 2),"
          + //
          "    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),"
          + //
          "    FOREIGN KEY (VehicleID) REFERENCES Vehicles(VehicleID)"
          + //
          ");"
          + // Create 'Maintenance' table
          "CREATE TABLE Maintenance ("
          + //
          "    MaintenanceID INT PRIMARY KEY,"
          + //
          "    VehicleID INT,"
          + //
          "    MaintenanceDate TIMESTAMP,"
          + //
          "    Description VARCHAR(400),"
          + //
          "    Cost DECIMAL(10, 2),"
          + //
          "    FOREIGN KEY (VehicleID) REFERENCES Vehicles(VehicleID)"
          + //
          ");";

  public static void createDatabase() {
    try (Connection connection = HSQLDBConnector.getTestConnection();
        Statement statement = connection.createStatement()) {
      // Create the "hitnrun" database
      // statement.executeUpdate(CREATE_DATABASE);
      // statement.executeUpdate(USE_DATABASE);

      // Create tables within the "hitnrun" database
      statement.executeUpdate(CREATE_TABLES);
    } catch (SQLException e) {
      e.printStackTrace();
      throw new DatabaseException("Failed to create the database or tables.", e);
    }
  }

  public static void main(String[] args) {
    try {
      createDatabase();
      System.out.println("Database and tables created successfully.");
    } catch (DatabaseException e) {
      System.err.println("Database Exception: " + e.getMessage());
    }
  }
}
