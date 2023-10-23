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

  public ContactPanelController() {
    this.connection = HSQLDBConnector.getConnection();
    this.staffDAO = new StaffDAO(connection);
    this.staffs = new ArrayList<StaffDTO>();
  }

  public Object[][] getStaffs() {
    try {
      staffs.addAll(staffDAO.readAllStaff());
      Object[][] staffTable = new Object[staffs.size()][];
      for (int i = 0; i < staffs.size(); i++) {
        StaffDTO s = staffs.get(i);
        staffTable[i] =
            new Object[] {
              s.getFirstName(), s.getLastName(), s.getEmail(), s.getPhone(), s.getPosition()
            };
      }
      return staffTable;
    } catch (DatabaseOperationException e) {
      System.err.println(e.getMessage());
    }
    return null;
  }
}
