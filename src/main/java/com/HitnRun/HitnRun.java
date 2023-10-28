package com.HitnRun;

import com.HitnRun.views.BaseFrame;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;

public class HitnRun {
  public static void main(String[] args) {
    // Initialize the Flat Dark Flat IntelliJ theme for the user interface.
    FlatDarkFlatIJTheme.setup();
    // Launch the main application window.
    BaseFrame.main(args);

    // Uncomment and modify it if you need to connect to a database and handle exceptions.
    /*
    try (Connection connection = MSSQLJDBConnector.getConnection()) {
         System.out.println("Hello!!");
       } catch (DatabaseException e) {
         System.err.println("Database Exception: " + e.getMessage());
       } catch (Exception e) {
         e.printStackTrace();
       }
       */
  }
}
