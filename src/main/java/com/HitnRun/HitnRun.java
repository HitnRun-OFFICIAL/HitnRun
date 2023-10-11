package com.HitnRun;

import com.HitnRun.handlers.DatabaseException;
import com.HitnRun.utils.MSSQLJDBConnector;

import java.sql.Connection;

public class HitnRun {
    public static void main(String[] args) {
        try (Connection connection = MSSQLJDBConnector.getConnection()) {
            System.out.println("Hello mfs!!");
        } catch (DatabaseException e) {
            System.err.println("Database Exception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
