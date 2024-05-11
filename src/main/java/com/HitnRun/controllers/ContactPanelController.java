package com.HitnRun.controllers;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.models.StaffDTO;
import com.HitnRun.repositories.StaffDAO;
import com.HitnRun.utils.HSQLDBConnector;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ContactPanelController {
  private Connection connection;
  private StaffDAO staffDAO;
  private List<StaffDTO> staffs;

  // Constructor to initialize the controller
  public ContactPanelController() {
    // Get a database connection using the HSQLDBConnector
    this.connection = HSQLDBConnector.getConnection();
    // Create a data access object (DAO) for staff using the connection
    this.staffDAO = new StaffDAO(connection);
    // Initialize a list to hold staff information
    this.staffs = new ArrayList<StaffDTO>();
  }

  // Method to retrieve staff information and return it as a 2D array
  public Object[][] getStaffs() {
    try {
      // Retrieve staff information from the database using the DAO and add it to the list
      staffs.addAll(staffDAO.readAllStaff());
      // Create a 2D array to store the staff information for display
      Object[][] staffTable = new Object[staffs.size()][];
      for (int i = 0; i < staffs.size(); i++) {
        StaffDTO s = staffs.get(i);
        // Create an array of staff details and store it in the 2D array
        staffTable[i] =
            new Object[] {
              s.getFirstName(), s.getLastName(), s.getEmail(), s.getPhone(), s.getPosition()
            };
      }
      // Return the 2D array with staff information
      return staffTable;
    } catch (DatabaseOperationException e) {
      // Handle any exceptions related to database operations and print an error message
      System.err.println(e.getMessage());
    }
    // Return null if there was an error or no staff information was retrieved
    return null;
  }
}
