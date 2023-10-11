package com.HitnRun.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.HitnRun.handlers.DatabaseOperationException;
import com.HitnRun.handlers.MaintenanceNotFoundException;
import com.HitnRun.models.MaintenanceDTO;
import com.HitnRun.models.VehicleDTO;
import com.HitnRun.utils.MSSQLJDBConnector;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MaintenanceDAOTest {
    private MaintenanceDAO maintenanceDAO;
    private MaintenanceDTO maintenance;
    private VehicleDAO vehicleDAO;
    private VehicleDTO vehicle;

    @BeforeAll
    void setUp() {

        Connection connection = MSSQLJDBConnector.getConnection("hitnruntest");
        
        try {
            vehicleDAO = new VehicleDAO(connection);
            vehicle = new VehicleDTO("test", "test", 1000, "test", "test", "test", 5, null);
            vehicleDAO.createVehicle(vehicle);
            
        } catch (DatabaseOperationException e) {
            fail(e.getMessage(), e);

        }
        maintenanceDAO = new MaintenanceDAO(connection);

        // Create a test maintenance record to be used in various test methods
        maintenance = new MaintenanceDTO(1, new Date(0), "I'm batman", 1000);
    }

    @AfterAll
    void tearDown() throws DatabaseOperationException {
        try (Connection connection = MSSQLJDBConnector.getConnection("hitnruntest");
            Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM " + "maintenance");
            statement.execute("DELETE FROM " + "vehicles");
        } catch (SQLException e) {
            throw new DatabaseOperationException("Error while tear down", e);
        }
    }

    @Test
    void testCreateMaintenance() {
        try {
            // Create a maintenance record
            maintenanceDAO.createMaintenance(maintenance);

            // Retrieve the created maintenance record and assert its properties
            MaintenanceDTO createdMaintenance =
                    maintenanceDAO.readMaintenance(maintenance.getMaintenanceID());
            assertNotNull(createdMaintenance);
            assertEquals(maintenance.getDescription(), createdMaintenance.getDescription());
            assertEquals(maintenance.getCost(), createdMaintenance.getCost());
            // Add more assertions for other properties
        } catch (DatabaseOperationException | MaintenanceNotFoundException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void testDeleteMaintenance() {
        try {
            // Create a maintenance record first
            maintenanceDAO.createMaintenance(maintenance);

            // Delete the maintenance record
            maintenanceDAO.deleteMaintenance(maintenance.getMaintenanceID());

            // Try to read the deleted maintenance record, should result in
            // MaintenanceNotFoundException
            assertThrows(
                    MaintenanceNotFoundException.class,
                    () -> maintenanceDAO.readMaintenance(maintenance.getMaintenanceID()));
        } catch (DatabaseOperationException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void testReadMaintenance() {
        try {
            // Create a maintenance record first
            maintenanceDAO.createMaintenance(maintenance);

            // Read the maintenance record and assert its properties
            MaintenanceDTO readMaintenance =
                    maintenanceDAO.readMaintenance(maintenance.getMaintenanceID());
            assertNotNull(readMaintenance);
            assertEquals(maintenance.getDescription(), readMaintenance.getDescription());
            assertEquals(maintenance.getCost(), readMaintenance.getCost());
            // Add more assertions for other properties
        } catch (DatabaseOperationException | MaintenanceNotFoundException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void testUpdateMaintenance() {
        try {
            // Create a maintenance record first
            maintenanceDAO.createMaintenance(maintenance);

            // Modify some properties of the maintenance record
            maintenance.setDescription("I'm not batman");
            maintenance.setCost(2000);

            // Update the maintenance record in the database
            maintenanceDAO.updateMaintenance(maintenance);

            // Retrieve the updated maintenance record and assert its properties
            MaintenanceDTO updatedMaintenance =
                    maintenanceDAO.readMaintenance(maintenance.getMaintenanceID());
            assertNotNull(updatedMaintenance);
            assertEquals(maintenance.getDescription(), updatedMaintenance.getDescription());
            assertEquals(maintenance.getCost(), updatedMaintenance.getCost());
            // Add more assertions for other properties
        } catch (DatabaseOperationException | MaintenanceNotFoundException e) {
            fail(e.getMessage(), e);
        }
    }

    @Test
    void testReadAllMaintenanceForVehicle() {
        try {
            // Create maintenance records for a specific vehicle or ensure there are
            // existing maintenance records in the database

            // Read all maintenance records for the vehicle
            List<MaintenanceDTO> maintenanceRecords =
                    maintenanceDAO.readAllMaintenanceForVehicle(maintenance.getVehicleID());
            assertNotNull(maintenanceRecords);

            // Iterate through the maintenance records and make assertions
            for (MaintenanceDTO maintenanceRecord : maintenanceRecords) {
                assertNotNull(maintenanceRecord);
                // Add assertions for each maintenance record's properties
            }
        } catch (DatabaseOperationException e) {
            fail(e.getMessage(), e);
        }
    }
}
