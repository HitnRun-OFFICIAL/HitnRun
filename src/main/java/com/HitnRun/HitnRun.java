package com.HitnRun;

import java.sql.Connection;

import com.HitnRun.handlers.DatabaseException;
import com.HitnRun.utils.MSSQLJDBConnector;

public class HitnRun {
    public static void main(String[] args) {
        try (Connection connection = MSSQLJDBConnector.getConnection()) {
            //
        } catch (DatabaseException e) {
            System.err.println("Database Exception: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}