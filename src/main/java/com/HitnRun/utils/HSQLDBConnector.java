package com.HitnRun.utils;

import com.HitnRun.handlers.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLDBConnector {
  // Define the URL for the main database.
  private static final String DB_URL = "jdbc:hsqldb:file:db/main/hitnrun";
  // Define the URL for the test database.
  private static final String TEST_DB_URL = "jdbc:hsqldb:file:db/test/hitnruntest";
  // Database username.
  private static final String DB_USER = "SA";
  // Database password (empty in this example).
  private static final String DB_PASSWORD = "";

  static {
    try {
      // Load the HSQLDB JDBC driver when this class is initialized.
      Class.forName("org.hsqldb.jdbc.JDBCDriver");
    } catch (ClassNotFoundException e) {
      // If the driver cannot be loaded, throw a runtime exception with an error message.
      throw new RuntimeException("Failed to load HSQLDB JDBC driver: " + e.getMessage(), e);
    }
  }

  // Get a connection to the main database.
  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    } catch (SQLException e) {
      // If a SQL exception occurs while connecting to the main database, throw a custom
      // DatabaseException.
      throw new DatabaseException("Failed to connect to the HSQLDB database.", e);
    }
  }

  // Get a connection to the test database.
  public static Connection getTestConnection() {
    try {
      return DriverManager.getConnection(TEST_DB_URL, DB_USER, DB_PASSWORD);
    } catch (SQLException e) {
      // If a SQL exception occurs while connecting to the test database, throw a custom
      // DatabaseException.
      throw new DatabaseException("Failed to connect to the HSQLDB Test database.", e);
    }
  }
}
