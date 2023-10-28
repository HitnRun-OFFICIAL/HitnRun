package com.HitnRun.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.StaffNotFoundException;
import com.HitnRun.models.StaffDTO;
import com.HitnRun.utils.HSQLDBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StaffDAOTest {
  private StaffDAO staffDAO;
  private StaffDTO staff;

  @BeforeAll
  void setUp() {
    staffDAO =
        new StaffDAO(
            HSQLDBConnector.getTestConnection()); // Get a test connection from the HSQLDBConnector

    // Create a test staff member to be used in various test methods
    staff = new StaffDTO("test", "test", "test", "test", "test", "test", "test");
  }

  @AfterAll
  void tearDown() throws DatabaseOperationException {
    try (Connection connection = HSQLDBConnector.getTestConnection();
        Statement statement = connection.createStatement()) {
      statement.execute("DELETE FROM " + "staff");
    } catch (SQLException e) {
      throw new DatabaseOperationException("Error while tear down", e);
    }
  }

  @Test
  void testCreateStaff() {
    try {
      // Create a staff member
      staffDAO.createStaff(staff);

      // Retrieve the created staff member and assert its properties
      StaffDTO createdStaff = staffDAO.readStaff(staff.getStaffID());
      assertNotNull(createdStaff);
      assertEquals(staff.getFirstName(), createdStaff.getFirstName());
      assertEquals(staff.getLastName(), createdStaff.getLastName());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | StaffNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testDeleteStaff() {
    try {
      // Create a staff member first
      staffDAO.createStaff(staff);

      // Delete the staff member
      staffDAO.deleteStaff(staff.getStaffID());

      // Try to read the deleted staff member, should result in StaffNotFoundException
      assertThrows(StaffNotFoundException.class, () -> staffDAO.readStaff(staff.getStaffID()));
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadStaff() {
    try {
      // Create a staff member first
      staffDAO.createStaff(staff);

      // Read the staff member and assert its properties
      StaffDTO readStaff = staffDAO.readStaff(staff.getStaffID());
      assertNotNull(readStaff);
      assertEquals(staff.getFirstName(), readStaff.getFirstName());
      assertEquals(staff.getLastName(), readStaff.getLastName());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | StaffNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testUpdateStaff() {
    try {
      // Create a staff member first
      staffDAO.createStaff(staff);

      // Modify some properties of the staff member
      staff.setFirstName("UpdatedFirstName");
      staff.setLastName("UpdatedLastName");

      // Update the staff member in the database
      staffDAO.updateStaff(staff);

      // Retrieve the updated staff member and assert its properties
      StaffDTO updatedStaff = staffDAO.readStaff(staff.getStaffID());
      assertNotNull(updatedStaff);
      assertEquals(staff.getFirstName(), updatedStaff.getFirstName());
      assertEquals(staff.getLastName(), updatedStaff.getLastName());
      // Add more assertions for other properties
    } catch (DatabaseOperationException | StaffNotFoundException e) {
      fail(e.getMessage(), e);
    }
  }

  @Test
  void testReadAllStaff() {
    try {
      // Create staff members or ensure there are existing staff members in the database

      // Read all staff members
      List<StaffDTO> staffMembers = staffDAO.readAllStaff();
      assertNotNull(staffMembers);

      // Iterate through the staff members and make assertions
      for (StaffDTO staffMember : staffMembers) {
        assertNotNull(staffMember);
        // Add assertions for each staff member's properties
      }
    } catch (DatabaseOperationException e) {
      fail(e.getMessage(), e);
    }
  }
}
