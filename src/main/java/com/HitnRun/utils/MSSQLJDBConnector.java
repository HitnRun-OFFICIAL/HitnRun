package com.HitnRun.utils;

import com.HitnRun.handlers.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLJDBConnector {

  private static String JDBC_URL = "jdbc:sqlserver://localhost:1433;encrypt=false";
  private static String JDBC_USER = "SA";
  private static String JDBC_PASSWORD = "admin!23";

  public static Connection getConnection(String database) {
    try {
      Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
      if (database.equals("hitnrun") || database.equals("hitnruntest")) {
        connection.createStatement().execute("USE " + database);
      }
      return connection;
    } catch (SQLException e) {
      e.printStackTrace();
      throw new DatabaseException("Faild to establish a database connection.", e);
    }
  }

  public static Connection getConnection() {
    return getConnection("");
  }
}
