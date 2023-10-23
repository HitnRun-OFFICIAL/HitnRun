package com.HitnRun.utils;

import com.HitnRun.handlers.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLDBConnector {
  private static final String DB_URL = "jdbc:hsqldb:file:db/main/hitnrun";
  private static final String TEST_DB_URL = "jdbc:hsqldb:file:db/test/hitnruntest";
  private static final String DB_USER = "SA";
  private static final String DB_PASSWORD = "";

  static {
    try {
      Class.forName("org.hsqldb.jdbc.JDBCDriver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Failed to load HSQLDB JDBC driver: " + e.getMessage(), e);
    }
  }

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    } catch (SQLException e) {
      throw new DatabaseException("Failed to connect to the HSQLDB database.", e);
    }
  }

  public static Connection getTestConnection() {
    try {
      return DriverManager.getConnection(TEST_DB_URL, DB_USER, DB_PASSWORD);
    } catch (SQLException e) {
      throw new DatabaseException("Failed to connect to the HSQLDB Test database.", e);
    }
  }
}
