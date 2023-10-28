package com.HitnRun.utils;

import com.HitnRun.handlers.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLJDBConnector {

  // Define constants for the JDBC URL, username, and password
  private static String JDBC_URL = "jdbc:sqlserver://localhost:1433;encrypt=false";
  private static String JDBC_USER = "SA";
  private static String JDBC_PASSWORD = "admin!23";

  // Method to get a database connection with the option to specify the database name
  public static Connection getConnection(String database) {
    try {
      // Establish a database connection using the defined constants
      Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
      // Check if a specific database name is provided and set it as the current database
      if (database.equals("hitnrun") || database.equals("hitnruntest")) {
        connection.createStatement().execute("USE " + database);
      }
      // Return the established database connection
      return connection;
    } catch (SQLException e) {
      // If an SQL exception occurs, wrap it in a custom exception and throw it
      throw new DatabaseException("Faild to establish a database connection.", e);
    }
  }

  // Method to get a database connection without specifying a database name
  public static Connection getConnection() {
    // Call the getConnection method with an empty database name parameter
    return getConnection("");
  }
}
