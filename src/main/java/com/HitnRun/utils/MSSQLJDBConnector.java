package com.HitnRun.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.HitnRun.handlers.DatabaseException;

public class MSSQLJDBConnector {
    
    private static String JDBC_URL = "jdbc:sqlserver://localhost:1433;encrypt=false";
    private static String JDBC_USER = "SA";
    private static String JDBC_PASSWORD = "admin!23";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch(SQLException e) {
            e.printStackTrace();
            throw new DatabaseException("Faild to establish a database connection.", e);
        }
    }
}
